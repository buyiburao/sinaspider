/**
 * 
 */
package examples.weibo4j.examples.place;

import weibo4j.Location;
import weibo4j.model.WeiboException;
import weibo4j.org.json.JSONObject;


/**
 * @author lichuanyang
 * 2013-10-18
 * 
 */
public class geo_to_address {

   /**
    * @param args
    */
   public static void main(String[] args) {
      // TODO Auto-generated method stub
      Location lt = new Location();
      lt.setToken("2.00wsVvDDz3qiqCd26fb6d7aeKhjU8B");    
      String coordinate = ("116.31635,39.97948");
      JSONObject js=null;
      try{
         js = lt.geo_to_address(coordinate);
         System.out.println(js);
      }catch(WeiboException e){
         e.printStackTrace();
      }

   }

}
