package com.server.cloud.engineer.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.server.cloud.command.EngSerProInfoWorkInfoVO;
import com.server.cloud.command.EngineerVO;
import com.server.cloud.command.ProjectCusVO;
import com.server.cloud.command.ScheduleVO;
import com.server.cloud.command.ServerVO;
import com.server.cloud.command.WorkInfoVO;

@Service("engineerService")
public class EngineerServiceImpl implements EngineerService{

	@Autowired
	private EngineerMapper engineerMapper;

	@Override
	public List<EngSerProInfoWorkInfoVO> newList(String eng_enid) {

		return engineerMapper.newList(eng_enid);

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
	//엔지니어 리스트
//	@Override
//	public List<EngineerVO> engineerList(String eng_enid, EngineerVO engineerVO) {
//		return engineerMapper.engineerList(eng_enid, engineerVO);
//	}
	@Override
	public List<EngineerVO> engineerListMap(String eng_enid) {
		return engineerMapper.engineerListMap(eng_enid);
	}
	
//	@Override
//	public List<WorkInfoVO> inspectionList(WorkInfoVO workInfoVO) {
//		return engineerMapper.inspectionList(workInfoVO);
//	}
	//엔지니어 작업목록 리스트
	@Override
	public List<WorkInfoVO> inspectionListMap(String eng_enid) {
		return engineerMapper.inspectionListMap(eng_enid);
	}
//	//엔지니어 작업목록 리스트
//	@Override
//	public List<ServerVO> serverInfo() {
//		return engineerMapper.serverInfo();
//	}
	
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

	@Override
	public Map<String, Object> getProjectDetail(String pro_id) {
		return engineerMapper.getProjectDetail(pro_id);
	}
	
	@Override
	public List<ServerVO> getProjectServer(String pro_id) {
		return engineerMapper.getProjectServer(pro_id);
	}


	@Override
	public void editSchedule(ScheduleVO vo) {
		engineerMapper.editSchedule(vo);
		
	}


  //작업상태 버튼 
	@Override
	public int updateWorkStatus(String work_status, String server_id) {
		// TODO Auto-generated method stub
		return engineerMapper.updateWorkStatus(work_status, server_id);
	}

	//승용 서버 가져오기
	@Override
	public List<ServerVO> getServer(String eng_enid) {
		// TODO Auto-generated method stub
		return engineerMapper.getServer(eng_enid);

	}


	@Override
	public ScheduleVO getScheInfo(String string) {
		// TODO Auto-generated method stub
		return engineerMapper.getScheInfo(string);
	}


	@Override
	public EngineerVO getEnInfo(String en_enid) {
		// TODO Auto-generated method stub
		return engineerMapper.getEnInfo(en_enid);
	}
	

}
