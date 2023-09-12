package com.server.cloud.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ServerVO {
	
	private String server_id;
	private String server_name;
	private String ip_address;
	private String server_status;
	private String operating_system;
	private String cpu;
	private Integer ram;
	private Integer disk_capacitygb;
	private String pro_id;
	private String eng_enid;
	

}
