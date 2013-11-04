package examples.weibo4j.examples.friendships;

import weibo4j.Friendships;
import weibo4j.model.User;
import weibo4j.model.UserWapper;
import weibo4j.model.WeiboException;

public class GetFriendsByID {

	public static void main(String[] args) {
		String access_token = "2.00E_XvDDz3qiqCad3b7fba8d7c_q3D";

		Friendships fm = new Friendships();
		fm.client.setToken(access_token);
		try {
			UserWapper users = fm.getFollowersById("2189941330", 100, 0);
			for(User u : users.getUsers()){
				System.out.println(u.toString());
			}
			System.out.println(users.getNextCursor());
			System.out.println(users.getPreviousCursor());
			System.out.println(users.getTotalNumber());
		} catch (WeiboException e) {
			e.printStackTrace();
		}

	}

}
