package kpu.dudu.persistance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import kpu.dudu.domain.MemberVO;

public class MemberDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public static final int NO_MEMBER = -1; //계정 없음
	public static final int NO_PASSWD = 0; //패스워드 불일치
	public static final int YES = 1; //일치
	
	//생성자를 통해 DB 연결
	public MemberDAO() {
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:comp/env");
			DataSource ds = (DataSource) envContext.lookup("jdbc/mysql");
			conn = ds.getConnection();
			
		} catch (Exception e) {
			System.out.println("DB 연결 실패: " + e);
		}
	}
	
	//로그인 결과
	public int isMember(MemberVO mv) {
		String sql = "select passwd from member where userid=?";
		int result = NO_MEMBER;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mv.getUserid());
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				if(rs.getString("passwd").equals(mv.getPasswd())) { result = YES; }
				else { result = NO_PASSWD; }
			} 
			else
				result = NO_MEMBER;
		} catch (Exception e) {
			System.out.println("isMember() 에러: " + e);
		} finally {
			if(rs != null) { try { rs.close();} catch (SQLException e) {} }
			if(pstmt != null) { try { pstmt.close(); } catch (SQLException e) {} }
		}
		
		return result;
	}
	
	//회원 가입
	public boolean joinMember(MemberVO mv) {
		String sql = "insert into member values (?, ?, ?, ?, ?, ? ,?)";
		int updateCnt = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, mv.getUserid());
			pstmt.setString(2, mv.getPasswd());
			pstmt.setString(3, mv.getUsername());
			pstmt.setString(4, mv.getTel());
			pstmt.setString(5, mv.getEmail());
			pstmt.setString(6, mv.getSex());
			pstmt.setInt(7, mv.getPoint());
			
			updateCnt = pstmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("joinMember() 에러: " + e); 
		} finally {
			if(pstmt != null) { try { pstmt.close(); } catch (SQLException e) {} }
		}
		
		if(updateCnt == 0) 
			return false;
		
		return true;
	}
	
	//회원 전체 정보
	public ArrayList<MemberVO> getMemberList() {
		String sql = "select * from member";
		ArrayList<MemberVO> memberList = new ArrayList<MemberVO>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MemberVO mv = new MemberVO();
				mv.setUserid(rs.getString(1));
				mv.setPasswd(rs.getString(2));
				mv.setUsername(rs.getString(3));
				mv.setTel(rs.getString(4));
				mv.setEmail(rs.getString(5));
				mv.setSex(rs.getString(6));
				mv.setPoint(rs.getInt(7));
				
				memberList.add(mv);
			}
		} catch (Exception e) {
			System.out.println("getMemberList() 에러: " + e);
		} finally {
			if(rs != null) { try { rs.close();} catch (SQLException e) {} }
			if(pstmt != null) { try { pstmt.close(); } catch (SQLException e) {} }
		}
		
		return memberList;
	}
	
	//특정 회원 정보
	public MemberVO getMember(String id) {
		String sql = "select * from member where userid=?";
		MemberVO mv = new MemberVO();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				mv.setUserid(rs.getString(1));
				mv.setPasswd(rs.getString(2));
				mv.setUsername(rs.getString(3));
				mv.setTel(rs.getString(4));
				mv.setEmail(rs.getString(5));
				mv.setSex(rs.getString(6));
				mv.setPoint(rs.getInt(7));
			} 
			else 
				mv = null;
			
		} catch (Exception e) {
			System.out.println("getMember() 에러: " + e);
		} finally {
			if(rs != null) { try { rs.close();} catch (SQLException e) {} }
			if(pstmt != null) { try { pstmt.close(); } catch (SQLException e) {} }
		}
		
		return mv;
	}
	
	//회원 삭제
	public boolean deleteMember(String id) {
		String sql = "delete from member where userid=?";
		int deleteCnt = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			deleteCnt = pstmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("deleteMember() 에러: " + e);
		} finally {
			if(pstmt != null) { try { pstmt.close(); } catch (SQLException e) {} }
		}
		
		if(deleteCnt == 0) 
			return false;
		
		return true;
	}
	
	public boolean increasePoint(String id, int point) {
		String sql = "update member set point=point+? where userid=?";
		int updateCnt = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, point);
			pstmt.setString(2, id);
			
			updateCnt = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("increasePoint() 에러: " + e);
		} finally {
			if(pstmt != null) { try { pstmt.close(); } catch (SQLException e) {} }
		}
		
		if(updateCnt == 0)
			return false;
		
		return true;
	}
	
	public boolean decreasePoint(String id, int price) {
		String sql = "update member set point=point-? where userid=?";
		int updateCnt = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, price);
			pstmt.setString(2, id);
			
			updateCnt = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("decreasePoint() 에러: " + e);
		} finally {
			if(pstmt != null) { try { pstmt.close(); } catch (SQLException e) {} }
		}
		
		if(updateCnt == 0)
			return false;
		
		return true;
	}
	
}
