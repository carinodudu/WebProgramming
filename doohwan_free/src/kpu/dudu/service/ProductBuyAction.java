package kpu.dudu.service;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kpu.dudu.domain.MemberVO;
import kpu.dudu.persistance.MemberDAO;

public class ProductBuyAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		HttpSession session = request.getSession();
		MemberDAO md = new MemberDAO();
		MemberVO mv = new MemberVO();
		
		int price = Integer.parseInt(request.getParameter("price"));
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
		
		mv = md.getMember(userid);
		
		//해당 아이디의 포인트가 물품 가격보다 적을 경우
		if(mv.getPoint() < price) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('포인트가 부족합니다.!!! 충전하세요!!!');");
			out.println("location.href='member/pointForm.jsp'");
			out.println("</script>");
			out.close();
			
		} else {
			//구매 완료
			if(md.decreasePoint(userid, price)) {
				System.out.println(userid + "가 " + price + "point 사용함");
				
				//메인 페이지 포인트 갱신을 위한 세션 재설정
				session.removeAttribute("point");
				mv = md.getMember(userid);
				System.out.println("pointaction: " + mv.getPoint());
				session.setAttribute("point", mv.getPoint());
				
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('구매 완료했습니다.');");
				out.println("location.href='main/main.jsp'");
				out.println("</script>");
				out.close();
				
			} else { //구매 실패
				System.out.println("구매 실패");
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('구매를 완료하지 못 했습니다.');");
				out.println("location.href='main/main.jsp'");
				out.println("</script>");
				out.close();
				return null;
			}
		}
		
		forward.setRedirect(false);
		forward.setPath("main/main.jsp");
		return forward;
	}

}
