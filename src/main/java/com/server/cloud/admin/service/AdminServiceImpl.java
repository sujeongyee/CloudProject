
package com.server.cloud.admin.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.server.cloud.command.CsVO;
import com.server.cloud.command.CusVO;
import com.server.cloud.command.EngineerVO;
import com.server.cloud.command.NoticeVO;
import com.server.cloud.pagenation.Criteria;
import com.server.cloud.s3.AwsMapper;

@Service("adminSerivce")
public class AdminServiceImpl implements AdminService{

	@Autowired
	AdminMapper adminMapper;
	@Autowired
	AwsMapper awsMapper;
	
	

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
	public int getTotal(String role) {
		// TODO Auto-generated method stub
		return adminMapper.getTotal(role);
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
	@Override
	public int csUserTotal(String cs_writer) {
		// TODO Auto-generated method stub
		return adminMapper.csUserTotal(cs_writer);
	}
	@Override
	public List<CsVO> csEnList(Criteria cri) {
		// TODO Auto-generated method stub
		return adminMapper.csEnList(cri);
	}
	@Override
	public EngineerVO engGetinfo(String cs_writer) {
		// TODO Auto-generated method stub
		return adminMapper.engGetinfo(cs_writer);
	}
	@Override
	public int csEnTotal(Criteria cri) {
		// TODO Auto-generated method stub
		return adminMapper.csEnTotal(cri);
	}
	@Override
	public List<CsVO> csEnListMy(Criteria cri) {
		// TODO Auto-generated method stub
		return adminMapper.csEnListMy(cri);
	}
	@Override
	public List<CsVO> csEnLeaderList(Criteria cri) {
		// TODO Auto-generated method stub
		return adminMapper.csEnLeaderList(cri);
	}
	@Override
	public List<CsVO> csEnLeaderListMy(Criteria cri) {
		// TODO Auto-generated method stub
		return adminMapper.csEnLeaderListMy(cri);
	}
}





