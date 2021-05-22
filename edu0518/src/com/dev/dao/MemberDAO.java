package com.dev.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.dev.vo.MemberVO;

public class MemberDAO {
	private static MemberDAO dao = new MemberDAO();
	private MemberDAO() {}
	
	public static MemberDAO getInstance() {
		return dao;
	}
	
	public Connection connect() {
		Connection conn = null;
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "hello1248");
		} catch(Exception e) {
			System.out.print("MDAO: connect " + e);
		}
		return conn;
	}
	
	public void close(Connection conn, PreparedStatement pstmt) {
		if(pstmt != null) {
			try {
				pstmt.close();
			} catch(Exception e) {
				System.out.print("Pstmt close error");
			}
		}
		if(conn != null) {
			try {
				conn.close();
			} catch(Exception e) {
				System.out.print("Conn close error");
			}
		}
	}
	
	public void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		if(rs != null) {
			try {
				rs.close();
			} catch(Exception e) {
				System.out.print("Rs close error");
			}
		}
		close(conn, pstmt);
	}
	
	public void memberInsert(MemberVO member) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = connect();
			pstmt = conn.prepareStatement("insert into member values(?, ?, ?);");
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPwd());
			pstmt.setString(3, member.getName());
			pstmt.executeUpdate();
		} catch(Exception e) {
			System.out.print("MDAO: mInsert error " + e);
		} finally {
			close(conn, pstmt);
		}
		
	}
	
	public MemberVO memberSearch(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberVO member = null;
		
		try {
			conn = connect();
			pstmt = conn.prepareStatement("select * from member where id=?;");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				member = new MemberVO();
				member.setId(rs.getString(1));
				member.setPwd(rs.getString(2));
				member.setName(rs.getString(3));
			}
			
		} catch(Exception e) {
			System.out.print("MDAO: mSearch error " + e);
		} finally {
			close(conn, pstmt, rs);
		}
		return member;
	}

	public void memberUpdate(MemberVO member) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = connect();
			pstmt = conn.prepareStatement("update member set pwd=?, name=? where id=?;");
			pstmt.setString(3, member.getId());
			pstmt.setString(1, member.getPwd());
			pstmt.setString(2, member.getName());
			pstmt.executeUpdate();
		} catch(Exception e) {
			System.out.print("MDAO: mInsert error " + e);
		} finally {
			close(conn, pstmt);
		}
	}
	
	public void memberDelete(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = connect();
			pstmt = conn.prepareStatement("delete from member where id=?;");
			pstmt.setString(1, id);
			pstmt.executeUpdate();
		} catch(Exception e) {
			System.out.print("MDAO: mDelete error " + e);
		} finally {
			close(conn, pstmt);
		}
	}
	
	public ArrayList<MemberVO> memberList() {
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberVO member = null;
		
		try {
			conn = connect();
			pstmt = conn.prepareStatement("select * from member;");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				member = new MemberVO();
				member.setId(rs.getString(1));
				member.setPwd(rs.getString(2));
				member.setName(rs.getString(3));
				list.add(member);
				}
		} catch(Exception e) {
				System.out.print("MDAO: mList error " + e);
		} finally {
			close(conn, pstmt, rs);
		}
		return list;
	}
		
	
}
