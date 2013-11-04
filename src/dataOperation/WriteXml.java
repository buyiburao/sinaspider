/**
 * 
 */
package dataOperation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import DBMethod.DBUtil;


/**
 * @author lichuanyang 2013-10-21
 * 
 */
public class WriteXml {

   /**
    * @param args
    */
   public static void main(String[] args) {
      // TODO Auto-generated method stub
      
      File file = new File("E:\\数据\\checkin2.xml");
      Connection con=null;
      con=DBUtil.getConnection();
      Statement smt=null;
      String sql="";
      ResultSet rs=null;
      try {
         OutputStream fos=new FileOutputStream(file,false);
         OutputStreamWriter osw=new OutputStreamWriter(fos, "utf-8");
         
         
         smt=con.createStatement();
         sql="select id,text from status where id in (select id from checkin where category=52)";
         rs = smt.executeQuery(sql);
         while (rs.next()) {
            String c="<?xml version=\"1.0\" encoding=\"utf-8\"?><page><id>"+rs.getString(1)+"</id><url /><category>"+
                  "高校</category><title /><metaKeywords /><metaDescription /><content>";
            String sLine=rs.getString(2);
            sLine=sLine.split("我在这里:http://")[0];
            if(sLine.contains("<"))
               sLine.replaceAll("<", "&lt;");
            if(sLine.contains(">"))
               sLine.replaceAll(">", "&gt;");
            if(sLine.contains("&"))
               sLine.replaceAll("&", "&amp;");
            if(sLine.contains("'"))
               sLine.replaceAll("'", "&apos;");
            if(sLine.contains("\""))
               sLine.replaceAll("\"", "&quot;");
            c=c+sLine+"  </content><linkList /></page>\n";
            osw.append(c);
         }
         rs.close();
         smt.close();
         
         
         smt=con.createStatement();
         sql="select id,text from status where id in (select id from checkin where category=119)";
         rs = smt.executeQuery(sql);
         while (rs.next()) {
            String c="<?xml version=\"1.0\" encoding=\"utf-8\"?><page><id>"+rs.getString(1)+"</id><url /><category>"+
                  "商场</category><title /><metaKeywords /><metaDescription /><content>";
            String sLine=rs.getString(2);
            sLine=sLine.split("我在这里:http://")[0];
            System.out.println(sLine);
            c=c+sLine+"  </content><linkList /></page>\n";
            osw.append(c);
         }
         rs.close();
         smt.close();
         
         
         osw.close();
      } catch (IOException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }

   }

}
