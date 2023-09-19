package com.server.cloud.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SearchVO {

	
	private String table;
	private String columm;
	private String value;
	private String order;//오름차순 내림차순 할 컬럼
	private String cs_writer;//작성자
}
