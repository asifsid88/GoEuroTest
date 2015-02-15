package com.goeuro.test.models;

import com.goeuro.test.constants.FieldProperty;
import com.goeuro.test.constants.ModelProperty;

public class Location implements GoEuroModels {	
	private static final long serialVersionUID = 1L;
	
	private long id;
	private String name;
	private String type;
	private String latitude;
	private String longitude;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	
	@Override
	public String toString() {
		return "Location {id:" + this.getId()
						+ ", name:"+this.getName()
						+ ", type:"+this.getType()
						+ ", latitude:"+this.getLatitude()
						+ ", longitude:"+this.getLongitude()
						+ "}";
	}
	
	public String getHeader(String delimiter) {
		StringBuilder header = new StringBuilder();
		header.append(ModelProperty.getProperty(FieldProperty.LOCATION_HEADER, "id"))
				.append(delimiter)
				.append(ModelProperty.getProperty(FieldProperty.LOCATION_HEADER, "name"))
				.append(delimiter)
				.append(ModelProperty.getProperty(FieldProperty.LOCATION_HEADER, "type"))
				.append(delimiter)
				.append(ModelProperty.getProperty(FieldProperty.LOCATION_HEADER, "latitude"))
				.append(delimiter)
				.append(ModelProperty.getProperty(FieldProperty.LOCATION_HEADER, "longitude"))
				.append(NEW_LINE_FEED);
		
		return header.toString();
	}
	
	public String getLine(String delimiter) {
		StringBuilder line = new StringBuilder();
		line.append(this.getId())
			.append(delimiter)
			.append(this.getName())
			.append(delimiter)
			.append(this.getType())
			.append(delimiter)
			.append(this.getLatitude())
			.append(delimiter)
			.append(this.getLongitude())
			.append(NEW_LINE_FEED);
		
		return line.toString();
	}
}
