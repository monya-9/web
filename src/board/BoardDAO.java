package board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import common.ConnectionManager;

public class BoardDAO {
	// 전역변수. 모든 메서드에 공통으로 사용되는 변수
	Connection conn;
	PreparedStatement pstmt;

	// 전체조회
	public ArrayList<BoardVo> selectAll(BoardVo boardVo) {
		BoardVo resultVo = null;
		ResultSet rs = null;
		ArrayList<BoardVo> list = new ArrayList<BoardVo>();
		try {
			conn = ConnectionManager.getConnnect();
			String sql = " SELECT NO, POSTER, SUBJECT, CONTENTS, LASTPOST, VIEWS, FILENAME" + " FROM BOARD"
					+ " ORDER BY ON";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				resultVo = new BoardVo();
				resultVo.setNo(rs.getInt("NO"));
				resultVo.setPoster(rs.getString("POSTER"));
				resultVo.setSubject(rs.getString("SUBJECT"));
				resultVo.setContents(rs.getString("CONTENTS"));
				resultVo.setLastpost(rs.getString("LASTPOST"));
				resultVo.setViews(rs.getInt("VIEWS"));
				resultVo.setFilename(rs.getString("FILENAME"));
				list.add(resultVo);
				System.out.println(rs.getString("NO"));
				System.out.println(rs.getString("POSTER"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(rs, pstmt, conn);
		}
		return list;
	}

	// 단건조회
	public BoardVo selectOne(BoardVo baordVo) {
		BoardVo resultVo = null;
		ResultSet rs = null;
		try {
			conn = ConnectionManager.getConnnect();
			String sql = " SELECT NO, POSTER, SUBJECT, CONTENTS, LASTPOST, VIEWS, FILENAME" + " FROM BODER"
					+ " WHERE NO=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, baordVo.getNo());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				resultVo = new BoardVo();
				resultVo.setNo(rs.getInt("NO"));
				resultVo.setPoster(rs.getString("POSTER"));
				resultVo.setSubject(rs.getString("SUBJECT"));
				resultVo.setContents(rs.getString("CONTENTS"));
				resultVo.setLastpost(rs.getString("LASTPOST"));
				resultVo.setViews(rs.getInt("VIEWS"));
				resultVo.setFilename(rs.getString("FILENAME"));
				System.out.println(rs.getString("NO"));
				System.out.println(rs.getString("POSTER"));
			} else {
				System.out.println("no data");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(rs, pstmt, conn);
		}
		return resultVo;
	}

	public void delete(BoardVo boardVo) {
		try {
			conn = ConnectionManager.getConnnect();
			String sql = "delete board where no= ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardVo.getNo());
			int r = pstmt.executeUpdate();
			System.out.println(r + "건이 삭제됨.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(null, pstmt, conn);
		}
	}

	public void update(BoardVo boardVo) {
		try {
			conn = ConnectionManager.getConnnect();
			String sql = "update poster = ? where no= ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardVo.getPoster());
			pstmt.setInt(2, boardVo.getNo());
			int r = pstmt.executeUpdate();
			System.out.println(r + "건이 수정됨.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(null, pstmt, conn);
		}
	}

	public void insert(BoardVo boardVo) {
		try {

			// 1.DB연결
			conn = ConnectionManager.getConnnect();
			// 2.sql 구문실행
			//보드 번호 조회, 업데이트
			String seqSql = "select no from seq where tablename = 'board'";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(seqSql);
			rs.next();
			int no = rs.getInt(1);
			//보드 번호 업데이트
			String sql = "insert into departments (no, poster, subject, contents, lastpost, views, filename)"
					+ "values(" + boardVo.getNo() + ", '" + boardVo.getPoster() + ", " + boardVo.getSubject()
					+ " ," + boardVo.getContents() + ", " + boardVo.getLastpost() + ", " + boardVo.getViews() + ", " + boardVo.getFilename() + "')";
			Statement pstmt = conn.createStatement();
			int r = pstmt.executeUpdate(sql);
			conn.commit();

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
