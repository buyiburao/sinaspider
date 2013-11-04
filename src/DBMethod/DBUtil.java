package DBMethod;


import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
/**
 * @description 数据库基本操作
 * @author lichuanyang
 *
 */
public class DBUtil {
	
	public static Connection getConnection() 
	{
		Properties props=loadProperties();
		Connection conn = null;
//		String dbUrl = "jdbc:microsoft:sqlserver://"+props.getProperty("dbUrlIp")+
//			":1433;DatabaseName="+props.getProperty("dbName");
		String dbUrl="jdbc:mysql://"+props.getProperty("dbUrlIp")+
				":3306/"+props.getProperty("dbName");
//		System.out.println(dbUrl);
		String dbUser=props.getProperty("dbUser");
		String dbPwd=props.getProperty("dbPwd");
		try 
		{
			//Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(dbUrl,dbUser,dbPwd);
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return conn;
	}
	
	
	public static void closeConn(Connection conn) {     
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			conn = null;
		}
	}
	
	
	public static void closeStmt(Statement stmt) {         
		if(stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			stmt = null;
		}
	}
	
	
	public static void closeRs(ResultSet rs) {      //�ر�ResultSet
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			rs = null;
		}
	}
	
	
	public static Statement createStmt(Connection conn) {     
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return stmt;
	}
	
	
	public static PreparedStatement createPrepStmt(Connection conn,String sql) {
		PreparedStatement prepStmt = null;
		try {
			prepStmt = conn.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return prepStmt;
	}
	
	
	public static ResultSet executeQuery(Statement stmt, String sql) {
		ResultSet rs = null;
		try {
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	
	public static void executeUpdate(PreparedStatement prepStmt) {
		try {
			prepStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static int executeUpdate(Statement stmt,String sql) {
		int state=0;
		try {
			state=stmt.executeUpdate(sql);
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			state=0;
		}
		return state;
	}

	private static Properties loadProperties() {
		Properties props = new Properties();
		InputStream is = DBUtil.class.getResourceAsStream("DB.properties");
		try {
			props.load(is);
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return props;
	}
}
