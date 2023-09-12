package com.server.cloud.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProjectInfoVO {

	private String pro_id;
	private String pro_name;
	private String pro_startDate;
	private String pro_endDate;
	private String pro_rep;
	private String pro_status;
	private String pro_info;
	private String pro_pi;
	private String team_num;
	private String cus_id;
	
	
}
