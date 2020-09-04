package dept;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmpInsertServ
 */
@WebServlet("/dept/EmpInsertServ")
public class EmpInsertServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpInsertServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    //등록페이지 이동
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	List<JobVO> jobdatas = JobDAO.getInstance().selectAll();
	request.setAttribute("jobdatas", jobdatas);
	
	List<EmpVO> manadatas = EmpDAO.getInstance().selectAll();
	request.setAttribute("manadatas", manadatas);
	
	DeptDAO dao = new DeptDAO();
	ArrayList<DeptVo> deptdatas = dao.selectAll(null);
	request.setAttribute("deptdatas", deptdatas);
	
	request.getRequestDispatcher("employeeInsert.jsp").forward(request, response);
	}

	//등록 처리
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("사원등록 실행.");
		
		EmpVO empVO = new EmpVO();
		empVO.setManager_id(request.getParameter("manager_id"));
		
		EmpDAO dao = new EmpDAO();
		
		
	}

}
