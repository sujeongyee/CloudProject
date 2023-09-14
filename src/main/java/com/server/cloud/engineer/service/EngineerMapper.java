 package com.server.cloud.engineer.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.server.cloud.command.EngineerVO;
import com.server.cloud.command.ProjectInfoVO;
import com.server.cloud.command.ServerVO;
import com.server.cloud.command.WorkInfoVO;

@Mapper
public interface EngineerMapper {

	//엔지니어 팀원 리스트
	public List<EngineerVO> engineerList(EngineerVO engineerVO);
	
	//점검목록 리스트
	public List<WorkInfoVO> inspectionList(WorkInfoVO workInfoVO);

    //점검목록 리스트 서버모달
    public Map<String, Object> serverDetailModal(String server_name);
	//정검목록 리스트 작업목록 모달
    List<WorkInfoVO> pastInspectionHistoryList(String server_name);
}
