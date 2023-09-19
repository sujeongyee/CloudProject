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


	@Override
	public void setFile(FileVO fileVO) {
		awsMapper.setFile(fileVO);
	}


	@Override
	public FileVO getFile(String file_num) {
		// TODO Auto-generated method stub
		return awsMapper.getFile(file_num);
	}


	@Override
	public void fileDel(String file_num) {
		// TODO Auto-generated method stub
		awsMapper.fileDel(file_num);
	}


	@Override
	public void AnnoDel(String notice_num) {
		// TODO Auto-generated method stub
		awsMapper.AnnoDel(notice_num);
	}


	@Override
	public void inQuryDel(String notice_num) {
		// TODO Auto-generated method stub
		awsMapper.inQuryDel(notice_num);
	}


	@Override
	public void setFileCs(FileVO fileVO) {
		// TODO Auto-generated method stub
		awsMapper.setFileCs(fileVO);
	}


	

}
