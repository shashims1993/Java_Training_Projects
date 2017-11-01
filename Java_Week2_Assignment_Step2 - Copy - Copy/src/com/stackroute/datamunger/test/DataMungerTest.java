package com.stackroute.datamunger.test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.stackroute.datamunger.DataMunger;
import com.stackroute.datamunger.query.parser.AggregateFunction;
import com.stackroute.datamunger.query.parser.QueryParameter;
import com.stackroute.datamunger.query.parser.QueryParser;
import com.stackroute.datamunger.query.parser.Restriction;

public class DataMungerTest {

	
	private static QueryParser queryParser;
	private static QueryParameter queryParameter;
	private String queryString;
	


	@Before
	public void setup() {
		//setup methods runs, before every test case runs
		//This method is used to initialize the required variables
		queryParser = new QueryParser();
		
	}
	@After
	public void teardown() {
		//teardown method runs, after every test case run
		//This method is to clear the initialized variables
		queryParser = null;

	}
	
	
	@Test
	public void testGetFileName() {
		queryString = "select * from ipl.csv";
		queryParameter = queryParser.parseQuery(queryString);
		assertEquals("testGetFileName(): File name extraction failed. Check getFile() method. File name can be found after a space after from clause. Note: CSV file can contain a field that contains from as a part of the column name. For eg: from_date,from_hrs etc","ipl.csv", queryParameter.getFile());
		display(queryString, queryParameter);
	}
	@Test
	public void testGetFileNameFailure() {
		queryString = "select * from ipl.csv";
		queryParameter = queryParser.parseQuery(queryString);
		assertNotEquals("testGetFileNameFailure() : File name extraction failed. Check getFile() method. File name can be found after a space after from clause. Note: CSV file can contain a field that contains from as a part of the column name. For eg: from_date,from_hrs etc","ipl2.csv", queryParameter.getFile());
		display(queryString, queryParameter);
	}
	@Test
	public void testGetFields() {
		queryString = "select city, winner, team1,team2 from ipl.csv";
		queryParameter = queryParser.parseQuery(queryString);
		List<String> expectedFields = new ArrayList<>();
		expectedFields.add("city");
		expectedFields.add("winner");
		expectedFields.add("team1");
		expectedFields.add("team2");
		assertArrayEquals("testGetFields() : Select fields extractions failed. The query string can have multiple fields separated by comma after the 'select' keyword. The extracted fields is supposed to be stored in a String array which is to be returned by the method getFields(). Check getFields() method",expectedFields.toArray(), queryParameter.getFields().toArray());
		display(queryString, queryParameter);
	}
	
	@Test
	public void testGetFieldsFailure() {
		queryString = "select city, winner, team1,team2 from ipl.csv";
		queryParameter = queryParser.parseQuery(queryString);
		List<String> expectedFields = new ArrayList<>();
		expectedFields.add("city");
		expectedFields.add("winner");
		expectedFields.add("team1");
		expectedFields.add("team2");
		//TODO: change to notequals
		assertNotEquals("testGetFieldsFailure() : Invalid Column / Field values. Please note that the query string can have multiple fields separated by comma after the 'select' keyword. The extracted fields is supposed to be stored in a String array which is to be returned by the method getFields(). Check getFields() method",false,Arrays.equals(expectedFields.toArray(), queryParameter.getFields().toArray()));
		display(queryString, queryParameter);
	}
	
