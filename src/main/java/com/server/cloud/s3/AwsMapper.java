package com.server.cloud.s3;

import org.apache.ibatis.annotations.Mapper;

import com.server.cloud.command.NoticeVO;

@Mapper
public interface AwsMapper {

	void setInfo(FileVO fileVO);

	FileVO getImg(String userId);

	void setFile(FileVO fileVO);

	void setAnno(NoticeVO vo);

	FileVO getFile(String file_num);

	void UpAnno(NoticeVO vo);

	void fileDel(String file_num);

	void AnnoDel(String notice_num);


}
