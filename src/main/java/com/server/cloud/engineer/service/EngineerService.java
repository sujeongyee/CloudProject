package com.server.cloud.engineer.service;

import java.util.List;
import java.util.Map;

import com.server.cloud.command.EngSerProInfoWorkInfoVO;
import com.server.cloud.command.EngineerVO;
import com.server.cloud.command.ProjectCusVO;
import com.server.cloud.command.ServerVO;
import com.server.cloud.command.WorkInfoVO;

public interface EngineerService {

	public List<ProjectCusVO> newList();
	public List<EngSerProInfoWorkInfoVO> engProInfo(String eng_enid);
	public List<ServerVO> serverList();
	public int registWorkLog(List<WorkInfoVO> ServerDetailsArray);
	//엔지니어 팀원 리스트
	public List<EngineerVO> engineerList(EngineerVO engineerVO);


	//점검목록 리스트
	public List<WorkInfoVO> inspectionList(WorkInfoVO workInfoVO);

	//점검목록 리스트 서버모달
	public Map<String, Object> serverDetailModal(String server_name);
	public List<WorkInfoVO> pastInspectionHistoryList(String server_name);

}
