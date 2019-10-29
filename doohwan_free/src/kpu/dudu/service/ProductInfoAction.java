package kpu.dudu.service;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kpu.dudu.domain.ProductVO;
import kpu.dudu.persistance.ProductDAO;

public class ProductInfoAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		HttpSession session = request.getSession();
		ProductDAO pd = new ProductDAO();
		ProductVO pv = new ProductVO();
		
		String userid = (String) session.getAttribute("userid");
		
		if(userid == null) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('회원만 물품의 상세정보를 확인할 수 있습니다!!!');");
			out.println("location.href='member/loginForm.jsp'");
			out.println("</script>");
			out.close();
			return null;
		}
		
		String inputPno = request.getParameter("pno");
		pv = pd.getProduct(inputPno);
		
		if(pv == null) {
			response.setContentType("text/html;charset=euc-kr"); 
            PrintWriter out =response.getWriter(); 
            out.println("<script>"); 
            out.println("alert('해당 물품은 이미 판매 완료됐습니다.');"); 
            out.println("location.href='product/list.jsp'");
            out.println("</script>");
            out.close(); 
            return null;
		}
		
		//redirect로 인해 request 객체에 같은 키의 객체가 이미 있을 이전 데이터 제거
		if(request.getAttribute("product") != null)
			request.removeAttribute("product");
		
		request.setAttribute("product", pv);
		forward.setRedirect(false);
		forward.setPath("product/info.jsp");
		
		return forward;
	}

}
