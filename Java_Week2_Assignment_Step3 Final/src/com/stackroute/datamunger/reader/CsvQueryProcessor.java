package com.stackroute.datamunger.reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.stackroute.datamunger.query.DataTypeDefinitions;
import com.stackroute.datamunger.query.Header;

public class CsvQueryProcessor extends QueryProcessingEngine {

	private String filename;
	FileReader fileReader;
	BufferedReader bufferedReader;

	// parameterized constructor to initialize filename
	public CsvQueryProcessor(String fileName) throws FileNotFoundException {

		this.filename = fileName;
		fileReader = new FileReader(filename);
		bufferedReader = new BufferedReader(fileReader);

	}

	/*
	 * implementation of getHeader() method. We will have to extract the headers
	 * from the first line of the file. Note: Return type of the method will be
	 * Header
	 */
	@Override
	public Header getHeader() throws IOException {

		Header headers = new Header();
		// read the first line

		fileReader = new FileReader(filename);
		bufferedReader = new BufferedReader(fileReader);
		String[] headersArray = bufferedReader.readLine().split(",");
		headers.setHeaders(headersArray);
		// populate the header object with the String array containing the
		// header names
		return headers;
	}

	/**
	 * getDataRow() method will be used in the upcoming assignments
	 */
	@Override
	public void getDataRow() {

	}

	/*
	 * implementation of getColumnType() method. To find out the data types, we
	 * will read the first line from the file and extract the field values from
	 * it. If a specific field value can be converted to Integer, the data type
	 * of that field will contain "java.lang.Integer", otherwise if it can be
	 * converted to Double, then the data type of that field will contain
	 * "java.lang.Double", otherwise, the field is to be treated as String.
	 * Note: Return Type of the method will be DataTypeDefinitions
	 */
	@Override
	public DataTypeDefinitions getColumnType() throws IOException {

		DataTypeDefinitions datatype = new DataTypeDefinitions();
		// read the first line

		try {
			fileReader = new FileReader(filename);
			bufferedReader = new BufferedReader(fileReader);

			String[] headersArray = bufferedReader.readLine().split(",");
			String[] datatypesArray = bufferedReader.readLine().split(",");

			datatype.setheaderNames(headersArray);
			datatype.setDatatypes(datatypesArray);
			return datatype;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return null;
	}
}
