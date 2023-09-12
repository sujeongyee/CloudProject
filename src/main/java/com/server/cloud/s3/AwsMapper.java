package com.server.cloud.s3;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AwsMapper {

	void setInfo(FileVO fileVO);

	FileVO getImg(String userId);


}
