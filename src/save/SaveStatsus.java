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

/**
 * @author lichuanyang
 * 2013-10-18
 * 
 */
public class SaveStatsus {

   /**
    * @param args
    */
   public static void main(String[] args) {
      // TODO Auto-generated method stub

   }
   
   public static void save(Status s,Connection con, OutputStreamWriter osw) {

      try {
         String sql = "replace into status(id,url,userId,createdAt,text,source,inReplyToStatusId,inReplyToUserId,inReplyToScreenName,thumbnailPic,middlePic,originalPic,retweetedStatusId,annotations,poiid,geo,latitude,longitude,repostsCount,commentsCount,refreshTime) " +
         		"values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

         WeiboId we = new WeiboId();

         PreparedStatement prepStmt = con.prepareStatement(sql);
         prepStmt.setString(1, s.getId());
         String urs = "";
         try {
            urs = we.mid2url(s.getMid());
         } catch (java.lang.StringIndexOutOfBoundsException e) {
            LogStacktrace.log(e, osw);
         }
         prepStmt.setString(2, "http://e.weibo.com/" + s.getUser().getId() + "/" + urs);
         prepStmt.setString(3, s.getUser().getId());
         prepStmt.setString(4, DateFormat.dateFormat(s.getCreatedAt()));
         if (s.getRetweetedStatus() == null)
            prepStmt.setString(5, s.getText());
         else
            prepStmt.setString(5, s.getText() + s.getRetweetedStatus().getText());

         prepStmt.setString(6, s.getSource().getUrl());
         prepStmt.setLong(7, s.getInReplyToStatusId());
         prepStmt.setLong(8, s.getInReplyToUserId());
         prepStmt.setString(9, s.getInReplyToScreenName());
         prepStmt.setString(10, s.getThumbnailPic());
         prepStmt.setString(11, s.getBmiddlePic());
         prepStmt.setString(12, s.getOriginalPic());
         if (s.getRetweetedStatus() == null)
            prepStmt.setString(13, null);
         else
            prepStmt.setString(13, s.getRetweetedStatus().getId());
         String anno=s.getAnnotations();
         prepStmt.setString(14, anno);
         if (anno.startsWith("[{\"place\":{\"poiid\":")){
            String poiid=anno.substring(anno.indexOf("poiid\":\"")+8,anno.indexOf("\",\"lon"));
            prepStmt.setString(15, poiid);
         }
         else{
            prepStmt.setString(15, null);
         }
         prepStmt.setString(16, s.getGeo());
         prepStmt.setDouble(17, s.getLatitude());
         prepStmt.setDouble(18, s.getLongitude());
         prepStmt.setInt(19, s.getRepostsCount());
         prepStmt.setInt(20, s.getCommentsCount());
         prepStmt.setTimestamp(21, null);
         
         try {

            prepStmt.execute();

         } catch (SQLException e) {
            LogStacktrace.log(e, osw);
         } finally {
            prepStmt.close();
         }

      } catch (SQLException e) {
         LogStacktrace.log(e, osw);
      }
   
   }

}
