package com.server.cloud.alarm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("alarmService")
public class AlarmServiceImpl implements AlarmService{
	
	@Autowired
	private AlarmMapper alarmMapper;

	@Override
	public void createProAlarm(String project_name) {
		project_name= "새로운 프로젝트 요청이 들어왔습니다. ("+project_name+")";
		alarmMapper.createProAlarm(project_name);
	}
	@Override
	public void assignTeam(String eng_team) {
		alarmMapper.assignTeam(eng_team);		
	}
	
	@Override
	public void assignEngineer(String eng_id) {		
		alarmMapper.assignEngineer(eng_id);
	}
	@Override
	public void assignClient(String user_id) {
		alarmMapper.assignClient(user_id);		
	}

	

}
