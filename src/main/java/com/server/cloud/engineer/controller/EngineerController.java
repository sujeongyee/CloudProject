package com.server.cloud.engineer.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.server.cloud.command.EngSerProInfoWorkInfoVO;
import com.server.cloud.command.EngineerVO;
import com.server.cloud.command.ProjectCusVO;

import com.server.cloud.command.ServerVO;
import com.server.cloud.command.WorkInfoVO;
import com.server.cloud.engineer.service.EngineerService;

@RestController
@RequestMapping("/api")
public class EngineerController {

	@Autowired
	private EngineerService engineerService;



	@Value("@{aws_bucket_name}")
	private String aws_bucket_name;

	

	//팀원 프로젝트 리스트 
	@GetMapping("/engineer/newList")
	public ResponseEntity<List<ProjectCusVO>> newList() {

		List<ProjectCusVO> CusProList = engineerService.newList();

		return new ResponseEntity<>(CusProList, HttpStatus.OK);
	}

	//엔지니어별로 배정받은 프로젝트 불러오는 기능
	@GetMapping("/engineer/workDetail")
	public ResponseEntity<Map<String, Object>> enWorkDetailToInfo(String eng_enid) {

		eng_enid = "eng_a_3"; //추후 토큰이랑 연동해야됌

		List<EngSerProInfoWorkInfoVO> eSPIWlist = engineerService.engProInfo(eng_enid);
		List<ServerVO> serverList = engineerService.serverList();

		Map<String, Object> proInfoMap = new HashMap<>();
		proInfoMap.put("eSPIWlist", eSPIWlist);
		proInfoMap.put("serverList", serverList);

		return new ResponseEntity<>(proInfoMap, HttpStatus.OK);
	}

	//작업상세내역서 등록 기능
	@PostMapping("/engineer/workDetail")
	public ResponseEntity<Integer> registWorkLogs(@RequestBody List<WorkInfoVO> ServerDetailsArray){

		int result = engineerService.registWorkLog(ServerDetailsArray);
		System.out.println(result);

		// 작업 로그 등록이 성공하면 성공 응답을 반환합니다.
		return new ResponseEntity<>(result, HttpStatus.OK);
	}


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

	//	    엔지니어 점검목록 리스트 -> 서버 모달
	@PostMapping("/engineer/inspectionList2")
	public ResponseEntity<Map<String, Object>>  serverDetailModal(@RequestBody Map<String, Object> data){
		String server_name = data.get("serverName").toString();
		Map<String,Object> map2 = engineerService.serverDetailModal(server_name);
		List<WorkInfoVO> list = engineerService.pastInspectionHistoryList(server_name);
		map2.put("list", list);
		System.out.println(data.toString());
		System.out.println(list.toString());

		return new ResponseEntity<>(map2,HttpStatus.OK);
	}



}
