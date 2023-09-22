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

	private String cus_address1;
	private String cus_address2;
	private String cus_boss;
	private String cus_business_id;
	private String cus_company_name;
	private String cus_email;
	private String cus_company_ph;
	private String cus_id;
	private String cus_managet_name;
	private String cus_num;
	private String cus_phone_number;
	private String pro_enddate;
	private String pro_id;
	private String pro_info;
	private String pro_name;
	private String pro_pi;
	private String pro_rep;
	private String pro_startdate;
	private String pro_status;
	
}
