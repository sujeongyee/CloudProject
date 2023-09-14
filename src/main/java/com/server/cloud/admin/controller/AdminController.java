package com.server.cloud.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.server.cloud.admin.service.AdminService;
import com.server.cloud.command.EngineerVO;

@RestController
@RequestMapping("/api")
public class AdminController {

	@Autowired
	@Qualifier("adminService")
	private AdminService adminService;
	
	//회원관리 - 엔지니어
	@GetMapping("/admin/engineerList")
	public List<EngineerVO> adEngineerList(EngineerVO engineerVO){
        return adminService.adEngineerList(engineerVO);
	}
	
}
