package com.lec.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

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
		String sql="insert into boardtable(subject,writer,content)"+"value(?,?,?)";
		
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
	

}
