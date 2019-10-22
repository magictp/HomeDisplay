package tp.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import tp.common.PropUtil;

public class DbConnectionFactory {
	
	public static Connection conn;
    public static String driver = PropUtil.getDBProp("Driver");
    public static String url = PropUtil.getDBProp("Url");;
    public static String username = PropUtil.getDBProp("Username");;
    public static String password = PropUtil.getDBProp("Password");;


	public static Connection getDbConnection() throws ClassNotFoundException, SQLException
	{
		 if(conn==null||conn.isClosed()) {
			 Class.forName(driver);
	         conn = DriverManager.getConnection(url, username, password);
	         Statement s = conn.createStatement();
	         s.execute("set Names 'utf8mb4'");
	         s.close();
		 }
		 return DriverManager.getConnection(url, username, password);
	}
}
