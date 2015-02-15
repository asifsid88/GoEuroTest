package com.goeuro.test.helpers;

import java.util.Map;
import java.util.Map.Entry;

public class GoEuroHelper {
	public static String replacePlaceHolder(String str, Map<String, String> params) {
		StringBuilder result = new StringBuilder();
		result.append(str);
		for(Entry<String, String> param : params.entrySet()) {
			String key = "{"+param.getKey()+"}";
			String value = param.getValue();
			int start = result.indexOf(key);
			int end = start + key.length();
			
			result.replace(start, end, value);
		}
		
		return result.toString();
	}
}
