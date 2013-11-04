package examples.weibo4j.examples.friendships;

import weibo4j.Friendships;
import examples.weibo4j.examples.oauth2.Log;
import weibo4j.model.User;
import weibo4j.model.UserWapper;
import weibo4j.model.WeiboException;

public class GetFollowers {

	public static void main(String[] args) {
		String access_token = "2.003mlM5Cz3qiqCb9b9f930b50Dulx2";
		Friendships fm = new Friendships();
		fm.client.setToken(access_token);

		try {
			UserWapper users = fm.getFollowersById("2189941330", 200, 0);
			for(User u : users.getUsers()){
				System.out.println(u.getScreenName());
			}
			System.out.println(users.getNextCursor());
			System.out.println(users.getPreviousCursor());
			System.out.println(users.getTotalNumber());
		} catch (WeiboException e) {
			e.printStackTrace();
		}
	}

}
