/*
 * DataMunger
 * 
 * Version 1.0
 *
 * 19-Aug-2017
 * 
 */

package com.stackroute.datamunger;

import java.util.Scanner;

public class DataMunger {

	public static void main(String[] args) {
		
		// read the query from the user into queryString variable
		Scanner in = new Scanner(System.in);
		String queryString=in.nextLine();
		in.close();
		DataMunger dataMunger = new DataMunger();
		// call the parseQuery method and pass the queryString variable as a parameter
		dataMunger.parseQuery(queryString);
	}
	

	public  void parseQuery(String queryString) {
		//call the methods
		getSplitStrings(queryString);
		getFile(queryString);
		getBaseQuery(queryString);
		getConditionsPartQuery(queryString);
		getConditions(queryString);
		getLogicalOperators(queryString);
		getFields(queryString);
		getOrderByFields(queryString);
		getGroupByFields(queryString);
		getAggregateFunctions(queryString);
	}
	
	// parse the queryString into words and display
	public String[] getSplitStrings(String queryString) {
		return queryString.split("\\s+");
	}
	
	// get and display the filename
	public String getFile(String queryString) {
		if(queryString.contains("where"))
		{
			return queryString.split("from")[1].trim().split("where")[0].trim();
		}
		else
		{
			return queryString.split("from")[1].trim();
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
		
		if(queryString.contains("where"))
		{
			if((queryString.contains("order by"))  || (queryString.contains("group by")))
			{
				String[] temp= queryString.split("where")[1].trim().split(" order by | group by ")[0].trim().split(" or |and");
				String [] FinalArray= new String[temp.length];
				for(int i=0;i<temp.length;i++)
				{
					FinalArray[i]=temp[i].trim().toLowerCase();
				}
				return FinalArray;
			}
			else
			{
				String [] s2=  queryString.split("where")[1].trim().split(" or |and");
				String [] FinalArray= new String[s2.length];
				for(int i=0;i<s2.length;i++)
				{
					FinalArray[i]=s2[i].trim().toLowerCase();
				}
				
				return FinalArray;
				
			}
		}
		else
		{
			return null;
		}
	}
	
	// get the logical operators(applicable only if multiple conditions exist)
	public String[] getLogicalOperators(String queryString) {

		if((queryString.contains("and"))  || (queryString.contains("or")) || (queryString.contains("not")))
		{
			String [] temp=queryString.split("\\s+");
			int i=0;
			
			String [] temp1= new String[temp.length];
			for (String a  : temp) 
	        {
	             if(a.equals("and")  || a.equals("or") || a.equals("not"))
	             {
	            	 temp1[i]=a;
	            	 i++;
	             }

	        }
			String [] finalArray=new String[i];
			for(int j=0;j<i;j++)
			{
				finalArray[j]=temp1[j];
			}
			return finalArray;
		}
		else
		{
			return null;
		}
		
		
	}
	
	/*get the fields from the select clause*/
	public String[] getFields(String queryString) {
		
		return queryString.split("from")[0].trim().split("select ")[1].split(",");
		
	}
	
	
	// get order by fields if order by clause exists
	public String[] getOrderByFields(String queryString) {
	
		if(queryString.contains("order by"))
		{
			return queryString.split("order by")[1].trim().split(",");
		}
		else
		{
			return null;
		}
	}
	
	// get group by fields if group by clause exists
	
	public String[] getGroupByFields(String queryString) {
		
		if(queryString.contains("group by"))
		{
			return queryString.split("group by")[1].trim().split(",");
		}
		else
		{
			return null;
		}
	}
	
	// parse and display aggregate functions(if applicable)
	
	public String[] getAggregateFunctions(String queryString) {
		
		if(queryString.contains("min") ||queryString.contains("max") || queryString.contains("avg") || queryString.contains("count") || queryString.contains("sum"))
		{
			String temp =queryString.split("from")[0].split(" ")[1];
			String [] aggragate=null;
			if(temp.contains("(")  && temp.contains(")"))
			{
				aggragate=temp.split(",");
			}
			return aggragate;
		}
		else
		{
			return null;
		}
	}
	
}