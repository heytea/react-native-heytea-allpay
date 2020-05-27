package com.heytea.allpay.util;

import org.json.JSONException;
import org.json.JSONObject;


public class JsonUtil {
public static String getParam(String jsonString,String key){
	String value="";
	JSONObject jsonObject=null;
	try {
		jsonObject = new JSONObject(jsonString);
	} catch (JSONException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	if(jsonObject!=null){
		value=jsonObject.optString(key);
	}
	return value;
}
}
