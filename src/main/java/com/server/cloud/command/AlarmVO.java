package com.server.cloud.command;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AlarmVO {

	private String alarm_num;
	private String alarm_content;
	private String alarm_type;
	private Timestamp alarm_date;
	private String alarm_check_yn;
	private String alarm_receiver;
}