	@Test
	public void testGetFieldsAndRestrictions() {
		queryString = "select city,winner,player_match from ipl.csv where season > 2014";
		queryParameter = queryParser.parseQuery(queryString);
		List<Restriction> restrictions = queryParameter.getRestrictions();
		assertNotNull("testGetFieldsAndRestrictions() : Hint: extract the conditions from the query string(if exists). for each condition, we need to capture the following: 1. Name of field, 2. condition, 3. value, please note the query might contain multiple conditions separated by OR/AND operators",restrictions);
		
		display(queryString, queryParameter);
	}
	
	
	@Test
	public void testGetFieldsAndMultipleRestrictions() {
		queryString = "select city,winner,player_match from ipl.csv where season > 2014 and city ='Bangalore'";
		queryParameter = queryParser.parseQuery(queryString);
		List<Restriction> restrictions = queryParameter.getRestrictions();
		assertNotNull("testGetFieldsAndMultipleRestrictions() : Hint: extract the conditions from the query string(if exists). for each condition, we need to capture the following: 1. Name of field, 2. condition, 3. value, please note the query might contain multiple conditions separated by OR/AND operators",restrictions);
		
		display(queryString, queryParameter);
	}
	
	
	@Test
	public void testGetFieldsAndMultipleRestrictions2() {
		queryString = "select city,winner,player_match from ipl.csv where season > 2014 or city ='Bangalore'";
		queryParameter = queryParser.parseQuery(queryString);
		List<Restriction> restrictions = queryParameter.getRestrictions();
		assertNotNull("testGetFieldsAndMultipleRestrictions2() : Hint: extract the conditions from the query string(if exists). for each condition, we need to capture the following: 1. Name of field, 2. condition, 3. value, please note the query might contain multiple conditions separated by OR/AND operators",restrictions);
		
		display(queryString, queryParameter);
	}
	
	
	@Test
	public void testGetFieldsAndThreeRestrictions() {
		queryString = "select city,winner,player_match from ipl.csv where season > 2014 and city ='Bangalore' or city ='Delhi'";
		queryParameter = queryParser.parseQuery(queryString);
		List<Restriction> restrictions = queryParameter.getRestrictions();
		assertNotNull("testGetFieldsAndThreeRestrictions() : Hint: extract the conditions from the query string(if exists). for each condition, we need to capture the following: 1. Name of field, 2. condition, 3. value, please note the query might contain multiple conditions separated by OR/AND operators",restrictions);
		
		display(queryString, queryParameter);
	}
	
	@Test
	public void testGetAggregateFunctions() {
		queryString = "select count(city),avg(win_by_runs),min(season),max(win_by_wickets) from ipl.csv";
		queryParameter = queryParser.parseQuery(queryString);
		List<AggregateFunction> aggregateFunctions=queryParameter.getAggregateFunctions();
		assertNotNull("testGetAggregateFunctions() : Hint: extract the aggregate functions from the query. The presence of the aggregate functions can determined if we have either 'min' or 'max' or 'sum' or 'count' or 'avg' followed by opening braces'(' after 'select' clause in the query. string. in case it is present, then we will have to extract the same. For each aggregate functions, we need to know the following: 1. type of aggregate function(min/max/count/sum/avg), 2. field on which the aggregate function is being applied. Please note that more than one aggregate function can be present in a query",aggregateFunctions);
		display(queryString, queryParameter);
	}
	

	@Test
	public void testGetGroupByClause() {
		queryString = "select city,avg(win_by_runs) from ipl.csv group by city";
		queryParameter = queryParser.parseQuery(queryString);
		assertNotNull("testGetGroupByClause() : Hint: Check getGroupByFields() method. The query string can contain more than one group by fields. it is also possible thant the query string might not contain group by clause at all. The field names, condition values might contain 'group' as a substring. For eg: newsgroup_name",queryParameter.getGroupByFields());
		
		display(queryString, queryParameter);
	}
	
		
	@Test
	public void testGetGroupByOrderByClause() {
		queryString = "select city,winner,team1,team2 from ipl.csv where season > 2016 and city='Bangalore' group by winner order by city";
		queryParameter = queryParser.parseQuery(queryString);
		List<Restriction> restrictions = queryParameter.getRestrictions();
		assertNotNull("testGetGroupByOrderByClause() : Hint: Check getGroupByFields() method. The query string can contain more than one group by fields. it is also possible thant the query string might not contain group by clause at all. The field names, condition values might contain 'group' as a substring. For eg: newsgroup_name",queryParameter.getGroupByFields());
		assertNotNull("testGetGroupByOrderByClause() : Hint: Please note that we will need to extract the field(s) after 'order by' clause in the query, if at all the order by clause exists.",queryParameter.getOrderByFields());
		assertNotNull("testGetGroupByOrderByClause() : Hint: extract the conditions from the query string(if exists). for each condition, we need to capture the following: 1. Name of field, 2. condition, 3. value, please note the query might contain multiple conditions separated by OR/AND operators",restrictions);
		
		display(queryString, queryParameter);
	}
	
		
	@Test
	public void testGetdWhereConditionClause() {
		queryString = "select city,winner,player_match from ipl.csv where season > 2014 and city ='Bangalore'";
		queryParameter = queryParser.parseQuery(queryString);
		List<Restriction> restrictions = queryParameter.getRestrictions();
		assertNotNull("testGetdWhereConditionClause(): Hint: extract the conditions from the query string(if exists). for each condition, we need to capture the following: 1. Name of field, 2. condition, 3. value, please note the query might contain multiple conditions separated by OR/AND operators",restrictions);
		
		display(queryString, queryParameter);
	}
	
