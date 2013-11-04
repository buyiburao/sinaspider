package examples.weibo4j.examples.trends;

import java.util.List;

import weibo4j.Trend;
import examples.weibo4j.examples.oauth2.Log;
import weibo4j.model.UserTrend;
import weibo4j.model.WeiboException;

public class GetTrends {

	public static void main(String[] args) {
		String access_token = "2.00L6IY2Bizi4XE739ab9dbb5TuBFgE";
		String uid = "1642634100";
		Trend tm = new Trend();
		tm.client.setToken(access_token);
		List<UserTrend> trends = null;
		try {
			trends = tm.getTrends(uid);
			for(UserTrend t : trends){
				Log.logInfo(t.toString());
			}
		} catch (WeiboException e) {
			e.printStackTrace();
		}
	}

}
