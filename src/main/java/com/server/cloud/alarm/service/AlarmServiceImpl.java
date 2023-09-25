package com.server.cloud.alarm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.server.cloud.command.AlarmVO;
import com.server.cloud.command.ServerVO;

@Service("alarmService")
public class AlarmServiceImpl implements AlarmService{
	
	@Autowired
	private AlarmMapper alarmMapper;

	@Override
	public void createProAlarm(String project_name) {
		alarmMapper.createProAlarm("새로운 프로젝트 요청이 들어왔습니다. ("+project_name+")");
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
	@Override
	public int todayAlarmCheck(String eng_id) {
		return alarmMapper.todayAlarmCheck(eng_id);
	}
	@Override
	public void todayAlarmEng(String eng_id) {
		alarmMapper.todayAlarmEng(eng_id);
	}
	@Override
	public int todayAlarmCheck2(String cus_id) {	
		return alarmMapper.todayAlarmCheck2(cus_id);
	}
	@Override
	public void todayAlarmCus(String cus_id) {
		alarmMapper.todayAlarmCus(cus_id);		
	}
	@Override
	public void emergencyRequest(String server_id,String type) {
		alarmMapper.emergencyRequest(server_id,type);		
	}
	@Override
	public void assignEmerEng(String eng_id) {
		alarmMapper.assignEmerEng(eng_id);
	}
	@Override
	public void assignEmerCus(String server_id) {
		alarmMapper.assignEmerCus(server_id);	
	}
	@Override
	public List<AlarmVO> getAlarmList(String user_id) {
		List<AlarmVO> alarmVO=alarmMapper.getAlarmList(user_id);
		return alarmVO;
	}
	@Override
	public List<AlarmVO> getAllAlarm(String user_id) {
		return alarmMapper.getAllAlarm(user_id);
	}
	@Override
	public void changeAlarm(String alarm_num) {
		alarmMapper.changeAlarm(alarm_num);
	}
	@Override
	public void editSchedule(String msg,String sche_num) {
		alarmMapper.editSchedule(msg,sche_num);
	}
	@Override
	public ServerVO getServerVO(String sche_num) {
		return alarmMapper.getServerVO(sche_num);
		
	}

}
