package org.kpu.dhcar.service;

import java.util.List;

import org.kpu.dhcar.domain.MemberVO;

public interface MemberService {
	
	public MemberVO readMember(String id) throws Exception;
	public List<MemberVO> readMemberList() throws Exception;
	public void addMember(MemberVO member) throws Exception;
	public void deleteMember(String id) throws Exception; 
	public void updateMember(MemberVO member) throws Exception;
	
}
