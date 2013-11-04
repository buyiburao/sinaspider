package examples.weibo4j.examples.timeline;

import weibo4j.Timeline;
import examples.weibo4j.examples.oauth2.Log;
import weibo4j.model.Status;
import weibo4j.model.StatusWapper;
import weibo4j.model.WeiboException;

public class GetRepostTimeline {

	public static void main(String[] args) {
		String access_token = "2.005qnCpCJdlDvDda76be2bea0NRxzO";
		String id = "3598465148263613";
		Timeline tm = new Timeline();
		tm.client.setToken(access_token);
		try {
			StatusWapper status = tm.getRepostTimeline(id,100,1);
			for(Status s : status.getStatuses()){
				System.out.println(s.getUser().getId());
				System.out.println(s.getRepostsCount());
//				Log.logInfo(s.toString());
			}
//			System.out.println(status.getNextCursor());
//			System.out.println(status.getPreviousCursor());
//			System.out.println(status.getTotalNumber());
		} catch (WeiboException e) {
			e.printStackTrace();
		}
	}

}
