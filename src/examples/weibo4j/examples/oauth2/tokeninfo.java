/**
 * 
 */
package examples.weibo4j.examples.oauth2;


import java.text.DateFormat;
import java.util.Date;

import weibo4j.Oauth2;
import weibo4j.model.WeiboException;
import weibo4j.org.json.JSONException;
import weibo4j.org.json.JSONObject;

/**
 * @author lichuanyang
 * 2013-10-16
 * 
 */
public class tokeninfo {

   /**
    * @param args
    */
   public static void main(String[] args) {
      // TODO Auto-generated method stub
//      System.setProperty("java.net.preferIPv4Stack" , "true");
      Oauth2 oauth=new Oauth2();
      oauth.client.setToken("2.003mlM5Cz3qiqCb9b9f930b50Dulx2");
      try {
         JSONObject js=oauth.get_token_info("2.00AneXrCz3qiqCefd981d716HBBzuD");
         System.out.println(js);
//
       Long x=(long)(Long.parseLong(js.getString("create_at"))*1000L-28800000L);
//       System.out.println(x);
//         long x=1000L*3600L*24L*365L*30L;
         System.out.println(x);
         System.out.println(Long.parseLong(js.getString("expire_in"))/3600);
//         System.out.println(x);
         Date date=new Date(x-28800000);
       System.out.println(date);
         
      } 
      catch (WeiboException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      } catch (JSONException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      finally{}
      

   }

}
