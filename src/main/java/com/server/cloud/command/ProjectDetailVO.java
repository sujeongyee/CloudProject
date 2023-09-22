package com.server.cloud.command;

import java.sql.Time;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjectDetailVO {
	
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
	
	private String server_id; //서버아이디 
	private String server_name; //서버 이름 
	private String ip_address; //ip주소 
	private String server_status; //서버 상태 
	private String operating_system; //운영체제 
	private String cpu; //cpu정보 
	private int ram; //ram 용량 
	private int disk_capacitygb; //디스크 용량 
	
	private String eng_enid; //엔지니어 아이디 
	private String eng_name; //엔지니어 이름 
	
	private String eng_phone; //엔지니어 연락처 
	private String eng_pw; // 엔지니어 비밀번호 
	private String eng_rank; // 엔지니어 직급 
	private String eng_email; //엔지니어 이메일  
	
	private String user_id; //사용자명 
	
	 @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
	private Date work_date;
	private String work_division;
	private String work_status;
	private String work_cpu;
	private String work_ram;
	private String work_hdd;
	private String work_estimate;
	private String work_note;
	///////////////////////////////
	
	private String team_id;
	private Time work_time;
	

}
