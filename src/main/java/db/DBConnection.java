package db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    public static Connection getInstance(){
        //MySQL 연결정보
        String url = "jdbc:mysql://127.0.0.1:3306/metadb";
        String username = "root";
        String password = "root1234";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("디버그 : DB연결 성공");
            return connection;
        }catch (Exception e){
            e.printStackTrace();
        }

        return null;

    }
}
