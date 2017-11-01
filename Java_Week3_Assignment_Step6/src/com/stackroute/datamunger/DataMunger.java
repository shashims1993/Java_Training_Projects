package com.stackroute.datamunger;

import java.io.File;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

import com.stackroute.datamunger.query.DataSet;
import com.stackroute.datamunger.query.Query;
import com.stackroute.datamunger.query.Row;
import com.stackroute.datamunger.writer.JsonWriter;


public class DataMunger {
	
	public static void main(String[] args){
		
		
		String queryString = null;
		// read the query from the user
		Scanner input = new  Scanner(System.in);
		System.out.println("Enter the query");
		queryString = input.nextLine();
		input.close();
		/*
		 * Instantiate Query class. This class is responsible for: 1. Parsing
		 * the query 2. Select the appropriate type of query processor 3. Get
		 * the resultSet which is populated by the Query Processor
		 */
		Query query = new Query();

		/*
		 * Instantiate JsonWriter class. This class is responsible for writing
		 * the ResultSet into a JSON file
		 */
		JsonWriter writer = new JsonWriter();
		/*
		 * call executeQuery() method of Query class to get the resultSet. Pass
		 * this resultSet as parameter to writeToJson() method of JsonWriter
		 * class to write the resultSet into a JSON file
		 */
		if (writer.writeToJson(query.executeQuery(queryString))) {
			System.out.println("Output written to data/result.json");
		}
//		System.out.println(new File("data/result.json").length());
//		HashMap dataset= query.executeQuery(queryString);
	/*	boolean dataExpectedStatus = (dataset.get("count(city)").toString().contains("570"));
		System.out.println(dataExpectedStatus);*/
		/*System.out.println(query.executeQuery(queryString).size());
		System.out.println(query.executeQuery(queryString));
		//read the query from the user
		
		float sum=0;
		int count=0;
		for (Entry<Long, Row> m2 : dataset.entrySet()) {
//			 System.out.println(m2.getKey() + " " + m2.getValue().get("win_by_runs")); 
//			sum+=Integer.parseInt(m2.getValue().get("win_by_runs"));
			if(!m2.getValue().get("city").equals(""))
			{
				count++;
			}
			 }
		System.out.println(sum);
		System.out.println(count);*/
		/*
		 * Instantiate Query class. This class is responsible for: 1. Parsing the query
		 * 2. Select the appropriate type of query processor 3. Get the resultSet which
		 * is populated by the Query Processor
		 */
		
		
		/*
		 * Instantiate JsonWriter class. This class is responsible for writing the
		 * ResultSet into a JSON file
		 */
		
		/*
		 * call executeQuery() method of Query class to get the resultSet. Pass this
		 * resultSet as parameter to writeToJson() method of JsonWriter class to write
		 * the resultSet into a JSON file
		 */
		

	}
}
