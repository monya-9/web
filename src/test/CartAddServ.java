package test;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test/cartAdd")
public class CartAddServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	int cnt = 0;
	
	//세션에서 장바구니 목록 조회
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		
		request.getRequestDispatcher("goodsList.jsp").forward(request, response);
	
	}
	//장바구니등록
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
//		ArrayList<String> cartList = (String[])request.getSession().getAttribute("cartList")
		String[] cartList = (String[])request.getSession().getAttribute("cartList");
		
		//cartList가 null이면 String[] 초기화하고 session에 추가
		if(cartList == null) {
			cartList = new String[10];	//배열을 만들때 10개까지 만들겠다
			request.getSession().setAttribute("cartList",cartList);
		}
		
		//선택한 상품(parameter)을 cartList에 추가
		cartList[cnt++] = request.getParameter("goods");
		
		//상품목록 페이지로 이동
		response.sendRedirect("cartAdd");
	}

}
