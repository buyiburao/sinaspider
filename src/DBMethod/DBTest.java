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
			//smt.executeUpdate("insert into test(test,a) values(11,'beston')"); //ִ��SQL����
			ResultSet res=smt.executeQuery("select * from user"); //ִ��SQL�����ý����
			while(res.next())
			{ //��������
			   System.out.println(i+":id:"+res.getString("id")+"\t"+"name:"+res.getString("screenname"));	
			   i++;
			}
			res.close(); //�رս�������ӵ����ݲ��ͷ�JDBC��Դ
		}catch(Exception ex){
			ex.printStackTrace(); //��ӡ�쳣��Ϣ
		}finally{
			DBTest.closeConn(con);
	}
}
}