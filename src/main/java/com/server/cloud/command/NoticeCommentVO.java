package com.server.cloud.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NoticeCommentVO {

		private String com_num;
		private String com_writer;
		private String com_content;
		private String com_regdate;
		private String notice_num;
		
	
}
