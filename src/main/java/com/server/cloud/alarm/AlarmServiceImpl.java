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
		
		alarmMapper.createProAlarm(project_name);
	}

}
