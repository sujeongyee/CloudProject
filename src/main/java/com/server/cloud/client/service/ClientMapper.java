package com.server.cloud.client.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.server.cloud.command.CusVO;
import com.server.cloud.command.InsRequestVO;
import com.server.cloud.command.ProjectInfoVO;
import com.server.cloud.command.QueryVO;
import com.server.cloud.command.ProjectDetailVO;
import com.server.cloud.command.ServerVO;
import com.server.cloud.command.WorkInfoVO;
import com.server.cloud.command.ClientVO;
import com.server.cloud.command.CommentVO;


@Mapper
public interface ClientMapper {
	

	//클라이언트 정보 불러오기
	//public ArrayList<CusVO> getCusList(CusVO cusVO);
	public ArrayList<CusVO> getCusList(String cus_id);
	
	//프로젝트, 서버 정보 입력
//	public int applyForm(@Param("proVO") ProjectInfoVO proVO, 
//						 @Param("serverList") ArrayList<ServerVO> serverList);
	
	//프로젝트 정보 입력 
	public void proApplyForm(ProjectInfoVO proVO);
	
	//서버 정보 입력 
	public void serverApplyForm(ArrayList<ServerVO> serverList);
	
	//프로젝트 리스트 
	public ArrayList<ProjectInfoVO> getProList(String cus_id);
	
	//프로젝트 세부사항 
	public ArrayList<ProjectDetailVO> projectDetail(String pro_id); 
	
	//점검요청
	public void insRequestForm(InsRequestVO insReVO);
	
	//점검요청목록
	public ArrayList<InsRequestVO> getInsRequestCheck(@Param("server_id") String server_id,
													  @Param("cus_id") String cus_id);
	


	 //작업 내역 리스트
	   public ArrayList<ProjectDetailVO> projectDetailList(String cus_id);
	   //작업 내역 로그 
	   public ArrayList<ProjectDetailVO> projectDetailChart(@Param("pro_id") String pro_id, @Param("server_id") String server_id);
		   
	   //메인프로젝트 
	   public List<ProjectDetailVO> projectMain(String cus_id);
	   public List<QueryVO> getInspection(String cus_id);

}
