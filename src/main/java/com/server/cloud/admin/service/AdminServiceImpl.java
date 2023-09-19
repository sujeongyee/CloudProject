
package com.server.cloud.admin.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.server.cloud.command.CsVO;
import com.server.cloud.command.CusVO;
import com.server.cloud.command.EngineerVO;
import com.server.cloud.command.NoticeVO;
import com.server.cloud.command.ProjectDetailVO;
import com.server.cloud.command.ProjectInfoVO;
import com.server.cloud.command.WorkInfoVO;
import com.server.cloud.pagenation.Criteria;
import com.server.cloud.s3.AwsMapper;

@Service("adminSerivce")
public class AdminServiceImpl implements AdminService{

	@Autowired
	AdminMapper adminMapper;
	@Autowired
	AwsMapper awsMapper;
	
	@Override
	public int getTotal() {
		// TODO Auto-generated method stub
		return adminMapper.getTotal();
	}

	@Override
	public List< NoticeVO> getList(Criteria cri) {
		// TODO Auto-generated method stub
		return adminMapper.getList(cri);
	}
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
	
	//프로젝트 리스트 불러오기 
	@Override
	public ArrayList<ProjectInfoVO> getProList() {
		return adminMapper.getProList();
	}
	
	//프로젝트 디테일 (모달)
	@Override
	public ArrayList<ProjectDetailVO> getProListDetail(String pro_id) {
		return adminMapper.getProListDetail(pro_id);
	}
	
	//서버 점검내역 (모달)
	@Override
	public ArrayList<WorkInfoVO> getServerInsList(String server_id) {
		return adminMapper.getServerInsList(server_id);
	}
	
}





