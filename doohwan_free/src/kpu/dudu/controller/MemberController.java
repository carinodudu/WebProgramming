package kpu.dudu.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kpu.dudu.service.Action;
import kpu.dudu.service.ActionForward;
import kpu.dudu.service.MemberInfoAction;
import kpu.dudu.service.MemberJoinAction;
import kpu.dudu.service.MemberListAction;
import kpu.dudu.service.MemberLoginAction;
import kpu.dudu.service.MemberPointAction;

/**
 * Servlet implementation class MemberController
 */
@WebServlet("/Member")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String cmd = "";
		HttpSession session = request.getSession();
		cmd = request.getParameter("key");
		
		ActionForward forward = null;
		Action action = null;
		
		if(cmd.equals("login")) {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("member/loginForm.jsp");
			
			//로그아웃시 세션 연결 해제
			if(session.getAttribute("userid") != null) {
				session.removeAttribute("userid");
				session.removeAttribute("point");
			}
			
		} else if(cmd.equals("loginaction")) {
			action = new MemberLoginAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} else if(cmd.equals("join")) {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("member/joinForm.jsp");
			
		} else if(cmd.equals("joinaction")) {
			action = new MemberJoinAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} else if(cmd.equals("listaction")) {
			action = new MemberListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} else if(cmd.equals("infoaction")) {
			action = new MemberInfoAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} else if(cmd.equals("point")) {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("member/pointForm.jsp");
			
		} else if(cmd.equals("pointaction")) {
			action = new MemberPointAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if(forward != null) {
			if(forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
				return;
			} else {
				RequestDispatcher dis = request.getRequestDispatcher(forward.getPath());
				dis.forward(request, response);
			}
		}
	}

}
