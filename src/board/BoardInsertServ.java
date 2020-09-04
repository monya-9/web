package board;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

/**
 * Servlet implementation class MemberInsertServ
 */
@WebServlet("/board/boardInsert.do")
public class BoardInsertServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	
	
	//등록 페이지로 이동 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("boardInsert.jsp").forward(request, response);
	}

	//등록 처리
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		
		BoardVo boardVo = new BoardVo();
		//subject, contents, filename
		boardVo.setContents(request.getParameter("contents"));
		boardVo.setSubject(request.getParameter("subject"));
			
//		memberVO.setId(request.getParameter("id"));
//		memberVO.setPw(request.getParameter("pw"));
//		memberVO.setJob(request.getParameter("job"));
//		memberVO.setGender(request.getParameter("gender"));
//		memberVO.setMailyn(request.getParameter("mailyn"));
//		memberVO.setReason(request.getParameter("reason"));
		
//		try {
//			BeanUtils.copyProperties(boardVO, request.getParameterMap());
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
		
//		System.out.println("=======map======");
//		Map<String, String[]> map = request.getParameterMap();
//		System.out.println(map);
//		System.out.println("id= " + map.get("id")[0]);
//		
//		System.out.println("=======names======");
//		Enumeration<String> pnames = request.getParameterNames();
//		while(pnames.hasMoreElements()) {
//			System.out.println(pnames.nextElement());
//		}
//		
		BoardVo dao = new BoardVo();
		dao.insert(boardVo);
		
		request.getRequestDispatcher("BoardSelectAllServ.do").forward(request, response);
	}

}
