package com.server.cloud.s3;

import java.util.List;

public interface AwsService {

	void setInfo(FileVO fileVO);

	FileVO getImg(String userId);

	void setFile(FileVO fileVO);
	
	int setFiles(List<FileVO> list, String user_id);
	

	List<FileVO> getFiles(String work_filenum);

	void fileDel(String file_num);

	void AnnoDel(String notice_num);

	void inQuryDel(String notice_num);

	void setFileCs(FileVO fileVO);
	



}
