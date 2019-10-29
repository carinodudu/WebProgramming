package org.kpu.dhcar.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.kpu.dhcar.domain.MemberVO;
import org.kpu.dhcar.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value="/member")
public class MemberController {
	
	@Autowired
    private MemberService memberService;

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@RequestMapping(value = {"/list"}, method = RequestMethod.GET)
    public String listMember(Model model) throws Exception {
    	List<MemberVO> memberList = memberService.readMemberList();
    	
		logger.info(" /member/list URL called. then listMemebr method executed.");
        model.addAttribute("memberList", memberList);
        return "member/member_list";
    }
    
    @RequestMapping(value = "/read", method = RequestMethod.GET)
    public String readMember(@RequestParam("id") String id, Model model) throws Exception {
    	MemberVO member = memberService.readMember(id);
    	
		logger.info(" /read?id=kang URL called. then readMemebr method executed.");
        model.addAttribute("member", member);
        return "member/member_read";
    }
    
	@RequestMapping(value = {"/register"}, method = RequestMethod.GET)
	public String createMemberGet() throws Exception {
		logger.info(" /register URL GET method called. then forward member_register.jsp.");
		return "member/member_register";
	}
	
    
    @RequestMapping(value = {"/register"}, method = RequestMethod.POST)
	public String createMemberPost( @ModelAttribute("student") MemberVO member) throws Exception {
		memberService.addMember(member);
		logger.info(member.toString());
		logger.info(" /register URL POST method called. then createMember method executed.");
		return "redirect:/member/list";
	}
	
            
    @RequestMapping(value = "/modify", method = RequestMethod.GET)
    public String modifyMemberGet(@RequestParam("id") String id, Model model) throws Exception {
    	MemberVO member = memberService.readMember(id);
    	
		logger.info(" /modify?id=kang URL GET method called. then forward member_modify.jsp.");
        model.addAttribute("member", member);
        return "member/member_modify";
    }
    
    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    public String modifyMemberPost(@ModelAttribute("member") MemberVO member) throws Exception {
    	memberService.updateMember(member);
		logger.info(member.toString());
		logger.info(" /modify?id=kang URL POST method called. then modifyMemberPost method executed.");
        return "redirect:/member/list";
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginCheck(HttpSession session, @RequestParam("id") String id, @RequestParam("passwd") String passwd, Model model) throws Exception {
    	// 기존 login이란 세션 값이 존재하면 기존 값 제거
    	if(session.getAttribute("login") != null) {
    		session.removeAttribute("login");
    	}
    	
    	MemberVO member = memberService.readMember(id);
    	
    	// 로그인 성공 시 세션에 login이란 키로 저장
    	// 실패 시 홈으로 리다이렉트
    	if(member != null && member.getPasswd().equals(passwd) == true) {
    		session.setAttribute("login", member);
    		return "forward:/car/list";
    	}
    	else {
    		return "redirect:/";
    	}
    }
   
}
