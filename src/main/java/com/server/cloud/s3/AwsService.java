package com.server.cloud.s3;

public interface AwsService {

	void setInfo(FileVO fileVO);

	FileVO getImg(String userId);



}
