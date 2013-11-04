package weibo4j;
import weibo4j.model.PostParameter;
import weibo4j.model.Status;
import weibo4j.model.StatusWapper;
import weibo4j.model.User;
import weibo4j.model.WeiboException;
import weibo4j.org.json.JSONObject;
import weibo4j.util.WeiboConfig;
public class Location extends Weibo {
	public JSONObject geo_to_address (String coordinate) throws WeiboException {
		return client.get(WeiboConfig.getValue("baseURL") + "location/geo/geo_to_address.json",new PostParameter[] {
			new PostParameter("coordinate", coordinate)
		}).asJSONObject();
	}
}
