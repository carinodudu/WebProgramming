package kpu.dudu.service;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kpu.dudu.domain.MemberVO;
import kpu.dudu.persistance.MemberDAO;

public class MemberInfoAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		HttpSession session = request.getSession();
		MemberDAO md = new MemberDAO();
		MemberVO mv = new MemberVO();
		
		String userid = (String) session.getAttribute("userid");
		
		if(userid == null) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('회원만 회원정보를 확인할 수 있습니다!!!');");
			out.println("location.href='member/loginForm.jsp'");
			out.println("</script>");
			out.close();
		}
		
		String inputid = request.getParameter("userid");
		mv = md.getMember(inputid);
		
		if(mv == null) {
			response.setContentType("text/html;charset=euc-kr"); 
            PrintWriter out =response.getWriter();
            out.println("<script>"); 
            out.println("alert('검색하신 아이디는 없습니다.');"); 
            out.println("location.href='main/main.jsp'");
            out.println("</script>");
            out.close();
		}
		
		request.setAttribute("member", mv);
		forward.setRedirect(false);
		forward.setPath("member/info.jsp");
		
		return forward;
	}

}
