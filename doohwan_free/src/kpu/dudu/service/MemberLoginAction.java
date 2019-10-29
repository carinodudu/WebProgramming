package kpu.dudu.service;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kpu.dudu.domain.MemberVO;
import kpu.dudu.persistance.MemberDAO;

public class MemberLoginAction implements Action {
	public static final int NO_MEMBER = -1; //계정 없음
	public static final int NO_PASSWD = 0; //패스워드 불일치
	public static final int YES = 1; //일치

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		HttpSession session = request.getSession();
		MemberDAO md = new MemberDAO();
		MemberVO mv = new MemberVO();
		
		int result = NO_MEMBER;
		
		String inputId = request.getParameter("userid"); //사용자가 입력한 아이디 패스워드
		String inputPasswd = request.getParameter("passwd");
		
		mv.setUserid(inputId);
		mv.setPasswd(inputPasswd);
		result = md.isMember(mv); // MemberDAO 클래스의 isMember() 메소드를 통해 로그인 여부 확인
		
		//아이디 O, 비밀번호 X
		if(result == NO_PASSWD) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('올바른 비밀번호를 입력해주세요.');");
			out.println("location.href='member/loginForm.jsp'");
			out.println("</script>");
			out.close();
			return null;
		} 
		//아이디 X, 비밀번호X
		else if(result == NO_MEMBER) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('존재하지 않는 아이디입니다.');");
			out.println("location.href='member/loginForm.jsp'");
			out.println("</script>");
			out.close();
			return null;
		}
		
		mv = md.getMember(inputId); //로그인 성공시 해당 아이디의 정보 가져옴
		
		session.setAttribute("userid", mv.getUserid());
		session.setAttribute("point", mv.getPoint());
		forward.setRedirect(false);
		forward.setPath("main/main.jsp");
		return forward;
	}

}
