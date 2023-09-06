package com.server.cloud.alarm.controller;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


import org.springframework.web.bind.annotation.RestController;

import com.server.cloud.alarm.service.AlarmService;


@RestController
@RequestMapping("/alarm")
public class AlarmController {
	
//	관리자
//	프로젝트 요청 들어왔을 때 (클라-> 관리) vvvv
//	엔지니어 팀장
//	프로젝트 배정 받았을때  (관리 -> 엔팀) vvvv
//	엔지니어 
//	프로젝트 배정 받았을때 (엔팀-> 엔지니어) vvvv
//	오늘 정기점검이면 (메인들어오면서)
//	긴급 요청 받았을때 (클라-> 엔지니어)
//
//	클라
//	엔지니어 배정 받았을때 vvvv
//	오늘 정기점검날일때
	
	@Autowired
	@Qualifier("alarmService")
	private AlarmService alarmService;
	
	 @PostMapping("/createPro") //클라이언트가 프로젝트 요청했을 때 (관리자에게 알림) UserApply
	 public void createPro(@RequestBody Map<String, Object> map){
		 alarmService.createProAlarm(map.get("proname").toString());//프로젝트명 필요	    
	 }
	 
	 @PostMapping("/assignTeam") // 관리자가 팀 배정 했을 때 (해당 팀 팀장에게 알림) AdminproModal
	 public void assignTeam(@RequestBody Map<String, Object> map) {
		 alarmService.assignTeam(map.get("select_team").toString()); //팀명 필요
		 
	 }
	 @PostMapping("/assignEngineer") // 팀장이 팀원 배정했을 때 (해당 팀원 , 클라이언트에게 알림) EnL_TeamassginmentModal
	 public void assignEngineer(@RequestBody Map<String,Object> map) {
		 alarmService.assignEngineer(map.get("engId").toString()); //엔지니어아이디 필요
		 alarmService.assignClient(map.get("cusId").toString()); //프로젝트 담당자 아이디 필요
	 }
	 
	 
	 
	 

}
