package com.server.cloud.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ServerVO {
	
	private String server_id; //서버아이디 
	private String server_name; //서버 이름 
	private String ip_address; //ip주소 
	private String server_status; //서버 상태 
	private String operating_system; //운영체제 
	private String cpu; //cpu정보 
	private int ram; //ram 용량 
	private int disk_capacitygb; //디스크 용량 
	private String pro_id; //프로젝트 아이디 
	private String eng_enid; //엔지니어 아이디 
	private String eng_name;

}
