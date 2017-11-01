package com.stackroute.datamunger;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.stackroute.datamunger.query.parser.AggregateFunction;
import com.stackroute.datamunger.query.parser.Restriction;
public class DataMunger {

	
	public static void main(String[] args) {

		
		//read the query from the user
		
		
		//create an object of QueryParser class
		
		
		/*
		 * call parseQuery() method of the class by passing the query string which will
		 * return object of QueryParameter
		 */
		
		Scanner in = new Scanner(System.in);
		String queryString=in.nextLine();
		in.close();
		DataMunger dataMunger = new DataMunger();

		// call the parseQuery method and pass the queryString variable as a parameter
		System.out.println(dataMunger.getFile(queryString));

	}
	
	// get and display the filename
		public String getFile(String queryString) {
			queryString=queryString.toLowerCase();
			if(queryString.contains("where"))
			{
				return queryString.split("from")[1].trim().split("where")[0].trim();
			}
			else
			{
				if((queryString.contains("order by"))  || (queryString.contains("group by")))
				{
					return queryString.split("from")[1].split("order by|group by")[0].trim();
				}
				else
				{
					return queryString.split("from")[1].trim();
				}
			}
		}
		
		
		// getting the baseQuery and display
		//Checking whether the where condtion, group by and order by is there or not and giving the base query
		public String getBaseQuery(String queryString) {
			
			if(queryString.contains("where"))
			{
				return queryString.split("where")[0];
			}
			else if(queryString.contains("group by"))
			{
				return queryString.split("group by")[0];
			}
			else if(queryString.contains("order by"))
			{
				return queryString.split("order by")[0];
			}
			else
			{
				return null;
			}
		}
		
		
		// get and display the where conditions part(if where condition exists)
		public String getConditionsPartQuery(String queryString) {
			
			if(queryString.contains("where"))
			{
				if((queryString.contains("order by"))  || (queryString.contains("group by")))
					return queryString.split("where")[1].split("order by|group by" )[0].toLowerCase();
				else
					return queryString.split("where")[1].toLowerCase();
			}
			else
			{
				return null;
			}
		}
		
		/* parse the where conditions and display the propertyName, propertyValue and
		 conditionalOperator for each conditions*/
		
		public String[] getConditions(String queryString) {
			queryString=queryString.toLowerCase();
			if(queryString.contains("where"))
			{
				if((queryString.contains("order by"))  || (queryString.contains("group by")))
				{
					String[] outputOfSplit= queryString.split("where")[1].trim().split(" order by | group by ")[0].trim().split(" or |and");
					ArrayList<String> listOfConditions = new ArrayList<String>();
					for (String a : outputOfSplit) {
						listOfConditions.add(a.trim());
					}
					outputOfSplit = listOfConditions.toArray(outputOfSplit);
					return outputOfSplit;
				}
				else
				{
					String [] outputOfSplit=  queryString.split("where")[1].trim().split(" or |and");
					ArrayList<String> listOfConditions = new ArrayList<String>();
					for (String a : outputOfSplit) {
						listOfConditions.add(a.trim());
					}
					outputOfSplit = listOfConditions.toArray(outputOfSplit);
					
					return outputOfSplit;
					
				}
			}
			else
			{
				return null;
			}
		}
		
		// get the logical operators(applicable only if multiple conditions exist)
		public ArrayList<String> getLogicalOperators(String queryString) {
			if((queryString.contains("and"))  || (queryString.contains("or")) || (queryString.contains("not")))
			{
				String [] temp=queryString.split("\\s+");
				ArrayList<String> listOfOperators = new ArrayList<String>();
				for (String a  : temp) 
		        {
		             if(a.equals("and")  || a.equals("or") || a.equals("not"))
		             {
		            	 listOfOperators.add(a);
		             }
		        }
				return listOfOperators;
			}
			else
			{
				return null;
			}
			
			
		}
		
