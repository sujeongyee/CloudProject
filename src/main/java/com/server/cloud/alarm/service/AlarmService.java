package com.server.cloud.alarm.service;

public interface AlarmService {
	
	public void createProAlarm(String project_name); //
	public void assignTeam(String eng_team);
	public void assignEngineer(String eng_id);
	public void assignClient(String user_id);
	
}
