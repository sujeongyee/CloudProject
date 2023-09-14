package com.server.cloud.admin.service;

import java.util.List;
import java.util.Map;

import com.server.cloud.command.NoticeVO;
import com.server.cloud.pagenation.Criteria;

public interface AdminService {

	int getTotal();

	List<NoticeVO>  getList(Criteria cri);

	void setAnno(NoticeVO vo);

	void UpAnno(NoticeVO vo);
	
	
		
	
	
	
	
	
	
}
