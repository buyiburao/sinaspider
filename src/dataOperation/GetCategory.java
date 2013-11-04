/**
 * 
 */
package dataOperation;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import DBMethod.DBUtil;

/**
 * @author lichuanyang
 * 2013-10-21
 * 
 */
public class GetCategory {

   /**
    * @param args
    */
   public static void main(String[] args) {
      // TODO Auto-generated method stub
      try {
         HashMap<String, Integer> categorys=new HashMap<String, Integer>();
         Connection con=DBUtil.getConnection();
         Statement smt=con.createStatement();
         String sql="select categorys from checkin";
         ResultSet rs=smt.executeQuery(sql);
         while (rs.next()) {
            String c=rs.getString(1).split(" ")[0];
            if (categorys.get(c)==null){
               categorys.put(c, 1);
            }
            else{
               categorys.put(c, categorys.get(c)+1);
            }
         }
         rs.close();
         smt.close();
         con.close();
         
         System.out.println(categorys);
      } catch (SQLException e) {
         // TODO: handle exception
      }

   }

}
