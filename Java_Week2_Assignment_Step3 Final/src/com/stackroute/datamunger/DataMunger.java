package com.stackroute.datamunger;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import com.stackroute.datamunger.query.DataTypeDefinitions;
import com.stackroute.datamunger.query.Header;
import com.stackroute.datamunger.reader.CsvQueryProcessor;

public class DataMunger {

	public static void main(String[] args) {

		// read the file name from the user

		/*
		 * create object of CsvQueryProcessor. We are trying to read from a file
		 * inside the constructor of this class. Hence, we will have to handle
		 * exceptions.
		 */
		CsvQueryProcessor csv1 = null;
		try {
			csv1 = new CsvQueryProcessor("/home/ubuntu/workspace/Java/Java Workspace/step3-boilerplate/data/ipl.csv");
			// csv1 = new CsvQueryProcessor("/data/ipl.csv");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		/*
		 * call getHeader() method of CsvQueryProcessor class to retrieve the
		 * array of headers
		 */

		Header h1 = new Header();
		try {
			h1 = csv1.getHeader();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/*
		 * call getColumnType() method of CsvQueryProcessor class to retrieve
		 * the array of column data types which is actually the object of
		 * DataTypeDefinitions class
		 */

		DataTypeDefinitions d1 = new DataTypeDefinitions();
		try {
			d1 = csv1.getColumnType();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/*
		 * display the columnName from the header object along with its data
		 * type from DataTypeDefinitions object
		 */
		String[] headers = h1.getHeaders();
		String[] datatypes = d1.getDataTypes();
		for (int i = 0; i < headers.length; i++) {
			System.out.println(headers[i] + " :" + datatypes[i]);
		}

	}

}
