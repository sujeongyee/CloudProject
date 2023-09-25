package com.server.cloud.alarm.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.server.cloud.command.AlarmVO;
import com.server.cloud.command.ServerVO;

public interface AlarmService {
	
	public void createProAlarm(String project_name); //
	public void assignTeam(String eng_team);
	public void assignEngineer(String eng_id);
	public void assignClient(String user_id);
	public int todayAlarmCheck(String eng_id);
	public void todayAlarmEng(String eng_id);
	public int todayAlarmCheck2(String cus_id);
	public void todayAlarmCus(String cus_id);
	public void emergencyRequest(String server_id,String type);
	public void assignEmerEng(String eng_id);
	public void assignEmerCus(String server_id);
	public List<AlarmVO> getAlarmList(String user_id);
	public List<AlarmVO> getAllAlarm(String user_id);
	public void changeAlarm(String alarm_num);
	public ServerVO getServerVO(String sche_num);
	public void editSchedule(String msg,String sche_num);
	
}
