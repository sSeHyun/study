package com.lec.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public class JDBCUtility {

	public static void close(Connection conn, Statement stmt, ResultSet rs) {
		try {
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			if(conn != null) conn.close();
		} catch (Exception e) {
			// dummy
		}
	}
}
