package com.server.cloud.alarm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.server.cloud.service.AlarmMapper;

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
	public void assignEngineer(String eng_id) {
		
		alarmMapper.assignEngineer(eng_id);
	}

}
