package com.server.cloud.client.controller;

import java.awt.Menu;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.server.cloud.client.service.ClientMapper;
import com.server.cloud.client.service.ClientSerivce;
import com.server.cloud.command.ClientVO;
import com.server.cloud.command.CommentVO;
import com.server.cloud.command.ProjectListVO;

@RestController
@RequestMapping("/api")
public class ClientController {

	@Autowired
	private ClientSerivce clientService;

	// 작업 내역 목록 리스트
	@GetMapping("/client/projectDetailList")
	public ArrayList<ProjectListVO> projectDetailList() {

		return clientService.projectDetailList();
	}
	
	//작업로그 
	@GetMapping("/client/projectDetailChart")
	public ArrayList<ProjectListVO> projectDetailChart() {

		return clientService.projectDetailChart();
	}
	
	//댓글기능
//    @GetMapping("/eng/{notice_num}")
//    public List<CommentVO> getCommentsByNoticeId(@RequestParam("notice_num") String notice_num) {
//        return clientService.getComment(notice_num);
//    }

//    @PostMapping("/eng/comments")
//    public void createComment(@RequestBody CommentVO comment) {
//    	clientService.createComment(comment);
//    }


	

    


	
}
