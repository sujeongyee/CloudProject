package com.server.cloud.command;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FormDataVO {
	
	private ProjectInfoVO proInfo;
	private ArrayList<ServerVO> serverInfo;
	private String cus_id;
	
}
