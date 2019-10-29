package kpu.dudu.service;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kpu.dudu.domain.MemberVO;
import kpu.dudu.persistance.MemberDAO;

public class MemberJoinAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		ActionForward forward = new ActionForward();
		MemberDAO md = new MemberDAO();
		MemberVO mv = new MemberVO();
		boolean result = false;
		
		String userid = request.getParameter("userid");
		String passwd = request.getParameter("passwd");
		String username = request.getParameter("username");
		String tel = request.getParameter("tel");
		String email = request.getParameter("email");
		
		if(userid != "" && passwd != "" && username != "" && tel != "" && email != "") { //정보 입력 여부 확인
			if(md.getMember(userid) == null) { // 아이디 중복 여부 확인
				mv.setUserid(userid);
				mv.setPasswd(passwd);
				mv.setUsername(username);
				mv.setTel(tel);
				mv.setEmail(email);
				mv.setSex(request.getParameter("sex"));
				mv.setPoint(0);
				result = md.joinMember(mv);
			} else {
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('아이디가 이미 있습니다.');");
				out.println("location.href='member/joinForm.jsp'");
				out.println("</script>");
				out.close();
			}
		} else {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('모든 정보를 공백없이 입력해주세요.');");
			out.println("location.href='member/joinForm.jsp'");
			out.println("</script>");
			out.close();
		}
		
		//회원가입 실패시
		if(result == false) {
			System.out.println("회원가입 실패");
			return null;
		}
		
		//회원가입 성공시
		request.setAttribute("username", mv.getUsername());//회원가입 결과 페이지에서 이용
		forward.setRedirect(false);
		forward.setPath("member/joinResult.jsp");
		
		return forward;
	}

}
