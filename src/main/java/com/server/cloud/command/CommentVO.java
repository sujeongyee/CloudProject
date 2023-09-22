package com.server.cloud.command;

import java.security.Timestamp;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommentVO {

//############# 공지답변 테이블 ################
//CREATE TABLE NOTICE_COMMENT ( #공지사항 댓글테이블
//   COM_NUM VARCHAR(100) DEFAULT (UUID()) PRIMARY KEY, # 댓글번호 
//    COM_WRITER VARCHAR(100), # 댓글작성자
//    COM_CONTENT VARCHAR(1000), # 댓글내용
//    COM_REGDATE TIMESTAMP DEFAULT NOW(), # 댓글작성일
//    NOTICE_NUM VARCHAR(50) # 공지사항번호
//);
	
	private String com_num;
	private String com_writer;
	private String com_content;
	private LocalDate com_regdate;
	private String notice_num;
	private String delete_yn;


}
