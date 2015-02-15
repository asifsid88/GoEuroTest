package com.goeuro.test.core;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.goeuro.test.constants.PlaceHolder;
import com.goeuro.test.constants.RESTApi;
import com.goeuro.test.helpers.GoEuroHelper;
import com.goeuro.test.helpers.MapToModelConverter;
import com.goeuro.test.models.Location;
import com.goeuro.test.utils.GoEuroUtils;
import com.goeuro.test.utils.JSONUtils;
import com.goeuro.test.utils.StringUtils;

public class GoEuroApi {
	public static List<Location> getLocationByCity(String cityName) {
		if(StringUtils.isNullOrEmpty(cityName)) {
			throw new NullPointerException("City Name cannot be empty");
		}

		List<Location> locationList = null;
		try {
			System.out.println("Entering GoEuropaApi.getLocationByCity("+cityName+")");
			Map<String, String> params = new HashMap<String, String>();
			params.put(PlaceHolder.POSITION_SUGGEST_CITYNAME, cityName);
			
			String restUrl = GoEuroHelper.replacePlaceHolder(RESTApi.POSITION_SUGGEST_CITYNAME, params);
			System.out.println("URI : "+restUrl);
			String jsonResponse = GoEuroClient.getInstance().doGet(restUrl);	
			System.out.println("Response: "+jsonResponse);
			
			List<Map<String, Object>> resultList = JSONUtils.fromJSONToArray(jsonResponse);
			locationList = new LinkedList<Location>();
			for(Map<String, Object> result : resultList) {
				Location location = MapToModelConverter.getLocation(result);
				locationList.add(location);
			}
			
			System.out.println("Exiting GoEuropaApi.getLocationByCity("+cityName+")");
		} catch(Exception e) {
			System.out.println(GoEuroUtils.formatExceptionString("Exception in GoEuroApi.getLocationByCity("+cityName+")", e));
		}
		
		return locationList;
	}
}
