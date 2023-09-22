package com.server.cloud.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProjectCusVO {
	
	private String pro_id;
	private String pro_name;
	private String pro_startDate;
	private String pro_endDate;
	private String pro_rep;
	private String pro_status;
	private String pro_info;
	private String pro_pi;
	private String cus_id;
	private String cus_num;
	private String cus_company_name;
	private String cus_address1;
	private String cus_address2;
	private String cus_managet_name;
	private String cus_phone_number;
	private String cus_email;
	private String cus_business_id;
	private String cus_company_ph;
	private String cus_boss;
	
	private String team_num; //팀번호 
	private String eng_enid; //엔지니어 아이디 

}
