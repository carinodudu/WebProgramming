package org.kpu.dhcar.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kpu.dhcar.domain.CarVO;
import org.kpu.dhcar.persistence.CarDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:src/main/webapp/WEB-INF/spring/root-context.xml"
})
public class CarDAOTest {
	@Autowired
	private CarDAO dao;
	
	private static Logger logger = LoggerFactory.getLogger(CarDAOTest.class);
	
	@Test
	public void testReadByid() throws Exception {
		CarVO car;
		car = dao.read("12두1234");
		logger.info(car.toString());
	}
	
	@Test
	public void testReadList() throws Exception {
		List<CarVO> carList;
		carList = dao.readList();
		for(CarVO car : carList) {
			logger.info(car.toString());
		}
	}
}
