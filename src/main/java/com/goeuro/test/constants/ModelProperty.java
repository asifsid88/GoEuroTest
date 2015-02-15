package com.goeuro.test.constants;

import java.lang.reflect.Field;

import com.goeuro.test.utils.GoEuroUtils;

public class ModelProperty {
	public static String getProperty(FieldProperty propClass, String propName) {
		String propValue = "";
		try {
			Class pClass = getPropClass(propClass);
			Field f = pClass.getField(propName);
			propValue = String.valueOf(f.get(null));
		} catch(Exception e) {
			System.out.println(GoEuroUtils.formatExceptionString("Field "+propName+" does not exists in the class "+propClass, e));
		}

		return propValue;
	}
	
	private static Class getPropClass(FieldProperty propClass) {
		Class pClass;
		switch(propClass) {
			case LOCATION:
				pClass = LocationProperty.class;
				break;
			case LOCATION_HEADER:
				pClass = LocationHeader.class;
				break;
			default:
				pClass = Class.class;
		}
		
		return pClass;
	}
}

/**
 * These classes will map to the Attributes of JSON response we get from Service
 * @author Asif
 *
 */
class LocationProperty {
	public static final String id = "_id";
	public static final String name = "name";
	public static final String type = "type";
	public static final String latitude = "latitude";
	public static final String longitude = "longitude";
	public static final String geoPosition = "geo_position";
}

/**
 * These classes will map to the Headers in files
 * @author Asif
 *
 */
class LocationHeader {
	public static final String id = "Id";
	public static final String name = "Name";
	public static final String type = "Type";
	public static final String latitude = "Latitude";
	public static final String longitude = "Longitude";
}
