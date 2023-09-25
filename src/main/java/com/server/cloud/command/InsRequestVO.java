package com.server.cloud.command;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InsRequestVO {
	
	
	private String insRequest_num; //점검요청번호
	private String insRequest_type; //점검요청종류 
	private String insRequest_content; //점검요청내용
	private Date insRequest_regdate; //점검요청일 
	private String insRequest_check_yn; //점검요청확인
	private String cus_id; //고객아이디 
	private String server_id; //서버아이디 
	
	private String cus_company_name; //회사이름
	private String pro_name; //프로젝트이름
	private String server_name; //서버이름
	private String eng_name; //엔지니어이름
	private String pro_pi; //점검일 
	private String pro_id; //프로젝트아이디 

}
