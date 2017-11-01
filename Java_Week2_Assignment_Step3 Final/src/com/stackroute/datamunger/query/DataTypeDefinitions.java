package com.stackroute.datamunger.query;

import java.util.Arrays;

//this class contains the data type definitions
public class DataTypeDefinitions {

	/*
	 * this class should contain a member variable which is a String array, to
	 * hold the data type for all columns for all data types
	 */

	private String[] headerNames;
	private String[] datatypes;

	public void setDatatypes(String[] datatypes) {
		this.datatypes = datatypes;
	}

	public void setheaderNames(String[] headerNames) {
		this.headerNames = headerNames;
	}

	public String[] getDataTypes() {
		int count = headerNames.length;
		// System.out.println("count"+count);
		// System.out.println("header
		// names"+Arrays.toString(headerNames.split(",")));
		// String[] splitteddata=new String[count];
		String[] datatypesArray = new String[count];

		for (int i = 0; i < count; i++) {
			try {
				datatypesArray[i] = typeOfClass(datatypes[i]);

			} catch (ArrayIndexOutOfBoundsException e) {
				datatypesArray[i] = typeOfClass(" ");
			}

		}
		// System.out.println("datatypesArray length"+datatypesArray.length);
		return datatypesArray;

	}

	/*** To find the object of which class ****/
	public String typeOfClass(String temp) {
		try {
			Integer t = Integer.parseInt(temp);
			return t.getClass().getName();
		} catch (Exception e) {
			String t = temp;
			return t.getClass().getName();

		}
	}
}
