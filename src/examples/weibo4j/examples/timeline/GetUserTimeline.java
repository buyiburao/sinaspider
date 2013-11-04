package examples.weibo4j.examples.timeline;

import weibo4j.Timeline;
import examples.weibo4j.examples.oauth2.Log;
import examples.weibo4j.examples.place.Place;
import weibo4j.model.Status;
import weibo4j.model.StatusWapper;
import weibo4j.model.WeiboException;

public class GetUserTimeline {

	public static void main(String[] args) {
		String access_token = "2.00wsVvDDz3qiqCd26fb6d7aeKhjU8B";
		Timeline tm = new Timeline();
//		weibo4j.Place tm=new weibo4j.Place();
		tm.client.setToken(access_token);
		try {
			StatusWapper status = tm.getUserTimelineByUid("2189941330", 1, 100);
			for(Status s : status.getStatuses()){
				System.out.println(s.getId()+s.getAnnotations());
			}
			
		} catch (WeiboException e) {
			e.printStackTrace();
		}
	}

}
