package org.kpu.dhcar.controller;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.kpu.dhcar.domain.CarVO;
import org.kpu.dhcar.domain.MemberVO;
import org.kpu.dhcar.service.CarService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value="/car")
public class CarController {

	@Autowired
	private CarService carService;
	
	private static final Logger logger = LoggerFactory.getLogger(CarController.class);
	
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public String listCarPost(Model model) throws Exception {
		List<CarVO> carList = carService.readCarList();
		logger.info(" /car/list URL called. then listCarPost method executed.");
		model.addAttribute("carList", carList);
		return "car/car_list";
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listCarGet(Model model) throws Exception {
		List<CarVO> carList = carService.readCarList();
		logger.info(" /car/list URL called. then listCarGet method executed.");
		model.addAttribute("carList", carList);
		return "car/car_list";
	}
	
	@RequestMapping(value = "/book", method = RequestMethod.GET)
	public String bookCar(HttpSession session, @RequestParam("num") String num, Model model) throws Exception {
		CarVO car = carService.readCar(num);
		logger.info(" /book?num=${car.num} URL GET method called. then forward car_book.jsp.");
		// 세션에서 현재 로그인된 계정의 아이디로 예약시 자동으로 수정
		MemberVO member = (MemberVO)session.getAttribute("login");
		String booker = member.getId();
		
		car.setBooker(booker);
		carService.updateCar(car);
		model.addAttribute("car", car);
		return "car/car_book";
	}
	
	
}