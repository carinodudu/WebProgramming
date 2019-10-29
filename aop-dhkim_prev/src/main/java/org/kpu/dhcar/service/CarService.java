package org.kpu.dhcar.service;

import java.util.List;

import org.kpu.dhcar.domain.CarVO;

public interface CarService {
	
	public CarVO readCar(String num) throws Exception;
	public List<CarVO> readCarList() throws Exception;
	public void updateCar(CarVO car) throws Exception;
	
}
