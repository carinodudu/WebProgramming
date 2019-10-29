package org.kpu.dhcar.persistence;

import java.util.List;

import org.kpu.dhcar.domain.CarVO;

public interface CarDAO {
	public List<CarVO> readList() throws Exception;
	public CarVO read(String num) throws Exception;
	public void update(CarVO car) throws Exception;
}
