package com.goeuro.test.helpers;

import java.util.Map;

import com.goeuro.test.constants.FieldProperty;
import com.goeuro.test.constants.ModelProperty;
import com.goeuro.test.models.Location;

public class MapToModelConverter {
	public static Location getLocation(Map<String, Object> map) {
		if(map == null) {
			return null;
		}
		
		Location location = new Location();
		location.setId((Long) Math.round((Double) map.get(ModelProperty.getProperty(FieldProperty.LOCATION, "id"))));
		location.setName(String.valueOf(map.get(ModelProperty.getProperty(FieldProperty.LOCATION, "name"))));
		location.setType(String.valueOf(map.get(ModelProperty.getProperty(FieldProperty.LOCATION, "type"))));
		
		Map<String, Object> geoPosition = (Map<String, Object>) map.get(ModelProperty.getProperty(FieldProperty.LOCATION, "geoPosition"));
		location.setLatitude(String.valueOf(geoPosition.get(ModelProperty.getProperty(FieldProperty.LOCATION, "latitude"))));
		location.setLongitude(String.valueOf(geoPosition.get(ModelProperty.getProperty(FieldProperty.LOCATION, "longitude"))));
		
		return location;
	}
}
