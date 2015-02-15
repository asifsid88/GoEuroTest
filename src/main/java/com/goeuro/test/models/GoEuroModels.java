package com.goeuro.test.models;

import java.io.Serializable;

public interface GoEuroModels extends Serializable {
	String NEW_LINE_FEED = "\n";
	
	String getHeader(String delimiter);
	String getLine(String delimiter);
}
