/**
 * 
 */
package save;

import java.io.OutputStreamWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import crawler.*;

import weibo4j.model.Status;
import weibo4j.org.json.JSONException;
import weibo4j.org.json.JSONObject;

/**
 * @author lichuanyang
 * 2013-10-18
 * 
 */
public class SaveCheckin {

   /**
    * @param args
    */
   public static void main(String[] args) {
      // TODO Auto-generated method stub

   }
   
   public static void save(String statusid,JSONObject js,Connection con, OutputStreamWriter osw) {

      try {
         String sql = "replace into checkin(id,poiid,title,address,longitude,latitude,category,categorys,categoryname,city,province,streetsummary,url,phone,postcode,weiboid,icon,checkinnum,checkusernum,tipnum,photonum,todonum,refreshTime ) " +
         		"values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
         PreparedStatement prepStmt = con.prepareStatement(sql);
         
         try {
            prepStmt.setString(1, statusid);
            prepStmt.setString(2, js.getString("poiid"));
            prepStmt.setString(3, js.getString("title"));
            prepStmt.setString(4, js.getString("poi_street_address"));
            prepStmt.setString(5, js.getString("lon"));
            prepStmt.setString(6, js.getString("lat"));
            prepStmt.setString(7, js.getString("category"));
            prepStmt.setString(8, js.getString("categorys"));
            prepStmt.setString(9, js.getString("category_name"));
            prepStmt.setString(10, js.getString("city"));
            prepStmt.setString(11, js.getString("province"));
            prepStmt.setString(12, js.getString("poi_street_summary"));
            prepStmt.setString(13, js.getString("url"));
            prepStmt.setString(14, js.getString("phone"));
            prepStmt.setString(15, js.getString("postcode"));
            prepStmt.setString(16, js.getString("weibo_id"));
            prepStmt.setString(17, js.getString("icon"));
            if (!(js.getString("checkin_num").equals(""))){
            prepStmt.setInt(18, Integer.valueOf(js.getString("checkin_num")));
            }
            if (!(js.getString("checkin_user_num").equals(""))){
            prepStmt.setInt(19, Integer.valueOf(js.getString("checkin_user_num")));
            }
            if (!(js.getString("tip_num").equals(""))){
            prepStmt.setInt(20, Integer.valueOf(js.getString("tip_num")));
            }
            if (!(js.getString("photo_num").equals(""))){
            prepStmt.setInt(21, Integer.valueOf(js.getString("photo_num")));
            }
            if (!(js.getString("todo_num").equals(""))){
            prepStmt.setInt(22, Integer.valueOf(js.getString("todo_num")));
            }
            
            prepStmt.setTimestamp(23, null);
            

            prepStmt.execute();

         } catch (SQLException e) {
            LogStacktrace.log(e, osw);
         } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         } finally {
            prepStmt.close();
         }

      } catch (SQLException e) {
         LogStacktrace.log(e, osw);
      }
   
   }

}
