package ex03_connector;

import java.io.FileReader;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class JDBCConnector {

	public static Connection getConnection() throws Exception {
		
		String path = JDBCConnector.class.getResource("jdbc.properties").getPath();
		
		Properties p = new Properties();
		path = URLDecoder.decode(path, "utf-8");
		p.load(new FileReader(path));
		
		String DRV = p.getProperty("drv");
		String URL = p.getProperty("url");
		String USR = p.getProperty("usr");
		String PWD = p.getProperty("pwd");
				
		try {
			Class.forName(DRV);
			return DriverManager.getConnection(URL, USR, PWD);
		} catch (Exception e) {
			return null;
		}		
	}
	
	public static void close(Connection conn, Statement stmt, ResultSet rs) {
		try {
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			if(conn != null) conn.close();				
		} catch (Exception e2) {
			// dummy
		}		
	}
}
