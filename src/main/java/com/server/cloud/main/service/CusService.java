package com.server.cloud.main.service;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.server.cloud.command.CusVO;
import com.server.cloud.s3.FileVO;




public interface CusService {

	void singIn(CusVO vo);

	CusVO idCheck(String string);

	void updateInfo(CusVO vo);

	

	void setPoto(FileVO file);

	
	
}
