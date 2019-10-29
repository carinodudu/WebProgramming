package kpu.dudu.persistance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import kpu.dudu.domain.ProductVO;

public class ProductDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	//생성자를 통해 DB 연결
	public ProductDAO() {
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:comp/env");
			DataSource ds = (DataSource) envContext.lookup("jdbc/mysql");
			conn = ds.getConnection();
			
		} catch (Exception e) {
			System.out.println("DB 연결 실패: " + e);
		}
	}
	
	//회원 전체 정보
	public ArrayList<ProductVO> getProductList() {
		String sql = "select * from product";
		ArrayList<ProductVO> productList = new ArrayList<ProductVO>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ProductVO pv = new ProductVO();
				pv.setPno(rs.getInt(1));
				pv.setUserid(rs.getString(2));
				pv.setPname(rs.getString(3));
				pv.setCategory(rs.getString(4));
				pv.setPrice(rs.getInt(5));
				pv.setImage(rs.getString(6));
				pv.setInfo(rs.getString(7));
				
				productList.add(pv);
			}
		} catch (Exception e) {
			System.out.println("getProductList() 에러: " + e);
		} finally {
			if(rs != null) { try { rs.close();} catch (SQLException e) {} }
			if(pstmt != null) { try { pstmt.close(); } catch (SQLException e) {} }
		}
		
		return productList;
	}
	
	//특정 회원 정보
	public ProductVO getProduct(String pno) {
		String sql = "select * from product where pno=?";
		ProductVO pv = new ProductVO();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pno);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				pv.setPno(rs.getInt(1));
				pv.setUserid(rs.getString(2));
				pv.setPname(rs.getString(3));
				pv.setCategory(rs.getString(4));
				pv.setPrice(rs.getInt(5));
				pv.setImage(rs.getString(6));
				pv.setInfo(rs.getString(7));
			} 
			else 
				pv = null;
			
		} catch (Exception e) {
			System.out.println("getProduct() 에러: " + e);
		} finally {
			if(rs != null) { try { rs.close();} catch (SQLException e) {} }
			if(pstmt != null) { try { pstmt.close(); } catch (SQLException e) {} }
		}
		
		return pv;
	}
	
	//회원 가입
	public boolean sellProduct(ProductVO pv) {
		String sql = "insert into product values (?, ?, ?, ?, ?, ? ,?)";
		int updateCnt = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, pv.getPno());
			pstmt.setString(2, pv.getUserid());
			pstmt.setString(3, pv.getPname());
			pstmt.setString(4, pv.getCategory());
			pstmt.setInt(5, pv.getPrice());
			pstmt.setString(6, pv.getImage());
			pstmt.setString(7, pv.getInfo());
			
			updateCnt = pstmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("sellProdcut() 에러: " + e); 
		} finally {
			if(pstmt != null) { try { pstmt.close(); } catch (SQLException e) {} }
		}
		
		if(updateCnt == 0) 
			return false;
		
		return true;
	}
		
}
