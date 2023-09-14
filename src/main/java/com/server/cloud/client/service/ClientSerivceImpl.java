package com.server.cloud.client.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.server.cloud.command.ClientVO;
import com.server.cloud.command.CommentVO;
import com.server.cloud.command.ProjectListVO;

@Service("clientService")
public class ClientSerivceImpl implements ClientSerivce{
	
	@Autowired
	private ClientMapper clientMapper;

	@Override
	public ArrayList<ProjectListVO> projectDetailList() {
		return clientMapper.projectDetailList();
	}

	
	@Override
	public ArrayList<ProjectListVO> projectDetailChart() {
		return clientMapper.projectDetailChart();
	}

	//
	/*
	 * @Override public List<CommentVO> getComment(String notice_num) { return
	 * clientMapper.getComment(notice_num); }
	 */

//	@Override
//	public void createComment(CommentVO comment) {
//		clientMapper.createComment(comment);
//	}



	





}
