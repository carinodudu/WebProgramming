package org.kpu.dhcar.service;

import java.util.List;

import org.kpu.dhcar.domain.MemberVO;
import org.kpu.dhcar.persistence.MemberDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberDAO memberDAO;

	@Override
	public MemberVO readMember(String id) throws Exception {
		return memberDAO.read(id);
	}

	@Override
	public List<MemberVO> readMemberList() throws Exception {
		return memberDAO.readList();
	}

	@Override
	public void addMember(MemberVO member) throws Exception {
		memberDAO.add(member);

	}

	@Override
	public void deleteMember(String id) throws Exception {
		memberDAO.delete(id);

	}

	@Transactional(
			propagation = Propagation.REQUIRED,
			isolation = Isolation.READ_COMMITTED,
			timeout = 10
	)
	@Override
	public void updateMember(MemberVO member) throws Exception {
		memberDAO.update(member);

	}

}
