package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import common.ConnectionManager;

public class MemberDAO {
	// 전역변수. 모든 메서드에 공통으로 사용되는 변수
	Connection conn;
	PreparedStatement pstmt;

	//싱글톤(하나 만들어두면 불러와서 계속씀)
	static MemberDAO instance;
	public static MemberDAO getinstance() {
	if(instance==null)
		instance=new MemberDAO();
	return instance;
	}
	
	//전체조회
	public  ArrayList<MemberVo> selectAll(MemberVo memberVo) {
		MemberVo resultVo = null;
		ResultSet rs = null;
		ArrayList<MemberVo> list = new ArrayList<MemberVo>();
		try {
			conn = ConnectionManager.getConnnect();
			String sql = " SELECT ID, PW, GENDER, REASON, MAILYN, JOB, HOBBY"
						+ " FROM MEMBER"
						+ " ORDER BY ID";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				resultVo = new MemberVo();
				resultVo.setId(rs.getString("ID"));
				resultVo.setPw(rs.getString("PW"));
				resultVo.setGender(rs.getString("GENDER"));
				resultVo.setReason(rs.getString("REASON"));
				resultVo.setMailyn(rs.getString("MAILYN"));
				resultVo.setJob(rs.getString("JOB"));
				resultVo.setHobby(rs.getString("JOB"));
				list.add(resultVo);
				System.out.println(rs.getString("ID"));
				System.out.println(rs.getString("PW"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(rs, pstmt, conn);
		}
		return list;
	}
	
	// 단건조회
	public MemberVo selectOne(MemberVo memberVo) {
		MemberVo resultVo = null;
		ResultSet rs = null;
		try {
			conn = ConnectionManager.getConnnect();
			String sql = " SELECT ID, PW, GENDER, REASON, MAILYN, JOB, HOBBY,"
						+ " FROM MEMBER"
						+ " WHERE ID=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberVo.getId());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				resultVo = new MemberVo();
				resultVo.setId(rs.getString("ID"));
				resultVo.setPw(rs.getString("PW"));
				resultVo.setGender(rs.getString("GENDER"));
				resultVo.setReason(rs.getString("REASON"));
				resultVo.setMailyn(rs.getString("MAILYN"));
				resultVo.setReason(rs.getString("HOBBY"));
				resultVo.setHobby(rs.getString("JOB"));
				System.out.println(rs.getInt("ID"));
				System.out.println(rs.getString("PW"));
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

	public void delete(MemberVo memberVo) {
		try {
			conn = ConnectionManager.getConnnect();
			String sql = "delete member where id= ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberVo.getId());
			int r = pstmt.executeUpdate();
			System.out.println(r + "건이 삭제됨.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(null, pstmt, conn);
		}
	}

	public void update(MemberVo memberVo) {
		try {
			conn = ConnectionManager.getConnnect();
			String sql = "update pw = ? where id= ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberVo.getPw());
			pstmt.setString(2, memberVo.getId());
			int r = pstmt.executeUpdate();
			System.out.println(r + "건이 수정됨.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(null, pstmt, conn);
		}
	}

	public void insert(MemberVo memberVo) {
		MemberVo resultVo = null;
		ResultSet rs = null;
	try {

		// 1.DB연결
		conn = ConnectionManager.getConnnect();
		// 2.sql 구문실행
		String sql = "insert into member (id, pw, gender, reason, mailyn, job, hobby, regdate)" + "values(?,?,?,?,?,?,?, sysdate)";
				resultVo = new MemberVo();
				pstmt = conn.prepareStatement(sql);
		resultVo.setId(rs.getString("ID"));
		resultVo.setPw(rs.getString("PW"));
		resultVo.setGender(rs.getString("GENDER"));
		resultVo.setReason(rs.getString("REASON"));
		resultVo.setMailyn(rs.getString("MAILYN"));
		resultVo.setReason(rs.getString("HOBBY"));
		resultVo.setHobby(rs.getString("JOB"));
		System.out.println(rs.getInt("ID"));
		System.out.println(rs.getString("PW"));
		int r = pstmt.executeUpdate();

			// 3.결과처리
			System.out.println(r + " 건이 처리됨.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			// 4.연결해제
			ConnectionManager.close(conn);
		}
	}
	//
	//메일수신회원수 : select count(id) from member where mailyn='y'
	public int getMailynCnt() {
		int cnt = 0;
		try {
			conn = ConnectionManager.getConnnect();
			String sql = "select count(id) from member where mailyn='y'";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			rs.next();
			cnt = rs.getInt(1);
		} catch(Exception e ) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(conn);
		}
		return cnt;
	}
	
	//성별인원수 : select gender, count(id) cnt from member group by gender
	public List<HashMap<String, Object>> getGenderCnt() {
		int cnt = 0;
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		try {
			conn = ConnectionManager.getConnnect();
			String sql = "select gender, count(id) cnt from member group by gender";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery(sql);
			while(rs.next()) {
				HashMap<String, Object> map = new HashMap<String, Object>();
				map.put("gender", rs.getString("gender"));
				map.put("cnt", rs.getInt("cnt"));
			}
			cnt = rs.getInt(1);
		} catch(Exception e ) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(conn);
		}
		return list;
	}

}
