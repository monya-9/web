package dept;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import common.ConnectionManager;

public class DeptDAO {
	// 전역변수. 모든 메서드에 공통으로 사용되는 변수
	Connection conn;
	PreparedStatement pstmt;

	//전체조회
	public  ArrayList<DeptVo> selectAll(DeptVo deptVo) {
		DeptVo resultVo = null;
		ResultSet rs = null;
		ArrayList<DeptVo> list = new ArrayList<DeptVo>();
		try {
			conn = ConnectionManager.getConnnect();
			String sql = " SELECT DEPARTMENT_ID, DEPARTMENT_NAME, MANAGER_ID, LOCATION_ID"
						+ " FROM hr.DEPARTMENTS"
						+ " ORDER BY DEPARTMENT_ID";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				resultVo = new DeptVo();
				resultVo.setDepartment_id(rs.getInt(1));
				resultVo.setDepartment_name(rs.getString("department_name"));
				resultVo.setManager_id(rs.getInt("MANAGER_ID"));
				resultVo.setLocation_id(rs.getInt("LOCATION_ID"));
				list.add(resultVo);
				System.out.println(rs.getInt(1));
				System.out.println(rs.getString("department_name"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(rs, pstmt, conn);
		}
		return list;
	}
	
	// 단건조회
	public DeptVo selectOne(DeptVo deptVo) {
		DeptVo resultVo = null;
		ResultSet rs = null;
		try {
			conn = ConnectionManager.getConnnect();
			String sql = " SELECT DEPARTMENT_ID, DEPARTMENT_NAME, MANAGER_ID, LOCATION_ID"
						+ " FROM hr.DEPARTMENTS"
						+ " WHERE DEPARTMENT_ID=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, deptVo.getDepartment_id());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				resultVo = new DeptVo();
				resultVo.setDepartment_id(rs.getInt(1));
				resultVo.setDepartment_name(rs.getString("department_name"));
				resultVo.setManager_id(rs.getInt("MANAGER_ID"));
				resultVo.setLocation_id(rs.getInt("LOCATION_ID"));
				System.out.println(rs.getInt(1));
				System.out.println(rs.getString("department_name"));
			}else {
				System.out.println("no data");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(rs, pstmt, conn);
		}
		return resultVo;
	}

	public void delete(DeptVo deptVo) {
		try {
			conn = ConnectionManager.getConnnect();
			String sql = "delete hr.departments where department_id= ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, deptVo.getDepartment_id());
			int r = pstmt.executeUpdate();
			System.out.println(r + "건이 삭제됨.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(null, pstmt, conn);
		}
	}

	public void update(DeptVo deptVo) {
		try {
			conn = ConnectionManager.getConnnect();
			String sql = "update department_name = ? where department_id= ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, deptVo.getDepartment_name());
			pstmt.setInt(2, deptVo.getDepartment_id());
			int r = pstmt.executeUpdate();
			System.out.println(r + "건이 수정됨.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(null, pstmt, conn);
		}
	}

	public void insert(DeptVo deptVo) {
		try {

			// 1.DB연결
			conn = ConnectionManager.getConnnect();
			// 2.sql 구문실행
			String sql = "insert into hr.departments (department_id, department_name)" + "values("
					+ deptVo.getDepartment_id() + ", '" + deptVo.getDepartment_name() + "')";
			Statement pstmt = conn.createStatement();
			int r = pstmt.executeUpdate(sql);

			// 3.결과처리
			System.out.println(r + " 건이 처리됨.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			// 4.연결해제
			ConnectionManager.close(conn);
		}
	}

}
