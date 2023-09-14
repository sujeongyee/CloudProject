package com.server.cloud.engineer.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.server.cloud.command.EngineerVO;
import com.server.cloud.command.ProjectInfoVO;
import com.server.cloud.command.ServerVO;
import com.server.cloud.command.WorkInfoVO;

@Service("engineerService")
public class EngineerServiceImpl implements EngineerService{

	@Autowired
	private EngineerMapper engineerMapper;

	//엔지니어 팀원 리스트
	@Override
	public List<EngineerVO> engineerList(EngineerVO engineerVO) {
		return engineerMapper.engineerList(engineerVO);
	}

	//엔지니어 작업목록 리스트
	@Override
	public List<WorkInfoVO> inspectionList(WorkInfoVO workInfoVO) {
		return engineerMapper.inspectionList(workInfoVO);
	}
	
	//점검목록 리스트 서버모달
	@Override
	public Map<String, Object> serverDetailModal(String server_name) {
		return engineerMapper.serverDetailModal(server_name);
	}

	@Override
	public List<WorkInfoVO> pastInspectionHistoryList(String server_name) {
		return engineerMapper.pastInspectionHistoryList(server_name);
	}






	
	
	
	
}
