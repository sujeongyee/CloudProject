package com.server.cloud.command;

import java.sql.Date;
import java.sql.Time;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EngSerProInfoWorkInfoVO {
	
	private String eng_enid;
	private String eng_name;
	private String pro_id;
	private String pro_name;
	
}
