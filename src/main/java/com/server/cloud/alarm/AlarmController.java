package com.server.cloud.alarm;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/alarm")
public class AlarmController {
	
	@Autowired
	@Qualifier("alarmService")
	private AlarmService alarmService;
	
	 @PostMapping("/createPro")
	 public void createPro(@RequestBody Map<String, Object> map){
		 
		 alarmService.createProAlarm(map.get("proname").toString());
		 
	    
	 }


}