		/*get the fields from the select clause*/
		public ArrayList<String> getFields(String queryString) {
			
			String[] fieldsArray =queryString.split("from")[0].trim().split("select ")[1].split(",");
			ArrayList<String> listOfFields = new ArrayList<>();
			for (String var : fieldsArray) {
				listOfFields.add(var.trim());
			}
			return listOfFields;
		}
		
		
		// get order by fields if order by clause exists
		public ArrayList<String> getOrderByFields(String queryString) {
		
			if(queryString.contains("order by"))
			{
				String[] ordeyByFieldsArray = queryString.split("order by")[1].trim().split(",");
				ArrayList<String> listOfOrderByFields = new ArrayList<>();
				for (String var : ordeyByFieldsArray) {
					listOfOrderByFields.add(var.trim());
				}
				return listOfOrderByFields;
			}
			else
			{
				return null;
			}
		}
		
		// get group by fields if group by clause exists
		
		public ArrayList<String> getGroupByFields(String queryString) {
			
			if (queryString.contains("group by")) 
		{
			if (queryString.contains("order by")) 
			{

				String[] groupByFieldsArray = queryString.split("group by")[1].trim().split("order by")[0].split(",");
				ArrayList<String> listOfGroupByFields = new ArrayList<>();
				for (String var : groupByFieldsArray) 
				{
					listOfGroupByFields.add(var.trim());
				}
				return listOfGroupByFields;
				
			}
			else 
			{
				String[] groupByFieldsArray = queryString.split("group by")[1].trim().split(",");
				ArrayList<String> listOfGroupByFields = new ArrayList<>();
				for (String var : groupByFieldsArray) 
				{
					listOfGroupByFields.add(var.trim());
				}
				return listOfGroupByFields;
			}
		} 
			return null;
		}
		
		// parse and display aggregate functions(if applicable)
		
		
		public ArrayList<AggregateFunction> getAggregateFunctionsValue(String queryString) {

			String query = queryString.toLowerCase();
			String temp[] = null;
			String[] aggregateFunctions = new String[] { "min", "max", "count", "avg", "sum" };
			ArrayList<AggregateFunction> list = new ArrayList<AggregateFunction>();

			temp = query.split("from ")[0].trim().split("select")[1].trim().split(",");
			for (String s : aggregateFunctions) {
				for (String i : temp) {
					if (i.contains(s)) {
					    AggregateFunction Aggregate = new AggregateFunction();
						Aggregate.setFunction(s.trim());
						Aggregate.setField(i.substring(i.indexOf("(") + 1, i.indexOf(")")).trim());
						list.add(Aggregate);
					}
				}
			}

			return list;
		}
		
		public List<Restriction> getcondtionalfunctions(String queryString) {

// 			String query = queryString.toLowerCase();
            String query = queryString;
			String[] matches = new String[] { ">", "<", "=", "!=", "<=", ">=", "<>", "is ", "like ", "in ",};
			String[] conditionsArray = null;
			Boolean flag=false;
			List<Restriction> list = new ArrayList<>();
			if (query.contains("where ")) {
				if (query.contains("group by")) {
					query = query.split("group by")[0].trim();
				}
				if (query.contains("order by")) {
					query = query.split("order by")[0].trim();
					if (query.contains("group by")) {
						query = query.split("group by")[0].trim();
					}
				}

				conditionsArray = query.split("where ")[1].trim().split("and |or ");

				for (String k : conditionsArray) {
					for (String s : matches) {
						if (k.contains(s)) {
						    Restriction Restrict = new Restriction();
							Restrict.setPropertyName(k.substring(0, k.indexOf(s)));
							Restrict.setCondition(s);
							Restrict.setPropertyValue(k.substring(k.indexOf(s) + 1, k.length()));
							list.add(Restrict);
							flag=true;
						}
					}
				}
			}
			if(flag==true)
			    return list;
	    	else
			    return null;
		}
		
	}

	

