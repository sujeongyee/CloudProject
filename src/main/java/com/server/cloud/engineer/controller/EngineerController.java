package com.server.cloud.engineer.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.server.cloud.command.EngineerVO;
import com.server.cloud.command.ServerVO;
import com.server.cloud.command.WorkInfoVO;
import com.server.cloud.engineer.service.EngineerService;

@RestController
@RequestMapping("/api")
public class EngineerController {

	@Autowired
	@Qualifier("engineerService")
	private EngineerService engineerService;
	
	
	//엔지니어팀 인원리스트 
	@GetMapping("/engineer/engineerList")
	public List<EngineerVO> engineerList(EngineerVO engineerVO){
        return engineerService.engineerList(engineerVO);
	}

	// 엔지니어 점검목록 리스트 
	@GetMapping("/engineer/inspectionList")
	public List<WorkInfoVO> inspectionList(WorkInfoVO workInfoVO){
        return engineerService.inspectionList(workInfoVO);
	}
	
//	 엔지니어 점검목록 리스트 -> 서버 모달
	@PostMapping("/engineer/inspectionList2")
	public ResponseEntity<Map<String, Object>>  serverDetailModal(@RequestBody Map<String, Object> data){
		String server_name = data.get("serverName").toString();
		Map<String,Object> map2 = engineerService.serverDetailModal(server_name);
		List<WorkInfoVO> list = engineerService.pastInspectionHistoryList(server_name);
		map2.put("list", list);
//		System.out.println(data.toString());
//		System.out.println(list.toString());
		
		return new ResponseEntity<>(map2,HttpStatus.OK);
	}

	

}
