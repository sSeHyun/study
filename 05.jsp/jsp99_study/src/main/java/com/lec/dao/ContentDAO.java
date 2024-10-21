package com.lec.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lec.jdbc.JDBCUtility;
import com.lec.model.ContentDTO;

public class ContentDAO {
	private static ContentDAO contentDAO=new ContentDAO();
	private ContentDAO() {}
	
	public static ContentDAO getInstance() {
		return contentDAO;
	}
	public int insert(Connection conn,ContentDTO content) {
		PreparedStatement pstmt=null;
		String sql="insert into boardtable (subject,writer,content) "+" values(?,?,?)";

		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, content.getSubject());
			pstmt.setString(2, content.getWriter());
			pstmt.setString(3, content.getContent());
			return pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
			return 0;
		}finally {
			JDBCUtility.close(null, pstmt, null);
		}
	}

	public ContentDTO makeContent(ResultSet rs) throws SQLException {
		ContentDTO content=new ContentDTO();
		content.setBno(rs.getInt("bno"));
		content.setSubject(rs.getString("subject"));
		content.setWriter(rs.getString("writer"));
		content.setContent(rs.getString("content"));
		
		return content;
	}
	public ContentDTO select(Connection conn, String writer) throws SQLException {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select * from boardtable where writer =?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,writer);
			rs=pstmt.executeQuery();
			
			if(rs.next())return makeContent(rs);
			else return null;
		}finally {
			JDBCUtility.close(null,pstmt,rs);
		}
	
	}

	public static int delete(Connection conn, String writer) throws SQLException {
		PreparedStatement pstmt=null;
		String sql="delete from boardtable where writer=?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, sql);
			return pstmt.executeUpdate();
		}finally {
			JDBCUtility.close(null,pstmt,null);
		}
		
	}

	

}
