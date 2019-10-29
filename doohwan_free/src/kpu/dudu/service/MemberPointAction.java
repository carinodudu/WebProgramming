package kpu.dudu.service;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kpu.dudu.domain.MemberVO;
import kpu.dudu.persistance.MemberDAO;

public class MemberPointAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		HttpSession session = request.getSession();
		MemberDAO md = new MemberDAO();
		MemberVO mv = new MemberVO();
		
		int point = Integer.parseInt(request.getParameter("point"));
		String userid = (String) session.getAttribute("userid");
		
		//세션에 아이디가 없을 경우
		if(userid == null) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('세션이 만료되었습니다. 다시 로그인 해주세용!!!');");
			out.println("location.href='member/loginForm.jsp'");
			out.println("</script>");
			out.close();
			return null;
		}
		
		//충전 완료
		if(md.increasePoint(userid, point)) {
			System.out.println(userid + "의 포인트가" + point + "충전됨");
			
			//메인 페이지 포인트 갱신을 위한 세션 재설정
			session.removeAttribute("point");
			mv = md.getMember(userid);
			System.out.println("pointaction: " + mv.getPoint());
			session.setAttribute("point", mv.getPoint());
			
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('" + point + " point 충전이 완료되었습니다.');");
			out.println("location.href='main/main.jsp'");
			out.println("</script>");
			out.close();
			
		} else { //충전 실패
			System.out.println("충전실패");
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('포인트 충전을 완료하지 못 했습니다.');");
			out.println("location.href='main/main.jsp'");
			out.println("</script>");
			out.close();
		}
		
		forward.setRedirect(false);
		forward.setPath("main/main.jsp");
		return forward;
	}

}
