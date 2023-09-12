package com.server.cloud.admin.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.server.cloud.command.NoticeVO;
import com.server.cloud.pagenation.Criteria;

@Mapper
public interface AdminMapper {

	int getTotal();

	List<NoticeVO> getList(Criteria cri);
	
	
}
