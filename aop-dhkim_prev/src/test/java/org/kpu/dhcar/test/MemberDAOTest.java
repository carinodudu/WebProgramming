package org.kpu.dhcar.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kpu.dhcar.domain.MemberVO;
import org.kpu.dhcar.persistence.MemberDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:src/main/webapp/WEB-INF/spring/root-context.xml"
})
public class MemberDAOTest {
	@Autowired
	private MemberDAO dao;
	
	private static Logger logger = LoggerFactory.getLogger(MemberDAOTest.class);
	
	@Test
	public void testReadByid() throws Exception {
		MemberVO member;
		member = dao.read("dhkim");
		logger.info(member.toString());
	}
	
	@Test
	public void testReadList() throws Exception {
		List<MemberVO> memberList;
		memberList = dao.readList();
		for(MemberVO member : memberList) {
			logger.info(member.toString());
		}
	}
}
