package dept;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeptInsertServ
 */
@WebServlet("/dept/DeptInsertServ")
public class DeptInsertServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeptInsertServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    //get: 부서등록페이지 이동
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//지역정보 조회
		ArrayList<HashMap<String, String>> locationlist = LocationDAO.getInstance().selectAll();
		request.setAttribute("locationlist", locationlist);
		
		//사원(매니저)정보
		List<EmpVO> datas = EmpDAO.getInstance().selectAll();
		request.setAttribute("datas", datas);
		
		request.getRequestDispatcher("deptInsertForm.jsp").forward(request, response);
	}
	
	//post: 부서등록 처리
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("dept 등록 실행.");
		
		//1.파라미터를 Vo에 담기
		DeptVo deptVo = new DeptVo();
		deptVo.setDepartment_id(Integer.parseInt(request.getParameter("department_id")));
		deptVo.setDepartment_name(request.getParameter("department_name"));
		deptVo.setLocation_id(Integer.parseInt(request.getParameter("location_id")));
		deptVo.setManager_id(Integer.parseInt(request.getParameter("manager_id")));
		
		
		//2.등록처리
		DeptDAO dao = new DeptDAO();
		dao.insert(deptVo);

		//3. 결과처리(생략)
		
		//4.전체 조회 서블릿 페이지 이동
		response.sendRedirect("deptSelectAll");
	}

}
