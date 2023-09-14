package com.server.cloud.client.service;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import com.server.cloud.command.ClientVO;
import com.server.cloud.command.CommentVO;
import com.server.cloud.command.ProjectListVO;

public interface ClientSerivce {
	
	
	public ArrayList<ProjectListVO> projectDetailList();
	public ArrayList<ProjectListVO> projectDetailChart();

	
	
//    public List<CommentVO> getComment(String notice_num);
//    public  void createComment(CommentVO comment);
	
}
