package member;

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

@WebServlet("/member/memberInsert.do")
public class MemberInsertServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    //등록 페이지 이동
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("memberInsert.jsp").forward(request, response);
	}
	//등록 처리
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	request.setCharacterEncoding("UTF-8");
		
	System.out.println("Member 등록 실행.");
	MemberVo memberVo = new MemberVo();
//	memberVo.setId(request.getParameter("id"));
//	memberVo.setPw(request.getParameter("pw"));
//	memberVo.setGender(request.getParameter("gender"));
//	memberVo.setReason(request.getParameter("reason"));
//	memberVo.setMailyn(request.getParameter("mailyn"));
//	memberVo.setJob(request.getParameter("job"));
	
	try {
		BeanUtils.copyProperties(memberVo, request.getParameterMap());
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	System.out.println("==============map===============");
	Map<String, String[]> map = request.getParameterMap();
	System.out.println("id=" + map.get("id")[0]);
	
	System.out.println("==============names===============");
	Enumeration<String> pnames = request.getParameterNames();
	while(pnames.hasMoreElements()) {
		System.out.println(pnames.nextElement());
	}
	
	//checkbox
	System.out.println("==============values===============");
	String strHobby = "";
	String[] hobby = request.getParameterValues("hobby");
	if(hobby != null) {
		for(String temp : hobby) {
			strHobby += temp +"/";
		}
	}
	memberVo.setHobby(strHobby);
	
	MemberDAO dao = new MemberDAO();
	dao.insert(memberVo);
	
	response.sendRedirect("memberSelectAll.do");
	}

}
