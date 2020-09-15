package board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class BoardInsertAjaxServ
 */
@WebServlet("/BoardInsertAjaxServ")
public class BoardInsertAjaxServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardInsertAjaxServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardVo boardVo = new BoardVo();
		boardVo.setNo(request.getParameter("no"));
		boardVo.setPoster(request.getParameter("poster"));
		boardVo.setSubject(request.getParameter("subject"));
		
		BoardDAO.getinstance().insert(boardVo);
		
		BoardVo resultVo = BoardDAO.getinstance().selectOne(boardVo);
		String result = JSONObject.fromObject(resultVo).toString();
		response.getWriter().print(result);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
