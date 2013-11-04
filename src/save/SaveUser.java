/**
 * 
 */
package save;

import java.io.OutputStreamWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.dom4j.DocumentException;



import weibo4j.model.Status;
import weibo4j.model.User;
import crawler.*;

/**
 * @author lichuanyang
 * 2013-10-18
 * 
 */
public class SaveUser {

   /**
    * @param args
    */
   public static void main(String[] args) {
      // TODO Auto-generated method stub

   }
   public static void save(User user,Connection con, OutputStreamWriter osw) {

      try {
         String sql = "replace into user(id,screenName,name,province,city,location,description,url,profileImageUrl,userDomain,gender,followersCount,friendsCount,statusesCount,favoritesCount,createdAt,verified,verifiedType,verifiedReason,allowAllActMsg,allowAllComment,avatarLarge,biFollowersCount,lang,weihao,refreshTime ) " +
               "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

         WeiboId we = new WeiboId();

         PreparedStatement prepStmt = con.prepareStatement(sql);
         prepStmt.setString(1, user.getId());
         prepStmt.setString(2, user.getScreenName());
         prepStmt.setString(3, user.getName());
         GetProvinceCityName gpc = new GetProvinceCityName("provinces.xml");
         prepStmt.setString(4, gpc.getProvince(user.getProvince()));
         prepStmt.setString(5, gpc.getCity(user.getProvince(), user.getCity()));
         prepStmt.setString(6, user.getLocation());
         prepStmt.setString(7, user.getDescription());
         prepStmt.setString(8, user.getUrl());
         prepStmt.setString(9, user.getProfileImageUrl());
         prepStmt.setString(10, user.getUserDomain());
         prepStmt.setString(11, user.getGender());
         prepStmt.setInt(12, user.getFollowersCount());
         prepStmt.setInt(13, user.getFriendsCount());
         prepStmt.setInt(14, user.getStatusesCount());
         prepStmt.setInt(15, user.getFavouritesCount());
         prepStmt.setString(16, DateFormat.dateFormat(user.getCreatedAt()));
         if (user.isVerified())
            prepStmt.setInt(17, 1);
         else
            prepStmt.setInt(17, 0);
         prepStmt.setInt(18, user.getverifiedType());
         prepStmt.setString(19, user.getVerifiedReason());
         if (user.isallowAllActMsg())
            prepStmt.setInt(20, 1);
         else
            prepStmt.setInt(20, 0);
         
         if (user.isallowAllComment())
            prepStmt.setInt(21, 1);
         else
            prepStmt.setInt(21, 0);
         
         prepStmt.setString(22, user.getavatarLarge());
         prepStmt.setInt(23, user.getbiFollowersCount());
         prepStmt.setString(24, user.getLang());
         prepStmt.setString(25, user.getWeihao());

         prepStmt.setTimestamp(26, null);
         try {

            prepStmt.execute();

         } catch (SQLException e) {
            LogStacktrace.log(e, osw);
         } finally {
            prepStmt.close();
         }

      } catch (SQLException e) {
         LogStacktrace.log(e, osw);
      } catch (DocumentException e1) {
         // TODO Auto-generated catch block
         LogStacktrace.log(e1, osw);
      }
   
   }
}
