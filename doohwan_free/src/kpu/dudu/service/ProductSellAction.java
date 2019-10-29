package kpu.dudu.service;

import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kpu.dudu.domain.ProductVO;
import kpu.dudu.persistance.ProductDAO;

public class ProductSellAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		ActionForward forward = new ActionForward();
		ProductDAO pd = new ProductDAO();
		ProductVO pv = new ProductVO();
		HttpSession session = request.getSession();
		ServletContext context = request.getServletContext();
		
		boolean result = false;
		
		int pno = pd.getProductList().size() + 1; //임의로 지정
		String userid = (String) session.getAttribute("userid");
		
		if(userid == null) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('회원만 판매 물품 등록할 수 있습니다!!!');");
			out.println("location.href='member/loginForm.jsp'");
			out.println("</script>");
			out.close();
			return null;
		}
		
		String pname = request.getParameter("pname");
		String category = request.getParameter("category");
		String price = request.getParameter("price");
		String info = request.getParameter("info");
		String image = "hood.jpg"; //임의로 지정
		
		if(pname != "" && category != "" && price != "" && info != "" && image != "") { //정보 입력 여부 확인
			if(pd.getProduct(String.valueOf(pno)) == null) { // 물품번호 중복 여부 확인
				pv.setPno(pno);
				pv.setUserid(userid);
				pv.setPname(pname);
				pv.setCategory(category);
				pv.setPrice(Integer.parseInt(price));
				pv.setInfo(info);
				pv.setImage(image);
				
				result = pd.sellProduct(pv);
			} else {
				System.out.println("물품 번호 중복 발생!!!");
				return null;
			}
		} else {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('모든 정보를 공백없이 입력해주세요.');");
			out.println("location.href='product/sellForm.jsp'");
			out.println("</script>");
			out.close();
			return null;
		}
		//판매 물품 등록 실패시
		if(result == false) {
			System.out.println("판매 물품 등록 실패");
			return null;
		}
		
		//판매 물품 등록 성공시 애플리케이션 내장객체 갱신
		if(context.getAttribute("productList") != null) {
			context.removeAttribute("productList");
			context.setAttribute("productList", pd.getProductList());
		} else {
			context.setAttribute("productList", pd.getProductList());
		}
		
		forward.setRedirect(false);
		forward.setPath("product/list.jsp");
		
		return forward;
	}

}
