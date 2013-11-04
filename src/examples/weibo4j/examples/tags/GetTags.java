package examples.weibo4j.examples.tags;

import java.util.List;

import weibo4j.Tags;
import examples.weibo4j.examples.oauth2.Log;
import weibo4j.model.Tag;
import weibo4j.model.WeiboException;

public class GetTags {

	public static void main(String[] args) {
		String access_token ="2.003mlM5Cz3qiqCb9b9f930b50Dulx2";
		Tags tm = new Tags();
		tm.client.setToken(access_token);
		List<Tag> tags = null;
		String uid ="2860492000";
		try {
			tags = tm.getTags(uid);
//			System.out.println(tags);
			for(Tag tag:tags ){				
				System.out.println(tag.toString());
			}
		} catch (WeiboException e) {
			e.printStackTrace();
		}
	}

}
