package kpu.dudu.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kpu.dudu.service.Action;
import kpu.dudu.service.ActionForward;
import kpu.dudu.service.ProductBuyAction;
import kpu.dudu.service.ProductInfoAction;
import kpu.dudu.service.ProductListAction;
import kpu.dudu.service.ProductSellAction;

/**
 * Servlet implementation class MemberController
 */
@WebServlet("/Product")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductController() {
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
		cmd = request.getParameter("key");
		
		ActionForward forward = null;
		Action action = null;
		
		if(cmd.equals("list")) {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("product/list.jsp");
			
		} else if(cmd.equals("listaction")) {
			action = new ProductListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} else if(cmd.equals("infoaction")) {
			action = new ProductInfoAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} else if(cmd.equals("buyaction")) {
			action = new ProductBuyAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} else if(cmd.equals("sell")) {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("product/sellForm.jsp");
		}
		
		else if(cmd.equals("sellaction")) {
			action = new ProductSellAction();
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
