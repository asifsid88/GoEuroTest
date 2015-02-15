package com.goeuro.test.main;

import java.util.List;

import com.goeuro.test.constants.FileWriterType;
import com.goeuro.test.core.GoEuroApi;
import com.goeuro.test.core.GoEuroFileWriter;
import com.goeuro.test.core.GoEuroFileWriterFactory;
import com.goeuro.test.models.GoEuroModels;

/**
 * System.out.println() used in the code-base to track the execution of Application
 * In real world, this statement will be replaced with Logger (to log the activity)
 * @author Asif
 *
 */

public class Main {
	public static void main(String[] args) {
		System.out.println("Application Started !");
		if(args.length > 0) {
			List<GoEuroModels> list = (List) GoEuroApi.getLocationByCity(args[0]);
			GoEuroFileWriter fileWriter = GoEuroFileWriterFactory.getInstance().getFileWriter(FileWriterType.CSVFileWriter);
			fileWriter.write(list);	
		} else {
			System.out.println("Please enter City Name as Command Line Argument !");
		}
		System.out.println("Application Terminated !!");
	}
}
