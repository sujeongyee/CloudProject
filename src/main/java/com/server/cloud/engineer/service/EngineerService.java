package com.server.cloud.engineer.service;

import java.util.List;
import java.util.Map;

import com.server.cloud.command.EngSerProInfoWorkInfoVO;
import com.server.cloud.command.EngineerVO;
import com.server.cloud.command.ProjectCusVO;
import com.server.cloud.command.ScheduleVO;
import com.server.cloud.command.ServerVO;
import com.server.cloud.command.WorkInfoVO;

public interface EngineerService {

	public List<EngSerProInfoWorkInfoVO> newList(String eng_enid);
	public List<EngSerProInfoWorkInfoVO> engProInfo(String eng_enid);
	public List<ServerVO> serverList();
	public int registWorkLog(List<WorkInfoVO> ServerDetailsArray);
	//엔지니어 리스트
	public List<EngineerVO> engineerList(EngineerVO engineerVO);


	//점검목록 리스트
	public List<WorkInfoVO> inspectionList(WorkInfoVO workInfoVO);

	//점검목록 리스트 서버모달
	public Map<String, Object> serverDetailModal(String server_id);
	public List<WorkInfoVO> pastInspectionHistoryList(String server_id);



	public Map<String,Object> getProjectDetail(String pro_id);
	
	public List<ServerVO> getProjectServer(String pro_id);
	public void editSchedule(ScheduleVO vo);
	public List<ServerVO> getServer(String eng_enid);

	public int updateWorkStatus(String work_status, String server_id);
}
