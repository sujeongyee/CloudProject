package com.server.cloud.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmailVO {

	private String email;
	private String emailNum;
	private String cus_email;
	private String cus_managet_name;
	private String cus_business_id;
	private String cus_id;
}
