package com.server.cloud.client.controller;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.server.cloud.client.service.ClientService;
import com.server.cloud.command.CusVO;
import com.server.cloud.command.FormDataVO;
import com.server.cloud.command.ProjectInfoVO;
import com.server.cloud.command.ProjectListVO;
import com.server.cloud.command.ProjectDetailVO;
import com.server.cloud.command.ServerVO;

@RestController
@RequestMapping("/api")
public class ClientController {
	
	@Autowired
	@Qualifier("clientService")
	private ClientService clientService;
	
	//프로젝트 신청 페이지
	@GetMapping("/user/apply")
	public ResponseEntity<?> getCusList() {
		
		String cus_id = "customer1";
		ArrayList<CusVO> list = clientService.getCusList(cus_id);
		
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	
	//프로젝트 신청
//	@PostMapping("/applyForm")
//	//public ResponseEntity<ProjectInfoVO> applyForm(@RequestBody Map<String, Object> map) {
//	  public String	applyForm(@RequestBody Map<String, Object> map) {			
//	
//		// "proInfo"와 "serverInfo"를 포함하는 map에서 데이터 추출
//	    Map<String, Object> formData = (Map<String, Object>) map.get("formData");
//	    Map<String, Object> proInfoMap = (Map<String, Object>) formData.get("proInfo");
//	    Map<String, Object> serverInfoMap = (Map<String, Object>) formData.get("serverInfo");
//
//	    // 추출된 데이터를 이용하여 VO 객체로 변환
//	    ProjectInfoVO proVO = new ObjectMapper().convertValue(proInfoMap, ProjectInfoVO.class);
//	    ServerVO serverVO = new ObjectMapper().convertValue(serverInfoMap, ServerVO.class);
//		
//	    
////	    int endYear = Integer.parseInt(proVO.getPro_startdate().substring(0, 4))+1;
////	    String enddate = String.valueOf(endYear) + proVO.getPro_startdate().substring(5, 10);
////	    
////	    System.out.println(endYear);
////	    System.out.println(enddate);
////
////	    proVO.setPro_enddate(enddate);
////	    proVO.setPro_status("승인미정");
////
////	    serverVO.setServer_status("Good");
//
//	    clientService.proApplyForm(proVO);
//	    
//	   // ArrayList<ServerVO> serverList = new ArrayList<>();
//	   // serverList.add(serverVO);
//	    
//	    //System.out.println(serverList.toString());
//	    
//		//clientService.serverApplyForm(serverList);
//	    
//		
//	    //return new ResponseEntity<>(proVO,HttpStatus.OK);
//		return "/user/list";
//	}
	
	//신청form
	@PostMapping("/applyForm")
	//public ResponseEntity<ProjectInfoVO> applyForm(@RequestBody Map<String, Object> map) {
	  public ResponseEntity<?> applyForm(@RequestBody FormDataVO dataVO) {			
		
		//int endyear = Integer.parseInt( dataVO.getProInfo().getPro_startdate().substring(0, 4) ) + 1;
		//String enddate = String.valueOf(endyear) + dataVO.getProInfo().getPro_startdate().substring(5, 10);
		
		//dataVO.getProInfo().setPro_enddate(enddate);
//		dataVO.getProInfo().setPro_status("승인미정");
//		

		ProjectInfoVO proVO = new ProjectInfoVO();
		ServerVO sVO = new ServerVO();
		
		clientService.proApplyForm(dataVO.getProInfo());
		
		sVO.setPro_id(proVO.getPro_id());

		clientService.serverApplyForm(dataVO.getServerInfo());
		
//		System.out.println(dataVO);
//		System.out.println(dataVO.getProInfo());
//		System.out.println(dataVO.getServerInfo());
		
		
		return new ResponseEntity<>(dataVO, HttpStatus.OK);
	}
	
	
	
	//프로젝트 리스트 
	@GetMapping("/user/list")
	public ResponseEntity<?> projectList() {
		
		String cus_id = "customer1";
		ArrayList<ProjectInfoVO> proList = clientService.getProList(cus_id);
		
		return new ResponseEntity<>(proList,HttpStatus.OK);
	}
	
	//프로젝트 세부 정보
	@GetMapping("/user/prodetail")
	public ResponseEntity<?> projectDetail() {
		
		String pro_id = "5afd9eaa-4be1-11ee-8c2a-0ef820116d74";
		
		ArrayList<ProjectDetailVO> proDetail = clientService.projectDetail(pro_id);
		System.out.println(proDetail);
		
		return new ResponseEntity<>(proDetail,HttpStatus.OK);
	}
	
	
	//////////////////////지인님///////////////////////////////
	
	  
	   
	   // 작업 내역 목록 리스트
	   @GetMapping("/client/projectDetailList")
	   public ArrayList<ProjectListVO> projectDetailList() {

	      return clientService.projectDetailList();
	   }
	   
	   @GetMapping("/client/projectDetailChart")
	   public ArrayList<ProjectListVO> projectDetailChart() {

	      return clientService.projectDetailChart();
	   }



	

}
