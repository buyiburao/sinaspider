package examples.weibo4j.examples.timeline;

import weibo4j.Timeline;
import examples.weibo4j.examples.oauth2.Log;
import weibo4j.model.Status;
import weibo4j.model.WeiboException;
import weibo4j.org.json.JSONObject;

public class ShowStatus {

	public static void main(String[] args) {
		String access_token = "2.00cYbvDDz3qiqC246c432c276RpPWB";
		String id = "3634777733626975";
		Timeline tm = new Timeline();
		tm.client.setToken(access_token);
		try {
			Status status = tm.showStatus(id);

			String anno=status.getAnnotations();
			
			if (anno.startsWith("[{\"place\"")){
			   System.out.println(anno);
			   String poiid=anno.substring(anno.indexOf("poiid\":\"")+8,anno.indexOf("\",\"lon"));
			   System.out.println(poiid);
			}
			

		} catch (WeiboException e) {
			e.printStackTrace();
		}
	}

}
