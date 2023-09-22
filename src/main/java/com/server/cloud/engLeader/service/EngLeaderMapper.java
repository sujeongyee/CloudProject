package com.server.cloud.engLeader.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.server.cloud.command.CusVO;
import com.server.cloud.command.EngineerVO;
import com.server.cloud.command.InsRequestVO;
import com.server.cloud.command.ProjectInfoVO;
import com.server.cloud.command.QueryVO;
import com.server.cloud.command.ScheduleVO;
import com.server.cloud.command.ServerVO;
import com.server.cloud.command.WorkInfoVO;

@Mapper
public interface EngLeaderMapper {
	
	public Map<String,String> getLeaderInfo(String leader_id);
	public List<ProjectInfoVO> getNewProject(String leader_id);
	public List<QueryVO> getInspection(String leader_id);
	public QueryVO getAllMain(String leader_id);
	public Map<String,Object> getRequestDetail(String pro_id);
	public List<ServerVO> getRequestServer(String pro_id);
	public List<ServerVO> getRequestServer2(String pro_id);
	public List<EngineerVO> getTeamEngList(@Param("pro_pi") String pro_pi,@Param("leader_id") String leader_id);
	public List<EngineerVO> getTeamEngList2(String leader_id);
	public void assignEng(@Param("eng_enid") String eng_enid , @Param("server_id") String server_id);
	public List<ProjectInfoVO> getAllPro(String leader_id);
	public List<CusVO> getClient(String leader_id);
	public CusVO getClientInfo(String cus_id);
	public List<ProjectInfoVO> clientProjects(String cus_id);
	public List<ServerVO> getEngServer(String eng_enid);
	public List<ScheduleVO> getEngSchedule(String eng_enid);
	public List<ScheduleVO> getAllSchedule(String leader_id);
	public List<WorkInfoVO> getWorkInfo(String server_id);
	public void registSchedule(@Param("eng_enid") String eng_enid, @Param("server_id") String server_id);
	
	//점검요청목록
	public ArrayList<InsRequestVO> getInsRequestList();

}
