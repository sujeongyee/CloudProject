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
	private String ALARM_NUM;
	private String ALARM_CONTENT;
	private String ALARM_TYPE;
	private Timestamp ALARM_DATE;
	private String ALARM_CHECK_YN;
	private String ALARM_RECEIVER;
}
