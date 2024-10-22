package com.lec.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
	public List<ContentDTO> selectList(Connection conn, int firstRow,int endRow) throws SQLException{
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select * from boardtable order by bno desc limit ?, ?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, firstRow);
			pstmt.setInt(2, endRow-firstRow);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				List<ContentDTO> listContent = new ArrayList<>();
				do{
					listContent.add(makeContent(rs));		
				}while(rs.next());
				return listContent;
			}
			else {
				return Collections.emptyList();					
			}
		}finally {
		JDBCUtility.close(null, pstmt, rs);
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

	public int selectCount(Connection conn) throws SQLException {
		Statement stmt=null;
		ResultSet rs=null;
		String sql="select count(*) from boardtable ";
		
		try {
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			rs.next();
			return rs.getInt(1);
		}finally {
			JDBCUtility.close(null,stmt,rs);
		}
	}

	

}
