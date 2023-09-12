package com.server.cloud.admin.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.server.cloud.command.NoticeVO;
import com.server.cloud.pagenation.Criteria;

@Service("adminSerivce")
public class AdminServiceImpl implements AdminService{

	@Autowired
	AdminMapper adminMapper;
	
	
	@Override
	public int getTotal() {
		// TODO Auto-generated method stub
		return adminMapper.getTotal();
	}





	@Override
	public List< NoticeVO> getList(Criteria cri) {
		// TODO Auto-generated method stub
		return adminMapper.getList(cri);
	};
	

}
