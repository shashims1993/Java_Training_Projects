package com.stackroute.datamunger.query;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

//this class will be acting as the DataSet containing multiple rows
public class DataSet extends LinkedHashMap<Long, Row> {

	/*
	 * The sort() method will sort the dataSet based on the key column with the
	 * help of Comparator
	 */
	public DataSet sort(Header header, RowDataTypeDefinitions dataTypes, String columnName) {
		// public DataSet sort(String columnName) {
		// System.out.println(dataTypes.get(header.get(columnName)));
		long rowId = 1;
		List<Row> dataList = new ArrayList<>(this.values());
		// List<Row> dataList = new ArrayList<>();
		Collections.sort(dataList, new GenericComparator(header, dataTypes, columnName));
		DataSet sortedData = new DataSet();
		for (Row rowData : dataList) {
			sortedData.put(rowId, rowData);
			rowId++;
		}
		return sortedData;

		// return null;
	}

}
