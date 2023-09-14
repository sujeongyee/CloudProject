package com.server.cloud.command;

import java.sql.Date;
import java.sql.Time;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WorkInfoVO {

	private String work_num;
	private Date work_date;
	private String work_division;
	private Time work_time;
	private String work_cpu;
	private String work_ram;
	private String work_hdd;
	private String work_status;
	private String work_note;
	private String work_estimate;
	private String server_id;
	private String eng_enid;
	private String pro_id;
	
	//작업세부목록시 필요
	private String eng_name;
	private String pro_name; //프로젝트명
	private String server_name; //서버 이름
	

}
