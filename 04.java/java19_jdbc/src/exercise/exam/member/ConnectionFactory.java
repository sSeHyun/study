package exercise.exam.member;

import java.io.FileReader;
import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
   String path = ConnectionFactory.class.getResource("jdbc.properties").getPath();
   private String DRV = null;
   private String URL = null;
   private String USR = null;
   private String PWD = null;
   
   private String select = null;
   private String insert = null;
   private String update = null;
   private String delete = null;
   
   public ConnectionFactory() {
      try {
         setup();
      } catch (Exception e) {
         e.printStackTrace();
      }
   }

   // setUp메서드 jdbc.properties에서 DB접속정보와 
   // 실행할 sql문을 프로그램변수로 읽어오기위한 메서드 정의
   public void setup() throws Exception {
      Properties p = new Properties();
      path = URLDecoder.decode(path, "utf-8");
      p.load(new FileReader(path));
      
      // 1. DB접속정보
      DRV = p.getProperty("jdbc.mysql.drv");  // properties 파일에 있는 key 입력
      URL = p.getProperty("jdbc.mysql.url");
      USR = p.getProperty("jdbc.mysql.usr");
      PWD = p.getProperty("jdbc.mysql.pwd");
      
      
      System.out.println(DRV);
      
      
      // 2. SQL정보
      select =  p.getProperty("select");
      insert =  p.getProperty("insert");
      update =  p.getProperty("update");
      delete =  p.getProperty("delete");
      
      
      Class.forName(DRV);
      
   }
   
   public Connection getConnection() {
      try {
         return DriverManager.getConnection(URL,USR,PWD);
      } catch (SQLException e) {
         System.out.println("DB연결 실패");
         e.printStackTrace();
         return null;
      }
   }

   
   // getter 만들기 (select, insert, update, delete 만)
   public String getSelect() {
      return select;
   }

   public String getInsert() {
      return insert;
   }

   public String getUpdate() {
      return update;
   }

   public String getDelete() {
      return delete;
   };
   

}