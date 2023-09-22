package com.server.cloud.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class QueryVO {
	
	private String month;
	private int periodic;
	private int disability;
	private int maintenance;
	private int teamCount;
	private int projectCount;
	private int serverCount;
	private int thisMonthStart;
	private int thisMonthEnd;
	
	
	
}
