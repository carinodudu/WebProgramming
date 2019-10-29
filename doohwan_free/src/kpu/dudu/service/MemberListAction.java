package kpu.dudu.service;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kpu.dudu.domain.MemberVO;
import kpu.dudu.persistance.MemberDAO;

public class MemberListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		HttpSession session = request.getSession();
		MemberDAO md = new MemberDAO();
		ArrayList<MemberVO> memberList = new ArrayList<MemberVO>();
		
		
		String userid = (String) session.getAttribute("userid");
		
		if(userid == null) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('회원만 회원정보를 확인할 수 있습니다!!!');");
			out.println("location.href='member/loginForm.jsp'");
			out.println("</script>");
			out.close();
			return null;
		} 
		
		memberList = md.getMemberList();
		
		if(memberList == null) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('회원이 없습니다ㅠ.ㅠ 두두 장터의 첫 회원이 되어주세요!!!');");
			out.println("location.href='member/loginForm.jsp'");
			out.println("</script>");
			out.close();
			return null;
		}
		
		request.setAttribute("memberList", memberList);
		forward.setRedirect(false);
		forward.setPath("member/list.jsp");
		return forward;
	}

}
