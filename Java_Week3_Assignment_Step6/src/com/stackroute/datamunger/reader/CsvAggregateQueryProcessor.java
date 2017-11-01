package com.stackroute.datamunger.reader;

import java.io.BufferedReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.stackroute.datamunger.query.DataSet;
import com.stackroute.datamunger.query.DataTypeDefinitions;
import com.stackroute.datamunger.query.Filter;
import com.stackroute.datamunger.query.GroupedDataSet;
import com.stackroute.datamunger.query.Header;
import com.stackroute.datamunger.query.Row;
import com.stackroute.datamunger.query.RowDataTypeDefinitions;
import com.stackroute.datamunger.query.parser.AggregateFunction;
import com.stackroute.datamunger.query.parser.QueryParameter;
import com.stackroute.datamunger.query.parser.Restriction;

/*
 * this is the CsvAggregateQueryProcessor class used for evaluating queries
 * with aggregate functions without group by clause
 */
public class CsvAggregateQueryProcessor implements QueryProcessingEngine {

	/*
	 * This method will take QueryParameter object as a parameter which contains
	 * the parsed query and will process and populate the ResultSet
	 */
	public HashMap getResultSet(QueryParameter queryParameter) {

		/*
		 * initialize BufferedReader to read from the file which is mentioned in
		 * QueryParameter. Consider Handling Exception related to file reading.
		 */
		FileReader fileReader = null;
		try {
			fileReader = new FileReader(queryParameter.getFile());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BufferedReader bufferedReader = new BufferedReader(fileReader);

		/*
		 * read the first line which contains the header. Please note that the
		 * headers can contain spaces in between them. For eg: city, winner
		 */
		String[] headersArray = null;
		try {
			headersArray = bufferedReader.readLine().split(",");
			// //System.out.println(Arrays.toString(headersArray));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/*
		 * read the next line which contains the first row of data. We are
		 * reading this line so that we can determine the data types of all the
		 * fields. Please note that ipl.csv file contains null value in the last
		 * column. If you do not consider this while splitting, this might cause
		 * exceptions later
		 */
		String[] firstLineArray = new String[headersArray.length];
		String[] tempArray = null;
		try {
			tempArray = bufferedReader.readLine().split(",");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 0; i < headersArray.length; i++) {
			try {
				firstLineArray[i] = tempArray[i];
			} catch (ArrayIndexOutOfBoundsException ex) {
				firstLineArray[i] = "";
			}
		}

		/*
		 * populate the header Map object from the header array. header map is
		 * having data type <String,Integer> to contain the header and it's
		 * index.
		 */
		Header header = new Header();
		for (int i = 0; i < headersArray.length; i++) {
			header.put(headersArray[i].trim(), i);
		}
		// System.out.println(header);

		/*
		 * We have read the first line of text already and kept it in an array.
		 * Now, we can populate the RowDataTypeDefinition Map object.
		 * RowDataTypeDefinition map is having data type <Integer,String> to
		 * contain the index of the field and it's data type. To find the
		 * dataType by the field value, we will use getDataType() method of
		 * DataTypeDefinitions class
		 */
		DataTypeDefinitions dataTypeDefinitions = new DataTypeDefinitions();
		String[] dataTypeDefinitionsArray = new String[firstLineArray.length];
		dataTypeDefinitions.setheaderNames(headersArray);
		dataTypeDefinitions.setDatatypes(firstLineArray);
		dataTypeDefinitionsArray = dataTypeDefinitions.getDataTypes();
		// //System.out.println(Arrays.toString(dataTypeDefinitionsArray));
		RowDataTypeDefinitions rowDataTypeDefinitions = new RowDataTypeDefinitions();
		for (int i = 0; i < dataTypeDefinitionsArray.length; i++) {
			rowDataTypeDefinitions.put(i, dataTypeDefinitionsArray[i].trim());
		}
		// System.out.println(rowDataTypeDefinitions);

		/*
		 * once we have the header and dataTypeDefinitions maps populated, we
		 * can start reading from the first line. We will read one line at a
		 * time, then check whether the field values satisfy the conditions
		 * mentioned in the query,if yes, then we will add it to the resultSet.
		 * Otherwise, we will continue to read the next line. We will continue
		 * this till we have read till the last line of the CSV file.
		 */

		/*
		 * reset the buffered reader so that it can start reading from the first
		 * line
		 */

		/*
		 * skip the first line as it is already read earlier which contained the
		 * header
		 */

		/*
		 * read one line at a time from the CSV file till we have any lines left
		 */

		fileReader = null;
		bufferedReader = null;
		try {
			fileReader = new FileReader(queryParameter.getFile());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bufferedReader = new BufferedReader(fileReader);
		String line = null;
		DataSet dataset = new DataSet();
		long rowIndex = 1;
		Row row = null;
		List fields = queryParameter.getFields();
		List<Restriction> restriction = queryParameter.getRestrictions();
		List<String> logicalOperators = queryParameter.getLogicalOperators();
		String queryString = queryParameter.getQueryString();
		Boolean isWherePresent = false;
		for (String field : queryString.split("\\s")) {
			if (field.equals("where")) {
				isWherePresent = true;
				break;
			}
		}

		try {
			bufferedReader.readLine();
			while ((line = bufferedReader.readLine()) != null) {
				{
					String[] currentLinedata = line.split(",");
					row = new Row();
					if (fields.get(0).equals("*") && !isWherePresent) {
						for (int i = 0; i < headersArray.length; i++) {
							try {
								row.put(headersArray[i], currentLinedata[i].trim());
							} catch (ArrayIndexOutOfBoundsException ex) {
								row.put(headersArray[i], "");
							}
						}
						dataset.put(rowIndex, row);
						rowIndex++;
					} else if (!isWherePresent) {

						for (int i = 0; i < headersArray.length; i++) {
							try {
								row.put(headersArray[i], currentLinedata[i].trim());
							} catch (ArrayIndexOutOfBoundsException ex) {
								row.put(headersArray[i], "");
							}
						}
						dataset.put(rowIndex, row);
						rowIndex++;
					} else {
						Filter filter = new Filter();
						Boolean rowAddFlag = filter.evaluateExpression(header, rowDataTypeDefinitions, currentLinedata,
								restriction, logicalOperators);
						if (rowAddFlag) {
							for (int i = 0; i < headersArray.length; i++) {
								try {
									row.put(headersArray[i], currentLinedata[i].trim());
								} catch (ArrayIndexOutOfBoundsException ex) {
									row.put(headersArray[i], "");
								}
							}
							dataset.put(rowIndex, row);
							rowIndex++;
						}
					}

				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// //System.out.println(dataset);
		/*
		 * for (Map.Entry m2 : dataset.entrySet()) {
		 * //System.out.println(m2.getKey() + " " + m2.getValue()); }
		 */
		// long i = 1;
		// System.out.println(dataset.get(i));
		/*
		 * once we have read one line, we will split it into a String Array.
		 * This array will continue all the fields of the row. Please note that
		 * fields might contain spaces in between. Also, few fields might be
		 * empty.
		 */

		/*
		 * if there are where condition(s) in the query, test the row fields
		 * against those conditions to check whether the selected row satifies
		 * the conditions
		 */

		/*
		 * from QueryParameter object, read one condition at a time and evaluate
		 * the same. For evaluating the conditions, we will use
		 * evaluateExpressions() method of Filter class. Please note that
		 * evaluation of expression will be done differently based on the data
		 * type of the field. In case the query is having multiple conditions,
		 * you need to evaluate the overall expression i.e. if we have OR
		 * operator between two conditions, then the row will be selected if any
		 * of the condition is satisfied. However, in case of AND operator, the
		 * row will be selected only if both of them are satisfied.
		 */

		/*
		 * check for multiple conditions in where clause for eg: where
		 * salary>20000 and city=Bangalore for eg: where salary>20000 or
		 * city=Bangalore and dept!=Sales
		 */

		/*
		 * if the overall condition expression evaluates to true, then we need
		 * to check for the existence for aggregate functions in the Query
		 * Parameter. Please note that there can be more than one aggregate
		 * functions existing in a query. The dataSet generated after processing
		 * any aggregate function is completely different from a dataSet
		 * structure(which contains multiple rows of data). In case of queries
		 * containing aggregate functions, each row of the resultSet will
		 * contain the key(for e.g. 'count(city)') and it's aggregate value.
		 * Hence, we will use GroupedDataSet<String,Object> to store the same
		 * and not DataSet<Long,Row>. we will process all the five aggregate
		 * functions i.e. min, max, avg, sum, count.
		 */

		/* return dataset object */
		List<AggregateFunction> aggregateFunc = queryParameter.getAggregateFunctions();
		GroupedDataSet groupDataSet = new GroupedDataSet();
		for (int i = 0; i < aggregateFunc.size(); i++) {
			if (aggregateFunc.get(i).getFunction().equals("count")) {
				int result = getCount(dataset, aggregateFunc.get(i).getField());
				String key = aggregateFunc.get(i).getFunction() + "(" + aggregateFunc.get(i).getField() + ")";
				groupDataSet.put(key, result);
			}
			if (aggregateFunc.get(i).getFunction().equals("sum")) {
				float result = getSum(dataset, aggregateFunc.get(i).getField());
				String key = aggregateFunc.get(i).getFunction() + "(" + aggregateFunc.get(i).getField() + ")";
				groupDataSet.put(key, result);
			}
			if (aggregateFunc.get(i).getFunction().equals("avg")) {
				float result = getAverage(dataset, aggregateFunc.get(i).getField());
				String key = aggregateFunc.get(i).getFunction() + "(" + aggregateFunc.get(i).getField() + ")";
				groupDataSet.put(key, result);
			}
			if (aggregateFunc.get(i).getFunction().equals("min")) {
				int result = getMin(dataset, aggregateFunc.get(i).getField());
				String key = aggregateFunc.get(i).getFunction() + "(" + aggregateFunc.get(i).getField() + ")";
				groupDataSet.put(key, result);
			}
			if (aggregateFunc.get(i).getFunction().equals("max")) {
				int result = getMax(dataset, aggregateFunc.get(i).getField());
				String key = aggregateFunc.get(i).getFunction() + "(" + aggregateFunc.get(i).getField() + ")";
				groupDataSet.put(key, result);
			}
		}
		return groupDataSet;
	}

	int getMax(DataSet dataset, String fieldName) {
		int count = 0;
		ArrayList<Integer> list = new ArrayList<>();
		for (Entry<Long, Row> m2 : dataset.entrySet()) {

			if (!m2.getValue().get(fieldName).equals("")) {
				list.add(Integer.parseInt(m2.getValue().get(fieldName)));
			}
		}
		Collections.sort(list);
		return list.get(list.size() - 1);
	}

	int getMin(DataSet dataset, String fieldName) {
		int count = 0;
		ArrayList<Integer> list = new ArrayList<>();
		for (Entry<Long, Row> m2 : dataset.entrySet()) {

			if (!m2.getValue().get(fieldName).equals("")) {
				list.add(Integer.parseInt(m2.getValue().get(fieldName)));
			}
		}
		Collections.sort(list);
		return list.get(0);
	}

	int getCount(DataSet dataset, String fieldName) {
		int count = 0;
		for (Entry<Long, Row> m2 : dataset.entrySet()) {

			if (!m2.getValue().get(fieldName).equals("")) {
				count++;
			}
		}
		return count;
	}

	float getSum(DataSet dataset, String fieldName) {
		float sum = 0;
		for (Entry<Long, Row> m2 : dataset.entrySet()) {

			if (!m2.getValue().get(fieldName).equals("")) {
				sum += Float.parseFloat(m2.getValue().get(fieldName));
			}
		}
		return sum;
	}

	float getAverage(DataSet dataset, String fieldName) {
		float sum = 0;
		float avg = 0;
		for (Entry<Long, Row> m2 : dataset.entrySet()) {

			if (!m2.getValue().get(fieldName).equals("")) {
				sum += Float.parseFloat(m2.getValue().get(fieldName));
			}
		}
		avg = sum / dataset.size();
		return avg;
	}

}
