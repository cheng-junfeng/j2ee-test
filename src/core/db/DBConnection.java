package core.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static Connection conn = null;

    
    private DBConnection() {

    }


    public static Connection getConnInstance() {
        if(null == conn){
            synchronized (DBConnection.class){
                if(null == conn){
                    try {
						conn = getConnection();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                }
            }
        }
        return DBConnection.conn;
    }

    public static Connection getConnection() throws SQLException, java.lang.ClassNotFoundException 
	{
		Class.forName("com.mysql.jdbc.Driver");
		
		//取得连接的url, 能访问MySQL数据库的用户名,密码, 数据库名
		String url = "jdbc:mysql://localhost:3306/mysql";        
		String username = "root";
		String password = "123456";
		
		Connection con = DriverManager.getConnection(url, username, password);        
		return con;        
	}

    public static void closeConnection() {
        if (null != conn) {
            try {
                conn.close();
                conn = null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
