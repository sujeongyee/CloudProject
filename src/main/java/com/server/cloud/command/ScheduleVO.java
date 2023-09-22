package com.server.cloud.command;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ScheduleVO {
	
	private String sche_num;
	private Timestamp sche_startdate;
	private Timestamp sche_enddate;
	private String sche_name;
	private String eng_enid;
	private String server_name;
	private String server_id;
	private String pro_name;
	private String pro_id;
	private String eng_name;
	private String eng_phone;
}
