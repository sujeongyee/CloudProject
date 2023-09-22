package com.server.cloud.admin.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.server.cloud.command.AdminMainVO;
import com.server.cloud.command.CsVO;

import com.server.cloud.command.CusVO;

import com.server.cloud.command.EngineerVO;
import com.server.cloud.command.NoticeVO;

import com.server.cloud.command.ProjectCusVO;
import com.server.cloud.command.ServerVO;

import com.server.cloud.command.ProjectDetailVO;
import com.server.cloud.command.ProjectInfoVO;
import com.server.cloud.command.QueryVO;
import com.server.cloud.command.WorkInfoVO;

import com.server.cloud.pagenation.Criteria;

public interface AdminService {

	int getTotal(String role);

	List<NoticeVO>  getList(Criteria cri);


	void setAnno(NoticeVO vo);

	void UpAnno(NoticeVO vo);
	


	//회원관리 - 엔지니어
	public List<EngineerVO> adEngineerList(EngineerVO engineerVO);

	List<CsVO> csList(Criteria cri);

	int csTotal();

	void csUpdate(CsVO vo);	

	//회원관리 - 기업
	public List<CusVO> adClientList(CusVO cusVO);
	

	public List<ProjectCusVO> newProjectList();


	int csUserTotal(String cs_writer);

	List<CsVO> csEnList(Criteria cri);

	//엔지니어 정보 불러오기
	EngineerVO engGetinfo(String cs_writer);

	int csEnTotal(Criteria cri);

	List<CsVO> csEnListMy(Criteria cri);

	List<CsVO> csEnLeaderList(Criteria cri);

	List<CsVO> csEnLeaderListMy(Criteria cri);

	
	//프로젝트 리스트 불러오기
	public ArrayList<ProjectInfoVO> getProList();
	
	//프로젝트 리스트 (모달)
	public ArrayList<ProjectDetailVO> getProListDetail(String pro_id);
	
	//서버 점검 리스트 (모달)
	public ArrayList<WorkInfoVO> getServerInsList(String server_id);


	public List<ServerVO> getRequestServer(String pro_id);
	public Map<String,Object> getRequestDetail(String pro_id);
	public List<EngineerVO> getTeamLeader();
	public List<EngineerVO> getTeamMember();
	
	public int inputTeamNum(String pro_id, String team_num, String pro_status);

	//메인
	public AdminMainVO getAdminMain();
	public List<AdminMainVO> getInspection();
	public List<AdminMainVO> getwork();

}






