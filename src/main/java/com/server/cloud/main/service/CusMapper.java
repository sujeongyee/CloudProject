package com.server.cloud.main.service;

import javax.validation.Valid;

import org.apache.ibatis.annotations.Mapper;

import com.server.cloud.command.CusVO;
import com.server.cloud.s3.FileVO;


@Mapper
public interface CusMapper {

	void singIn(CusVO vo );

	CusVO idCheck(String string);

	void updateInfo(CusVO vo);

	void setPoto(FileVO file);


	
	
	
}
