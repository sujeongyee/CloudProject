package com.server.cloud.service;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AlarmMapper {
	
	public void createProAlarm(String project_name);
	public void assignEngineer(String eng_id);

}
