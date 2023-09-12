package com.server.cloud.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjectInfoVO {
	
	private String pro_id; //프로젝트 아이디 
	private String pro_name; //프로젝트명 
	private String pro_startdate; //시작일
	private String pro_enddate; //만료일 
	private String pro_rep; //프로젝트(고객) 담당자 
	private String pro_status; //계약 상태
	private String pro_info; //프로젝트 정보 
	private String pro_pi; //정기점검 요청 날짜 
	
	private String team_num; //팀번호 
	private String cus_id; //고객아이디 
	private String cus_company_name;

}
