
/*Class Datamunger added*/
package com.stackroute.datamunger;

package com.stackroute.datamunger;

import java.util.Scanner;
import java.util.Arrays;

public class DataMunger {

	public static void main(String[] args) {
		
		// read the query from the user into queryString variable
		Scanner in = new Scanner(System.in);
		String queryString=in.nextLine();
		in.close();
//		System.out.println(queryString);
		DataMunger dataMunger = new DataMunger();
		// call the parseQuery method and pass the queryString variable as a parameter
//		dataMunger.parseQuery(queryString);
//		System.out.println(dataMunger.getBaseQuery(queryString));
		System.out.println(Arrays.toString(dataMunger.getConditions(queryString)));
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
		return queryString.split(" ");
//		\\s
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
//			System.out.println("where is not present in the query string");
			return null;
		}

	}
	
	
	// get and display the where conditions part(if where condition exists)
	public String getConditionsPartQuery(String queryString) {
		
		if(queryString.contains("where"))
		{
			if((queryString.contains("order by"))  || (queryString.contains("group by")))
				return queryString.split("where")[1].split("order by|group by" )[0];
			else
				return queryString.split("where")[1];
		}
		else
		{
//			System.out.println("where is not present in the query string");
			return null;
		}

	}
	
//	select * from ipl.csv where season > 2014 and city ='Bangalore';
	/* parse the where conditions and display the propertyName, propertyValue and
	 conditionalOperator for each conditions*/
	
	public String[] getConditions(String queryString) {
		
		if(queryString.contains("where"))
		{
			if((queryString.contains("order by"))  || (queryString.contains("group by")))
			{
				String[] temp= queryString.split("where")[1].trim().split(" or |and");
				String[] temp1 = new String[(temp.length)-1];
				System.out.println(Arrays.toString(temp));
				for(int i=0;i<=temp.length-1;i++)
				{
					temp1[i]=temp[i];
				}
				return temp1;
			}
			else
			{
				return queryString.split("where")[1].trim().split(" or |and");	
			}
		}
		else
		{
//			System.out.println("where is not present in the query string");
			return null;
		}
	}
	
	// get the logical operators(applicable only if multiple conditions exist)
	public String[] getLogicalOperators(String queryString) {

		
		
		return null;
		
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
		String selectString =queryString.split("from")[0].split(" ")[1];
		String [] aggragate=null;
		if(selectString.contains("(")  && selectString.contains(")"))
		{
			aggragate=selectString.split(",");
		}

		return aggragate;
	}

	
	
	
	

}

}

