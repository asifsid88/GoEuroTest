package com.goeuro.test.core;

import com.goeuro.test.constants.FileWriterType;

public class GoEuroFileWriterFactory {
	public static GoEuroFileWriterFactory factory;
	private GoEuroFileWriter fileWriter;
	
	private GoEuroFileWriterFactory() {}
	
	public static GoEuroFileWriterFactory getInstance() {
		if(factory == null) {
			synchronized(GoEuroFileWriterFactory.class) {
				if(factory == null) {
					factory = new GoEuroFileWriterFactory();
				}
			}
		}
		
		return factory;
	}
	
	public GoEuroFileWriter getFileWriter(FileWriterType type) {
		switch(type) {
			case CSVFileWriter:
				fileWriter = new CSVFileWriter();
			default:
				break;
		}
		
		return fileWriter;
	}
}
