package com.server.cloud.engineer.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.server.cloud.command.EngSerProInfoWorkInfoVO;
import com.server.cloud.command.EngineerVO;
import com.server.cloud.command.ProjectCusVO;
import com.server.cloud.command.ServerVO;
import com.server.cloud.command.WorkInfoVO;

@Service("engineerService")
public class EngineerServiceImpl implements EngineerService{

	@Autowired
	private EngineerMapper engineerMapper;

	@Override
	public List<ProjectCusVO> newList() {

		return engineerMapper.newList();

	}


	@Override
	public List<EngSerProInfoWorkInfoVO> engProInfo(String eng_enid) {

		return engineerMapper.engProInfo(eng_enid);
	}

	@Override
	public List<ServerVO> serverList() {

		return engineerMapper.serverList();
	}

	@Override
	public int registWorkLog(List<WorkInfoVO> ServerDetailsArray) {

		return engineerMapper.registWorkLog(ServerDetailsArray);}

//
//	//엔지니어 팀원 리스트
//	@Override
//	public List<EngineerVO> engineerList(EngineerVO engineerVO) {
//		return engineerMapper.engineerList(engineerVO);
//	}

	//엔지니어 작업목록 리스트
	@Override
	public List<WorkInfoVO> inspectionList(WorkInfoVO workInfoVO) {
		return engineerMapper.inspectionList(workInfoVO);
	}

	//점검목록 리스트 서버모달
	@Override
	public Map<String, Object> serverDetailModal(String server_id) {
		return engineerMapper.serverDetailModal(server_id);
	}

	//과거점검목록
	@Override
	public List<WorkInfoVO> pastInspectionHistoryList(String server_id) {
		return engineerMapper.pastInspectionHistoryList(server_id);
	}



}
