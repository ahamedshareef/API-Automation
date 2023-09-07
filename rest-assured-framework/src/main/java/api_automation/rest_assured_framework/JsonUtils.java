package api_automation.rest_assured_framework;

import io.restassured.path.json.JsonPath;

public class JsonUtils {
	
	public  JsonPath rawToJson(String response) {
		JsonPath js = new JsonPath(response);
		return js;
	}
	
	public String getResponseParam(JsonPath ph, String path) {
		return ph.getString(path);
	}
	
	

}
