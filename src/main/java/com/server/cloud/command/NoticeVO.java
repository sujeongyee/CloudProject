package com.server.cloud.command;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NoticeVO {

	
	private String notice_num;
	private String notice_title;
	private String notice_content;
	private Timestamp notice_regdate;
	private String notice_comment;
	private String notice_target;
	
	
}
