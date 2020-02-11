package com.app.util;

import org.codehaus.jackson.map.ObjectMapper;

import com.app.model.CardInfo;

public class JsonUtil {

	//input: CardInfo object
	//output: JSON String
	//task: convert Object -> JSON
	
	public static String convertToJson(CardInfo ci) {
		String json=null;	
		try {
			ObjectMapper om=new ObjectMapper();
			json=om.writeValueAsString(ci);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return json;
	}
}


