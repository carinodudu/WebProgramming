package kpu.dudu.service;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kpu.dudu.domain.ProductVO;
import kpu.dudu.persistance.ProductDAO;

public class ProductListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		ProductDAO pd = new ProductDAO();
		ArrayList<ProductVO> productList = new ArrayList<ProductVO>();
		ServletContext context = request.getServletContext();
		
		productList = pd.getProductList();
		
		if(productList == null) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('판매 중인 물건이 없습니다. 첫 판매자가 되어주세요ㅠ.ㅠ');");
			out.println("location.href='main/main.jsp'");
			out.println("</script>");
			out.close();
			return null;
		}
		
		if(context.getAttribute("productList") != null) {
			context.removeAttribute("productList");
			context.setAttribute("productList", productList);
		} else {
			context.setAttribute("productList", productList);
		}
		
		forward.setRedirect(false);
		forward.setPath("product/list.jsp");
		return forward;
	}

}
