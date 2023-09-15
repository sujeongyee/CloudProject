package com.server.cloud.main.service;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.apache.ibatis.annotations.Mapper;

import com.server.cloud.command.CusVO;
import com.server.cloud.command.NoticeCommentVO;
import com.server.cloud.command.NoticeVO;
import com.server.cloud.command.SearchVO;
import com.server.cloud.s3.FileVO;


@Mapper
public interface CusMapper {

	void singIn(CusVO vo );

	CusVO idCheck(String string);

	void updateInfo(CusVO vo);

	void setPoto(FileVO file);

	List<Map<String, String>> SearchInfo(SearchVO vo);

	String SearchCount(SearchVO vo);

	List<NoticeCommentVO> getComment(String notice_num);

	void CreateComments(NoticeCommentVO vo);

	void commentDel(NoticeCommentVO vo);

	void commentUp(NoticeCommentVO vo);


	
	
	
}
