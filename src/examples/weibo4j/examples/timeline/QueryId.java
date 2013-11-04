package examples.weibo4j.examples.timeline;

import weibo4j.Timeline;
import examples.weibo4j.examples.oauth2.Log;
import weibo4j.model.WeiboException;
import weibo4j.org.json.JSONObject;

public class QueryId {

	public static void main(String[] args) {
		String access_token = "2.003r2U2Cizi4XE2dbb3663ba0Hfq_f";
		String mid =  "z76cXsG0l";
		Timeline tm = new Timeline();
		tm.client.setToken(access_token);
		try {
			JSONObject id = tm.QueryId( mid, 1,1);
				Log.logInfo(String.valueOf(id));			
		} catch (WeiboException e) {
			e.printStackTrace();
		}

	}

}
