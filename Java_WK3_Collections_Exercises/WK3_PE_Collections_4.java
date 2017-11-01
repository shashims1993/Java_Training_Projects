
/*Create a Student class that represents the following information of a student: id, name, and age all the member variables should be private .
a. Implement `getter and setter` .
b. Create a `StudentSorter` class that implements `Comparator interface` .
c. Write a class `Maintest` create Student class object(minimum 5) 
d. Add these student object into a List of type Student .
e. Sort the list based on their age in decreasing order. 
      For student having same age, sort based on their name.
f. For students having same name and age, sort them according to their ID.*/

import java.util.ArrayList;
import java.util.Collections;

public class WK3_PE_Collections_4 {

	public static void main(String[] args) {

		ArrayList<Student> List = new ArrayList<Student>();
		Student[] studentArray = new Student[3];
		for (int i = 0; i < studentArray.length; i++) {
			studentArray[i] = new Student();
		}
		studentArray[0].setAge(11);
		studentArray[0].setId(1);
		studentArray[0].setName("Shashi");
		studentArray[1].setAge(11);
		studentArray[1].setId(2);
		studentArray[1].setName("apple");
		studentArray[2].setAge(11);
		studentArray[2].setId(3);
		studentArray[2].setName("Shashi");
		List.add(studentArray[0]);
		List.add(studentArray[1]);
		List.add(studentArray[2]);
//		System.out.println(List);
		for(Student st: List){  
			System.out.println(st.getId()+" "+st.getName()+" "+st.getAge());  
			}  
		Collections.sort(List,new ageComparision());  
		for(Student st: List){  
		System.out.println(st.getId()+" "+st.getName()+" "+st.getAge());  
		}  
	}

}
