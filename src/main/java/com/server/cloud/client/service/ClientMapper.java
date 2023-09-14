package com.server.cloud.client.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.server.cloud.command.ClientVO;
import com.server.cloud.command.CommentVO;
import com.server.cloud.command.ProjectListVO;

@Mapper
public interface ClientMapper {
	
	//작업 내역 리스트
	public ArrayList<ProjectListVO> projectDetailList();
	public ArrayList<ProjectListVO> projectDetailChart();
	
	
//    public List<CommentVO> getComment(String notice_num);
 //   public  void createComment(CommentVO comment);


}
