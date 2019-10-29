package org.kpu.dhcar.persistence;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.kpu.dhcar.domain.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAOImpl implements MemberDAO {
	@Autowired
	private SqlSession sqlSession;
	
	private static final String namespace = "org.kpu.dhcar.mapper.MemberMapper";
	
	
	@Override
	public void add(MemberVO member) throws Exception {
		sqlSession.insert(namespace + ".insert", member);

	}

	@Override
	public List<MemberVO> readList() throws Exception {
		List<MemberVO> memberList = new ArrayList<MemberVO>();
		memberList = sqlSession.selectList(namespace + ".selectAll");
		return memberList;
	}

	@Override
	public MemberVO read(String id) throws Exception {
		MemberVO member = sqlSession.selectOne(namespace + ".selectByid", id);
		return member;
	}

	@Override
	public void delete(String id) throws Exception {
		sqlSession.delete(namespace + ".delete", id); 

	}

	@Override
	public void update(MemberVO member) throws Exception {
		sqlSession.update(namespace + ".update", member);

	}

}
