package com.server.cloud.main.service;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.server.cloud.command.CsVO;
import com.server.cloud.command.CusVO;
import com.server.cloud.command.EngineerVO;
import com.server.cloud.command.NoticeCommentVO;
import com.server.cloud.command.NoticeVO;
import com.server.cloud.command.SearchVO;
import com.server.cloud.command.ServerVO;
import com.server.cloud.s3.FileVO;

@Service
public class CusServiceImpl implements CusService{

	
	@Autowired
	private CusMapper userMapper;
	
	@Override
	public void singIn(CusVO vo) {

		userMapper.singIn(vo);
		
	}

	@Override
	public CusVO idCheck(String string) {
		// TODO Auto-generated method stub
		return userMapper.idCheck(string);
	}

	@Override
	public void updateInfo(CusVO vo) {
		userMapper.updateInfo(vo);
		
	}


	@Override
	public void setPoto(FileVO file) {
		// TODO Auto-generated method stub
		userMapper.setPoto(file);
	}

	@Override
	public List<Map<String, String>> SearchInfo(SearchVO vo) {
		// TODO Auto-generated method stub
		return userMapper.SearchInfo(vo);
	}

	@Override
	public String searchCount(SearchVO vo) {
		// TODO Auto-generated method stub
		return userMapper.SearchCount(vo);
	}

	@Override
	public List<NoticeCommentVO> getComment(String notice_num) {
		// TODO Auto-generated method stub
		return userMapper.getComment(notice_num);
	}

	@Override
	public void CreateComments(NoticeCommentVO vo) {
		// TODO Auto-generated method stub
		userMapper.CreateComments(vo);
	}

	@Override
	public void commentDel(NoticeCommentVO vo) {
		// TODO Auto-generated method stub
		userMapper.commentDel(vo);
	}

	@Override
	public void commentUp(NoticeCommentVO vo) {
		// TODO Auto-generated method stub
		userMapper.commentUp(vo);
	}

	@Override

	public List<ServerVO> getServerList(String pro_id) {
		// TODO Auto-generated method stub
		return userMapper.getServerList(pro_id);
	}

	@Override
	public void quryeWrite(CsVO csVo) {
		// TODO Auto-generated method stub
		userMapper.quryeWrite(csVo);
	}

	@Override
	public String getId(CusVO id) {
		// TODO Auto-generated method stub
		return userMapper.getId(id);
	}

	@Override
	public CusVO emailCheck(String email) {
		// TODO Auto-generated method stub
		return userMapper.emailCheck(email);
	}

	@Override
	public String getIdPw(CusVO id) {
		// TODO Auto-generated method stub
		return userMapper.getIdPw(id);
	}

	@Override
	public void resetPw(CusVO vo) {
		// TODO Auto-generated method stub
		userMapper.resetPw(vo);
  @Override
	public EngineerVO idCheckEng(String eng_id) {
		// TODO Auto-generated method stub
		return userMapper.idCheckEng(eng_id);

	}



}
