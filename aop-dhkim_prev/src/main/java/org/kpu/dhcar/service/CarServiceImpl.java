package org.kpu.dhcar.service;

import java.util.List;

import org.kpu.dhcar.domain.CarVO;
import org.kpu.dhcar.persistence.CarDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CarServiceImpl implements CarService {
	@Autowired
	CarDAO carDAO;

	@Override
	public CarVO readCar(String num) throws Exception {
		return carDAO.read(num);
	}

	@Override
	public List<CarVO> readCarList() throws Exception {
		return carDAO.readList();
	}

	@Transactional(
			propagation = Propagation.REQUIRED,
			isolation = Isolation.READ_COMMITTED,
			timeout = 10
	)
	@Override
	public void updateCar(CarVO car) throws Exception {
		carDAO.update(car);
	}

}
