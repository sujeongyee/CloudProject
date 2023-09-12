package com.server.cloud.engLeader.service;

import java.util.List;
import java.util.Map;

import com.server.cloud.command.CusVO;
import com.server.cloud.command.EngineerVO;
import com.server.cloud.command.ProjectInfoVO;
import com.server.cloud.command.QueryVO;
import com.server.cloud.command.ServerVO;

public interface EngLeaderService {
	
//	public int getTeamCount(String leader_id);
//	public int getProjectCount(String leader_id);
//	public int getServerCount(String leader_id);
	public List<ProjectInfoVO> getNewProject(String leader_id);
//	public int thisMonthStart(String leader_id);
//	public int thisMonthEnd(String leader_id);
	public List<QueryVO> getInspection(String leader_id);
	public QueryVO getAllMain(String leader_id);
	public Map<String,Object> getRequestDetail(String pro_id);
	public List<ServerVO> getRequestServer(String pro_id);
	public List<ServerVO> getRequestServer2(String pro_id);
	public List<EngineerVO> getTeamEngList(String leader_id);
	public void assignEng(String eng_enid , String server_id);
	public List<ProjectInfoVO> getAllPro(String leader_id);
	public List<CusVO> getClient(String leader_id);
	public CusVO getClientInfo(String cus_id);
	public List<ProjectInfoVO> clientProjects(String cus_id);
	public List<ServerVO> getEngServer(String eng_enid);
}
