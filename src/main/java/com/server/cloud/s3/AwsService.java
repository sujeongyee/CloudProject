package com.server.cloud.s3;

public interface AwsService {

	void setInfo(FileVO fileVO);

	FileVO getImg(String userId);

	void setFile(FileVO fileVO);

	FileVO getFile(String file_num);

	void fileDel(String file_num);

	void AnnoDel(String notice_num);



}
