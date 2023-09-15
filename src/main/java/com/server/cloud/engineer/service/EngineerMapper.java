package com.server.cloud.engineer.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.server.cloud.command.EngSerProInfoWorkInfoVO;
import com.server.cloud.command.EngineerVO;
import com.server.cloud.command.ProjectCusVO;
import com.server.cloud.command.ServerVO;
import com.server.cloud.command.WorkInfoVO;

@Mapper
public interface EngineerMapper {

	public List<ProjectCusVO> newList();
	public List<EngSerProInfoWorkInfoVO> engProInfo(String eng_enid); 
	public List<ServerVO> serverList();
	public int registWorkLog(List<WorkInfoVO> ServerDetailsArray);
//	//엔지니어 팀원 리스트
//	public List<EngineerVO> engineerList(EngineerVO engineerVO);

	//점검목록 리스트
	public List<WorkInfoVO> inspectionList(WorkInfoVO workInfoVO);

	//점검목록 리스트 서버모달
	public Map<String, Object> serverDetailModal(String server_id);
	//점검목록 리스트 작업목록 모달
	List<WorkInfoVO> pastInspectionHistoryList(String server_id);

}
