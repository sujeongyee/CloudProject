package com.server.cloud.client.controller;


import java.util.ArrayList;
import java.util.HashMap;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.server.cloud.alarm.service.AlarmService;
import com.server.cloud.client.service.ClientService;
import com.server.cloud.command.CusVO;
import com.server.cloud.command.FormDataVO;
import com.server.cloud.command.InsRequestVO;
import com.server.cloud.command.ProjectInfoVO;

import com.server.cloud.command.QueryVO;
import com.server.cloud.command.ProjectDetailVO;
import com.server.cloud.command.ServerVO;
import com.server.cloud.command.WorkInfoVO;

@RestController
@RequestMapping("/api/main")
public class ClientController {
	
	@Autowired
	@Qualifier("clientService")
	private ClientService clientService;
	
	@Autowired
	@Qualifier("alarmService")
	private AlarmService alarmService;
	
	//프로젝트 신청 페이지
	@GetMapping("/user/apply")
	public ResponseEntity<?> getCusList(@RequestParam("cus_id") String cus_id) {
		
		ArrayList<CusVO> list = clientService.getCusList(cus_id);
		
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	
	//신청form
	@PostMapping("/applyForm")
	//public ResponseEntity<ProjectInfoVO> applyForm(@RequestBody Map<String, Object> map) {
	  public ResponseEntity<?> applyForm(@RequestBody FormDataVO dataVO) {			
		
		//projectInfo에 cus_id 넣기 
		dataVO.getProInfo().setCus_id(dataVO.getCus_id());
		
		
		String uuidPro = UUID.randomUUID().toString();
		
		//projectInfoVO에 uuid 값 넣기
		dataVO.getProInfo().setPro_id(uuidPro);
		
		//enddate 값 넣기 
		String year = dataVO.getProInfo().getPro_startdate().substring(0, 4);
		int endyear = Integer.parseInt(year) + 1;
		String endDate = String.valueOf(endyear) + dataVO.getProInfo().getPro_startdate().substring(4, 10);
		
		dataVO.getProInfo().setPro_enddate(endDate);
		
		//project data insert
		clientService.proApplyForm(dataVO.getProInfo());
		
		//serverVO에 uuid값 넣기 
		for (ServerVO server : dataVO.getServerInfo()) {
			server.setPro_id(uuidPro);
		}
		
		//server data insert
		clientService.serverApplyForm(dataVO.getServerInfo());
		alarmService.createProAlarm(dataVO.getProInfo().getPro_name()); //프로젝트 등록시 관리자에게 알림
				
		
		return new ResponseEntity<>(dataVO, HttpStatus.OK);
	}
	
	
	
	//프로젝트 리스트 
	@GetMapping("/user/list/{cus_id}")
	public ResponseEntity<?> projectList(@PathVariable("cus_id") String cus_id) {
		
		
		ArrayList<ProjectInfoVO> proList = clientService.getProList(cus_id);
		
		return new ResponseEntity<>(proList,HttpStatus.OK);
	}
	
	//프로젝트 세부 정보
	@GetMapping("/user/prodetail/{pro_id}")
	public ResponseEntity<ArrayList<ProjectDetailVO>> projectDetail(@PathVariable("pro_id") String pro_id) {

		
		ArrayList<ProjectDetailVO> proDetail = clientService.projectDetail(pro_id);
		
		return new ResponseEntity<>(proDetail,HttpStatus.OK);
	}
	
	
	//점검 요청 form
	@PostMapping("/insRequestForm")
	  public ResponseEntity<?> insRequestForm(@RequestBody InsRequestVO insReVO) {			
		
		clientService.insRequestForm(insReVO);
		System.out.println(insReVO.toString());
		
		alarmService.emergencyRequest(insReVO.getServer_id(),insReVO.getInsRequest_type());		
		return new ResponseEntity<>(insReVO, HttpStatus.OK);
	}
	
	// 점검 요청 확인 (모달)
	@GetMapping("/user/UserInsRequestCheckModal/{server_id}/{cus_id}")
	public ResponseEntity<ArrayList<InsRequestVO>> getInsRequestCheck(@PathVariable("server_id") String server_id,
																	  @PathVariable("cus_id") String cus_id) {					
		
		ArrayList<InsRequestVO> insRequestCheck = clientService.getInsRequestCheck(server_id, cus_id);
	  
		return new ResponseEntity<>(insRequestCheck, HttpStatus.OK);
	}
	
	
	
	//////////////////////지인님///////////////////////////////
	

	   
   //작업 내역 목록 리스트
   @GetMapping("/user/projectDetailList/{cus_id}")
   public ResponseEntity<ArrayList<ProjectDetailVO>> projectDetailList(@PathVariable("cus_id") String cus_id) {
	 ArrayList<ProjectDetailVO> proDetailList =clientService.projectDetailList(cus_id);
      return new ResponseEntity<>(proDetailList,HttpStatus.OK) ;
   }
   
   //작업 내역 로그 
   @GetMapping("/user/projectDetailChart/{pro_id}/{server_id}")
   public ResponseEntity<ArrayList<ProjectDetailVO>> projectDetailChart(
		   						@PathVariable("pro_id") String pro_id,
		   						@PathVariable("server_id") String server_id) {
		ArrayList<ProjectDetailVO> projectDetailChart = clientService.projectDetailChart(pro_id, server_id);
		return new ResponseEntity<>(projectDetailChart,HttpStatus.OK);
	}
	

   //유저 메인 프로젝트 리스트
   @GetMapping("/user/{cus_id}")
   @ResponseBody
   public ResponseEntity<Map<String,Object>> mainProject(@PathVariable String cus_id){
	   
	   List<ProjectDetailVO> mainProjectList = clientService.projectMain(cus_id);
	   
		List<QueryVO> inspectionList = clientService.getInspection(cus_id); //월별점검내역리스트
		List<Integer> periodic = new ArrayList<>(); //정기
		List<Integer> disability = new ArrayList<>(); //장애
		List<Integer> maintenance = new ArrayList<>(); //유지		

		for(QueryVO vo : inspectionList) {
		
			periodic.add(vo.getPeriodic()); //월별 정기점검 모음
			disability.add(vo.getDisability()); //월별 장애대응 모음
			maintenance.add(vo.getMaintenance()); //월별 유지보수 모음
			 }

		Map<String,Object> map = new HashMap<>();
		map.put("mainProjectList",mainProjectList);
		map.put("periodic",periodic);
		map.put("disability", disability);
		map.put("maintenance", maintenance);

		
	   return new ResponseEntity<>(map,HttpStatus.OK);
   }
   @PostMapping("/client/getPro")
   public ResponseEntity<?> mainProject(@RequestBody Map<String, Object> data){
	   System.out.println(data.toString());
	   ArrayList<ProjectInfoVO> proList = clientService.getProList((String)data.get("cus_id"));
	   System.out.println(proList.toString());
	   return new ResponseEntity<>(proList,HttpStatus.OK);
   }
		
   
}
	


	

