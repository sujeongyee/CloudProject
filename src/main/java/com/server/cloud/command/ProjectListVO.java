package com.server.cloud.command;

import java.security.Timestamp;
import java.sql.Time;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProjectListVO {
//    P.PRO_NAME AS pro_name,
//    S.SERVER_NAME AS server_name,
//    E.ENG_NAME AS eng_name,
//    W.WORK_DATE AS work_date,
//    W.WORK_DIVISION AS work_division,
//    W.WORK_TIME AS work_time,
//    W.WORK_CPU AS work_cpu,
//    W.WORK_RAM AS work_ram,
//    W.WORK_HDD AS work_hdd,
//    S.SERVER_STATUS AS server_status,
//    W.WORK_NOTE AS work_note,
//    W.WORK_ESTIMATE AS work_estimate,
//    W.PRO_ID AS pro_id
	/////////////////
	private String pro_name;
	private String eng_name;
	 @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
	private Date work_date;
	private String work_division;
	private String server_name;
	private String server_status;
	private String work_status;
	private String work_cpu;
	private String work_ram;
	private String work_hdd;
	private String work_estimate;
	///////////////////////////////
	
	private String team_id;
	private String eng_phone;
	private Time work_time;
	private String work_note;
	
	////////////////////////////////
	private String pro_id;

}
