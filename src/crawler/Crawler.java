package crawler;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import save.SaveCheckin;
import save.SaveStatsus;
import save.SaveUser;

import weibo4j.Place;
import weibo4j.Timeline;
import weibo4j.model.Status;
import weibo4j.model.StatusWapper;
import weibo4j.model.WeiboException;
import weibo4j.org.json.JSONObject;

import DBMethod.DBUtil;

/**
 * 
 */

/**
 * @author lichuanyang 2013-10-18
 * 
 */
public class Crawler {

   /**
    * @param args
    */
   public static void main(String[] args) {
      // TODO Auto-generated method stub
      run();

   }

   public static void run() {
      Connection con = null;
      Statement smt = null;
      String sql = "";
      String access_token[] = new String[10];
      OutputStreamWriter osw = null;
      int i = 0;
      int x;
      try {
         access_token = GetToken.get("token.txt");
         
         File file = new File("logs.txt");
         System.out.println(file.length());
         if (file.length() > 100000000) {
            file.renameTo(new File("logs" + Integer.toString((int) Math.random() * 1000) + ".txt"));
            file = new File("logs.txt");
            file.createNewFile();
         }
         OutputStream fw = new FileOutputStream(file, true);
         osw = new OutputStreamWriter(fw, "utf-8");

         Timeline tm = new Timeline();
         Place p=new Place();
         Date date=null;
         while (1 != 0) {
            date=new Date();
            osw.write(date+"\n");
            osw.flush();
            con = DBUtil.getConnection();
            x = i % 5;
            tm.client.setToken(access_token[x]);
            i++;
            StatusWapper status = null;
            try {
               status = tm.getPublicTimeline(200);
               for (Status s : status.getStatuses()) {
//                  osw.write(s.getId() + "\n");
//                  osw.flush();
                  SaveStatsus.save(s, con, osw);
                  SaveUser.save(s.getUser(), con, osw);
                  
                  String anno=s.getAnnotations();
                  if (anno.startsWith("[{\"place\":{\"poiid\":")){
                     
                     String poiid=anno.substring(anno.indexOf("poiid\":\"")+8,anno.indexOf("\",\"lon"));
                     x = i % 5;
                     p.client.setToken(access_token[x]);
                     i++;
                     JSONObject js=p.poisShow(poiid);
                     SaveCheckin.save(s.getId(), js, con, osw);
                     
                     date=new Date();
                     osw.write(date+"::::"+s.getId() + "\n");
                     osw.flush();
                     Thread.sleep(720);
                  }
                  
                  
                  if (s.getRetweetedStatus() != null) {
                     SaveStatsus.save(s.getRetweetedStatus(), con, osw);
                     SaveUser.save(s.getRetweetedStatus().getUser(), con, osw);
                  }
                  
               }

            } catch (WeiboException e) {
               // TODO: handle exception
               LogStacktrace.log(e, osw);
            } catch (InterruptedException e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
            } 
            con.close();
//            Thread.sleep(900);
         }

         
         
      } catch (IOException e) {
         LogStacktrace.log(e, osw);
      } catch (SQLException e) {
         LogStacktrace.log(e, osw);
      }

   }

}
