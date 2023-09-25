package com.server.cloud.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EngineerVO {

	   private String eng_num;
	   private String eng_enid;
	   private String eng_name;
	   private String eng_phone;
	   private String eng_pw;
	   private String eng_rank;
	   private String eng_email;
	   private String team_num;
	   private String user_id;
	   private String team_id;
	   private String team_name;
}
