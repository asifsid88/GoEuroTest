package com.goeuro.test.core;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.goeuro.test.models.GoEuroModels;
import com.goeuro.test.utils.GoEuroUtils;

class CSVFileWriter implements GoEuroFileWriter {

	private static final String FILE_NAME = "location";
	private static final String EXTENSION = ".csv";
	private static final String DELIMITER = ",";

	public void write(List<GoEuroModels> models) {
		FileWriter fileWriter = null;
		try {
			System.out.println("Starting writing to a file "+FILE_NAME+EXTENSION+" . . .");
			fileWriter = new FileWriter(FILE_NAME+EXTENSION);
			if(models.size() == 0) {
				// empty
				System.out.println("File generated is empty. Currently not showing header as well.");
			} else {
				int i=0;
				for(GoEuroModels m : models) {
					if(i==0) {
						fileWriter.append(m.getHeader(DELIMITER));
						i++;
					}
					fileWriter.append(m.getLine(DELIMITER));
				}
			}
			System.out.println("Writing to the file completed !!");
		} catch (Exception e) {
			System.out.println(GoEuroUtils.formatExceptionString("Exception while writing to file", e));
		} finally {
			try {
				fileWriter.flush();
				fileWriter.close();
			} catch (IOException e) {
				System.out.println("Error while flush or close of FileWriter");
			}

		}
	}
}