package com.server.cloud.main.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.server.cloud.admin.service.AdminService;
import com.server.cloud.pagenation.Criteria;
import com.server.cloud.pagenation.pageVO;

@RestController
public class PageNationController {

	
	@Autowired
	private AdminService adminService;
	
	
	
	
	private Criteria cri=new Criteria();
	
	@GetMapping("/api/pagenation")
	public ResponseEntity<?> pageNation(@RequestParam("bno") int bno,@RequestParam("amount") int amount,@RequestParam("total") int total){
		
		System.out.println(1);
		cri.setPage(bno);
		cri.setAmount(amount);
		
		
		pageVO pageVO=new pageVO(cri, total);
		
			
		return new ResponseEntity<>(pageVO,HttpStatus.OK);
	}
	
}
