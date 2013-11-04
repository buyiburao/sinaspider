package examples.weibo4j.examples.timeline;

import weibo4j.Timeline;
import examples.weibo4j.examples.oauth2.Log;
import weibo4j.model.WeiboException;
import weibo4j.org.json.JSONException;
import weibo4j.org.json.JSONObject;

public class GetUserTimelineIds {
	public static void main(String[] args) throws JSONException {
		String access_token = "2.00L6IY2Bizi4XE739ab9dbb5TuBFgE";
		Timeline tm = new Timeline();
		tm.client.setToken(access_token);
		try {
			JSONObject ids = tm.getUserTimelineIdsByUid("1642634100");
			System.out.println(ids.get("statuses"));
			Log.logInfo(ids.toString());
		} catch (WeiboException e) {
			e.printStackTrace();
		}
	}
}
