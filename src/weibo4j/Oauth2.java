/**
 * 
 */
package weibo4j;

import weibo4j.org.json.JSONArray;
import weibo4j.org.json.JSONObject;

import weibo4j.model.PostParameter;
import weibo4j.model.Status;
import weibo4j.model.WeiboException;
import weibo4j.util.WeiboConfig;

/**
 * @author lichuanyang
 * 2013-10-16
 * 
 */
public class Oauth2 extends Weibo{

  
   
   public JSONObject get_token_info(String access_token) throws WeiboException{
      return client.post(
            "https://api.weibo.com/oauth2/get_token_info", new PostParameter[] {
                  new PostParameter("access_token", access_token) }).asJSONObject();
   }
   
   public JSONObject get_token_info() throws WeiboException{
      return client.post(
            "https://api.weibo.com/oauth2/get_token_info").asJSONObject();
   }

}
