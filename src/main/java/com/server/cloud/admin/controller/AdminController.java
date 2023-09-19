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

import com.server.cloud.command.CsVO;

import com.server.cloud.command.CusVO;

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
	public ResponseEntity<?> getList(@RequestParam("currentPage") int currentPage,@RequestParam("postsPerPage")int postsPerPage,String role){

		Map<String, Integer>page= new HashMap<>();
		cri.setPage(currentPage);
		cri.setAmount(postsPerPage);
		cri.setRole(role);

		List<NoticeVO> notice=adminService.getList(cri);



		return new ResponseEntity<>(notice,HttpStatus.OK);
	}

	@GetMapping("/api/main/admin/AnnoTotal")
	public ResponseEntity<?>getTotal(String role){
		return new ResponseEntity<>(adminService.getTotal(role),HttpStatus.OK);
	}


	//회원관리 - 엔지니어

	@GetMapping("/api/main/csList")//문의사항 목록 불러오기(admin)
	public ResponseEntity<?> csList(@RequestParam("currentPage") int currentPage,@RequestParam("postsPerPage")int postsPerPage){
		Map<String, Integer>page= new HashMap<>();
		cri.setPage(currentPage);
		cri.setAmount(postsPerPage);
		cri.setCs_writer(null);

		List<CsVO> notice=adminService.csList(cri);



		return new ResponseEntity<>(notice,HttpStatus.OK);
	}
	@GetMapping("/api/main/csUserList")//문의사항 목록 불러오기(user)
	public ResponseEntity<?> csUserList(@RequestParam("currentPage") int currentPage,
			@RequestParam("postsPerPage")int postsPerPage,
			@RequestParam("cs_writer")String cs_writer){
		Map<String, Integer>page= new HashMap<>();
		cri.setPage(currentPage);
		cri.setAmount(postsPerPage);
		cri.setCs_writer(cs_writer);

		List<CsVO> notice=adminService.csList(cri);



		return new ResponseEntity<>(notice,HttpStatus.OK);
	}
	@GetMapping("/api/main/csEngineerList")//문의사항 목록 불러오기(engineer&engineerLeader)
	public ResponseEntity<?> csEngineerList(@RequestParam("currentPage") int currentPage,
			@RequestParam("postsPerPage")int postsPerPage,
			@RequestParam("cs_writer")String cs_writer,
			@RequestParam("role")String role){
		Map<String, Integer>page= new HashMap<>();
		EngineerVO vo= adminService.engGetinfo(cs_writer);
		cri.setEng_taem_num(vo.getTeam_num());
		cri.setPage(currentPage);
		cri.setAmount(postsPerPage);
		cri.setCs_writer(cs_writer);
		cri.setRole(role);
		List<CsVO> notice=adminService.csEnList(cri);
		List<CsVO> notice1=adminService.csEnListMy(cri);
		
		for (int i = 0; i < notice1.size(); i++) {
			notice.add(notice1.get(i));
		}
		
		
		return new ResponseEntity<>(notice,HttpStatus.OK);
	}
	@GetMapping("/api/main/csEngineerLeaderList")//문의사항 목록 불러오기(engineer&engineerLeader)
	public ResponseEntity<?> csEngineerLeaderList(@RequestParam("currentPage") int currentPage,
			@RequestParam("postsPerPage")int postsPerPage,
			@RequestParam("cs_writer")String cs_writer,
			@RequestParam("role")String role){
		Map<String, Integer>page= new HashMap<>();
		EngineerVO vo= adminService.engGetinfo(cs_writer);
		cri.setEng_taem_num(vo.getTeam_num());
		cri.setPage(currentPage);
		cri.setAmount(postsPerPage);
		cri.setCs_writer(cs_writer);
		cri.setRole(role);
		List<CsVO> notice=adminService.csEnLeaderList(cri);
		System.out.println(notice.toString());
		List<CsVO> notice1=adminService.csEnLeaderListMy(cri);
		
			
		for (int i = 0; i < notice1.size(); i++) {
			notice.add(notice1.get(i));
		}
		
		return new ResponseEntity<>(notice,HttpStatus.OK);
	}
	
	@GetMapping("/api/main/admin/csTotal")//문의사항 목록 토탈개수(admin)
	public ResponseEntity<?>csTotal(){
		return new ResponseEntity<>(adminService.csTotal(),HttpStatus.OK);
	}
	@GetMapping("/api/main/admin/csUserTotal")//문의사항 목록 토탈개수(user)
	public ResponseEntity<?>csUserTotal(@RequestParam("cs_writer")String cs_writer){
		return new ResponseEntity<>(adminService.csUserTotal(cs_writer),HttpStatus.OK);
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

}
