
package com.server.cloud.admin.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.server.cloud.command.CsVO;
import com.server.cloud.command.CusVO;
import com.server.cloud.command.EngineerVO;
import com.server.cloud.command.NoticeVO;
import com.server.cloud.command.ProjectCusVO;
import com.server.cloud.command.ServerVO;
import com.server.cloud.pagenation.Criteria;
import com.server.cloud.s3.AwsMapper;

@Service("adminSerivce")
public class AdminServiceImpl implements AdminService{

	@Autowired
	AdminMapper adminMapper;
	@Autowired
	AwsMapper awsMapper;

	@Override
	public void setAnno(NoticeVO vo) {
		awsMapper.setAnno(vo);
  }
	@Override
	public void UpAnno(NoticeVO vo) {
		awsMapper.UpAnno(vo);
	};
//회원관리 - 엔지니어
	@Override
	public List<EngineerVO> adEngineerList(EngineerVO engineerVO) {
		return adminMapper.adEngineerList(engineerVO);
  }
  	@Override
	public int getTotal() {
		// TODO Auto-generated method stub
		return adminMapper.getTotal();
	}
	@Override
	public List< NoticeVO> getList(Criteria cri) {
		// TODO Auto-generated method stub
		return adminMapper.getList(cri);
	};
	@Override
	public List<CusVO> adClientList(CusVO cusVO) {
		return adminMapper.adClientList(cusVO);
	}






	@Override
	public List<CsVO> csList(Criteria cri) {
		// TODO Auto-generated method stub
		return adminMapper.csList(cri);
	}





	@Override
	public int csTotal() {
		// TODO Auto-generated method stub
		return adminMapper.csTotal();
	}





	@Override
	public void csUpdate(CsVO vo) {
		// TODO Auto-generated method stub
		adminMapper.csUpdate(vo);
	}
	
	
	@Override
	public List<ProjectCusVO> newProjectList() {
		// TODO Auto-generated method stub
		return adminMapper.newProjectList();
	}
	@Override
	public List<ServerVO> getRequestServer(String pro_id) {
		// TODO Auto-generated method stub
		return adminMapper.getRequestServer(pro_id);
	}
	@Override
	public Map<String, Object> getRequestDetail(String pro_id) {
		// TODO Auto-generated method stub
		return adminMapper.getRequestDetail(pro_id);
	}
	@Override
	public List<EngineerVO> getTeamLeader() {
		// TODO Auto-generated method stub
		return adminMapper.getTeamLeader();
	}
	@Override
	public List<EngineerVO> getTeamMember() {
		// TODO Auto-generated method stub
		return adminMapper.getTeamMember();
	}
	@Override
	public int inputTeamNum(String pro_id, String team_num) {
		// TODO Auto-generated method stub
		return adminMapper.inputTeamNum(pro_id, team_num);
	}
		
	
	
	
}




