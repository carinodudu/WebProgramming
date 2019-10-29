package org.kpu.dhcar.persistence;

import java.util.List;

import org.kpu.dhcar.domain.MemberVO;

public interface MemberDAO {
	public void add(MemberVO member) throws Exception;
	public List<MemberVO> readList() throws Exception;
	public MemberVO read(String id) throws Exception;
	public void delete(String id) throws Exception;
	public void update(MemberVO member) throws Exception;
}
