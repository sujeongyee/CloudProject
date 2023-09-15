package com.server.cloud.admin.controller;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.server.cloud.admin.service.AdminService;
import com.server.cloud.command.EngineerVO;
import com.server.cloud.command.NoticeVO;
import com.server.cloud.pagenation.Criteria;

@RestController
public class AdminController {

	
	@Autowired
	@Qualifier("adminSerivce")
	AdminService adminService;
	
	private Criteria cri=new Criteria();
	
	@GetMapping("/api/main/AnnoList")//공지사항 게시판 목록 불러오기
	public ResponseEntity<?> getList(@RequestParam("currentPage") int currentPage,@RequestParam("postsPerPage")int postsPerPage){
		Map<String, Integer>page= new HashMap<>();
		System.out.println(currentPage+"??");
		cri.setPage(currentPage);
		cri.setAmount(postsPerPage);
	
		
		List<NoticeVO> notice=adminService.getList(cri);
		
		System.out.println(notice);
		
		
		return new ResponseEntity<>(notice,HttpStatus.OK);
	}
	
	@GetMapping("/api/main/admin/AnnoTotal")
	public ResponseEntity<?>getTotal(){
		return new ResponseEntity<>(adminService.getTotal(),HttpStatus.OK);
	}
	

	//회원관리 - 엔지니어
	@GetMapping("/admin/engineerList")
	public List<EngineerVO> adEngineerList(EngineerVO engineerVO){
	       return adminService.adEngineerList(engineerVO);
	}

}

