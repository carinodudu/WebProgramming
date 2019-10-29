package org.kpu.dhcar.persistence;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.kpu.dhcar.domain.CarVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CarDAOImpl implements CarDAO {
	@Autowired
	private SqlSession sqlSession;
	
	private static final String namespace = "org.kpu.dhcar.mapper.CarMapper";

	@Override
	public List<CarVO> readList() throws Exception {
		List<CarVO> carList = new ArrayList<CarVO>();
		carList = sqlSession.selectList(namespace + ".selectAll");
		return carList;
	}

	@Override
	public CarVO read(String num) throws Exception {
		CarVO car = sqlSession.selectOne(namespace + ".selectBynum", num);
		return car;
	}

	@Override
	public void update(CarVO car) throws Exception {
		sqlSession.update(namespace + ".update", car);
	}

}
