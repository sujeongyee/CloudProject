package com.server.cloud.s3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AwsServiceImpl implements AwsService{

	@Autowired
	AwsMapper awsMapper;
	
	
	@Override
	public void setInfo(FileVO fileVO) {


			awsMapper.setInfo(fileVO);
		
	}


	@Override
	public FileVO getImg(String userId) {
		// TODO Auto-generated method stub
		return awsMapper.getImg(userId);
	}


	

}
