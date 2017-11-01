/*3. Create a class named Member with Name, age, Salary as its variable, write an other class named Member Variable that creates an instance of the Member class, initialises its member variables, and then displays the value of each member variable.
Output: 
Members Name: Harry Potter 
Members Age: 30 
Members Salary: 2500.3*/

public class W2_3 {

	public static void main(String[] args) {
		Member m= new Member();
		m.Name="Harry Potter";
		m.age=25;
		m.salary=2500.3;

		System.out.println("Members Name: "+m.Name+"\n"+"Members Age: "+m.age+"\n"+"Members Salary: "+m.salary);
	}

}
