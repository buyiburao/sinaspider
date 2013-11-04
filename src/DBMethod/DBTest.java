package DBMethod;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBTest {
	public static void main(String[] args) {
		Connection con = null;
		Statement smt;
		DBUtil DBTest=new DBUtil();
		
		try{
			con=DBTest.getConnection();
			smt=con.createStatement();
			int i=0;
			//smt.executeUpdate("insert into test(test,a) values(11,'beston')"); //执行SQL命令
			ResultSet res=smt.executeQuery("select * from user"); //执行SQL命令并获得结果集
			while(res.next())
			{ //处理结果集
			   System.out.println(i+":id:"+res.getString("id")+"\t"+"name:"+res.getString("screenname"));	
			   i++;
			}
			res.close(); //关闭结果集连接的数据并释放JDBC资源
		}catch(Exception ex){
			ex.printStackTrace(); //打印异常信息
		}finally{
			DBTest.closeConn(con);
	}
}
}