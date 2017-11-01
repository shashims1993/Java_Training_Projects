package Shashi_FirstQuestion;

public class main {

	/***It will return the output as below 
	 * Default constructor of Employee Class
	Default constructor of Manager Class 
	Default constructor of Employee Class
	Default constructor of Manager Class 
	I am in display of manager
	I am in display of manager
	
	whenever we call a object of child class it will call super class constructor first then it will call child class constructor
	
	*/
	 
	public static void main(String[] args) {
		
		Employee employee = new Manager();
		Manager manager = new Manager();
		
		employee.display();
		manager.display();
	}

	
}
