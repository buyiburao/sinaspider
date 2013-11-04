/**
 * 
 */
package examples.weibo4j.examples.place;

import java.sql.Connection;

import DBMethod.DBUtil;

import save.SaveCheckin;
import weibo4j.Location;
import weibo4j.Place;
import weibo4j.model.WeiboException;
import weibo4j.org.json.JSONException;
import weibo4j.org.json.JSONObject;

/**
 * @author lichuanyang
 * 2013-10-18
 * 
 */
public class poisshow {

   /**
    * @param args
    */
   public static void main(String[] args) {
      // TODO Auto-generated method stub

      // TODO Auto-generated method stub
      Place p=new Place();
      p.client.setToken("2.00wsVvDDz3qiqCd26fb6d7aeKhjU8B");    
      
      JSONObject js=null;
      try{
         
         js=p.poisShow("B2094654D26DABFD439D");
         
         System.out.println(js);
         Connection con=DBUtil.getConnection();
         SaveCheckin.save("122", js, con, null);
      }catch(WeiboException e){
         e.printStackTrace();
      }

   

   }

}
