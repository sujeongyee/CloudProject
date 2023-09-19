package com.server.cloud.client.controller;

import java.util.ArrayList;
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
@RequestMapping("/api/main")
public class ClientController {
	
	@Autowired
	@Qualifier("clientService")
	private ClientService clientService;
	
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
	
	
	
	//////////////////////지인님///////////////////////////////
	
	   
   //작업 내역 목록 리스트
   @GetMapping("/client/projectDetailList")
   public ArrayList<ProjectListVO> projectDetailList() {

      return clientService.projectDetailList();
   }
   
   //작업 내역 로그 
   @GetMapping("/client/projectDetailChart")
   public ArrayList<ProjectListVO> projectDetailChart() {

      return clientService.projectDetailChart();
   }


   
	

}
