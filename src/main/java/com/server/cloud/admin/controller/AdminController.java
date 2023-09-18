package com.server.cloud.admin.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.protocol.HTTP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.server.cloud.admin.service.AdminService;

import com.server.cloud.command.CsVO;

import com.server.cloud.command.CusVO;

import com.server.cloud.command.EngineerVO;
import com.server.cloud.command.NoticeVO;
import com.server.cloud.command.ProjectCusVO;
import com.server.cloud.command.ServerVO;
import com.server.cloud.pagenation.Criteria;

@RestController
public class AdminController {

	
	@Autowired
	@Qualifier("adminSerivce")
	AdminService adminService;
	
	private Criteria cri=new Criteria();
	
	@GetMapping("/api/main/AnnoList")//공지사항 게시판 목록 불러오기
	public ResponseEntity<?> getList(@RequestParam("currentPage") int currentPage,@RequestParam("postsPerPage")int postsPerPage,String role){
	
		Map<String, Integer>page= new HashMap<>();
		cri.setPage(currentPage);
		cri.setAmount(postsPerPage);
		cri.setRole(role);
		
		List<NoticeVO> notice=adminService.getList(cri);
		
		
		
		return new ResponseEntity<>(notice,HttpStatus.OK);
	}
	
	@GetMapping("/api/main/admin/AnnoTotal")
	public ResponseEntity<?>getTotal(){
		return new ResponseEntity<>(adminService.getTotal(),HttpStatus.OK);
	}
	

	//회원관리 - 엔지니어

	@GetMapping("/api/main/csList")//문의사항 목록 불러오기
	public ResponseEntity<?> csList(@RequestParam("currentPage") int currentPage,@RequestParam("postsPerPage")int postsPerPage){
		Map<String, Integer>page= new HashMap<>();
		cri.setPage(currentPage);
		cri.setAmount(postsPerPage);
	
		
		List<CsVO> notice=adminService.csList(cri);
		
		
		
		return new ResponseEntity<>(notice,HttpStatus.OK);
	}
	@GetMapping("/api/main/admin/csTotal")
	public ResponseEntity<?>csTotal(){
		return new ResponseEntity<>(adminService.csTotal(),HttpStatus.OK);
	}
	@GetMapping("/api/main/csUpdate")
	public ResponseEntity<?>csUpdate(CsVO vo){
		
		adminService.csUpdate(vo);
		
		return new ResponseEntity<>("업데이트가 완료되었습니다.",HttpStatus.OK);
	}


	@GetMapping("api/main/admin/engineerList")
	public List<EngineerVO> adEngineerList(EngineerVO engineerVO){
	       return adminService.adEngineerList(engineerVO);
	}

	
	//회원관리 - 기업
	@GetMapping("api/main/admin/customerList")
	public List<CusVO> adClientList(CusVO cusVO){
		return adminService.adClientList(cusVO);
	}
	
	@GetMapping("/api/main/admin")
	public ResponseEntity<List<ProjectCusVO>> newProjectList () {
		List<ProjectCusVO> newPL = adminService.newProjectList();
		return new ResponseEntity<>(newPL, HttpStatus.OK);
	}
	
	@GetMapping("/api/main/admin/projectDetail/{pro_id}")
	public ResponseEntity<Map<String,Object>> projectDetail(@PathVariable String pro_id){
		Map<String,Object> map2 = adminService.getRequestDetail(pro_id);
		List<ServerVO> list = adminService.getRequestServer(pro_id);

		
		map2.put("list", list);
		
		return new ResponseEntity<>(map2,HttpStatus.OK);
	}
	//신규요청의 모달에 데이터 전달
	@GetMapping("/api/main/admin/getTeam")
	public ResponseEntity<Map<String, Object>> getTeam(){
		Map<String, Object> team = new HashMap<>();
		List<EngineerVO> teamLeader = adminService.getTeamLeader();
		List<EngineerVO> teamMember = adminService.getTeamMember();
		
		team.put("teamLeader", teamLeader);
		team.put("teamMember", teamMember);
		
		return new ResponseEntity<>(team, HttpStatus.OK);
	}
	
	//팀 배정
	@PostMapping("/api/main/admin/inputTeamNum")
	public ResponseEntity<String> inputTeamNum(@RequestBody Map<String, String> teamNum) {
		String pro_id=teamNum.get("pro_id");
		String team_num=teamNum.get("team_num");
		System.out.println(pro_id + team_num + "----");
		int result = adminService.inputTeamNum(pro_id, team_num);
		
		return new ResponseEntity<>("ok", HttpStatus.OK);
	}

}