	@Test
	public void testGetOrderByAndWhereConditionClauseFailure() {
		queryString = "select city,winner,player_match from ipl.csv where season > 2014 and city ='Bangalore' order by city";
		queryParameter = queryParser.parseQuery(queryString);
		List<Restriction> restrictions = queryParameter.getRestrictions();
		assertNotNull("testGetOrderByAndWhereConditionClauseFailure() : Hint: extract the conditions from the query string(if exists). for each condition, we need to capture the following: 1. Name of field, 2. condition, 3. value, please note the query might contain multiple conditions separated by OR/AND operators",restrictions);
		assertNotNull("testGetOrderByAndWhereConditionClauseFailure() :Hint: Please note that we will need to extract the field(s) after 'order by' clause in the query, if at all the order by clause exists.",queryParameter.getOrderByFields());
		display(queryString, queryParameter);
	}
		
	@Test
	public void testGetOrderByClause() {
		queryString = "select city,winner,team1,team2,player_match from ipl.csv order by city";
		queryParameter = queryParser.parseQuery(queryString);
		List<String> orderByFields = queryParameter.getOrderByFields();
		assertNotNull("testGetOrderByClause() : Hint: Please note that we will need to extract the field(s) after 'order by' clause in the query, if at all the order by clause exists",orderByFields);
		display(queryString, queryParameter);
	}
	
	
	@Test
	public void testGetGroupeByWithoutWhereClause() {
		queryString = "select winner,count(*) from ipl.csv where season > 2016 group by winner";
		queryParameter = queryParser.parseQuery(queryString);
		List<String> groupByFields = queryParameter.getGroupByFields();
		assertNotNull("testGetGroupeByWithoutWhereClause() : Hint: Check getGroupByFields() method. The query string can contain more than one group by fields. it is also possible thant the query string might not contain group by clause at all. The field names, condition values might contain 'group' as a substring. For eg: newsgroup_name",groupByFields);
		
		display(queryString, queryParameter);
	}
	
	
	private void display(String queryString, QueryParameter queryParameter) {
		System.out.println("\nQuery : " + queryString);
		System.out.println("--------------------------------------------------");
		System.out.println("Base Query:" + queryParameter.getBaseQuery());
		System.out.println("File:" + queryParameter.getFile());
		System.out.println("Query Type:" + queryParameter.getQUERY_TYPE());
		List<String> fields = queryParameter.getFields();
		System.out.println("Selected field(s):");
		if (fields == null || fields.isEmpty()) {
			System.out.println("*");
		} else {
			for (String field : fields) {
				System.out.println("\t" + field);
			}
		}
		
		List<Restriction> restrictions = queryParameter.getRestrictions();
		
		if(restrictions!=null && !restrictions.isEmpty())
		{
			System.out.println("Where Conditions : ");
			int conditionCount=1;
			for(Restriction restriction :restrictions )
			{
				System.out.println("\tCondition : " + conditionCount++);
				System.out.println("\t\tName : "+restriction.getPropertyName());
				System.out.println("\t\tCondition : "+restriction.getCondition());
				System.out.println("\t\tValue : "+restriction.getPropertyValue());
			}
		}
		List<AggregateFunction>  aggregateFunctions = queryParameter.getAggregateFunctions();
		if(aggregateFunctions!=null && !aggregateFunctions.isEmpty()){
			
			System.out.println("Aggregate Functions : ");
			int funtionCount=1;
			for(AggregateFunction aggregateFunction :aggregateFunctions )
			{
				System.out.println("\t Aggregate Function : " + funtionCount++);
				System.out.println("\t\t function : "+aggregateFunction.getFunction());
				System.out.println("\t\t  field : "+aggregateFunction.getField());
			}
			
		}
		
		List<String>  orderByFields = queryParameter.getOrderByFields();
		if(orderByFields!=null && !orderByFields.isEmpty()){
			
			System.out.println(" Order by fields : ");
			for(String orderByField :orderByFields )
			{
				System.out.println("\t "+orderByField);
				
			}
			
		}
		
		List<String>  groupByFields = queryParameter.getGroupByFields();
		if(groupByFields!=null && !groupByFields.isEmpty()){
			
			System.out.println(" Group by fields : ");
			for(String groupByField :groupByFields )
			{
				System.out.println("\t "+groupByField);
				
			}
			
		}
	}
	
	
	
	
	
	
	
	
	
}