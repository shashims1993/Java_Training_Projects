/*
 3. Write a java program to calculate first and last date of a week.
 Output:
        First Date of Week:             Mon 24/07/2017
        Last date of the week:          Sun 30/07/2017 
 */

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class W2_2_3 {

	public static void main(String[] args) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Calendar calendar = new GregorianCalendar();
		
		int year       = calendar.get(Calendar.YEAR);
		int month      = calendar.get(Calendar.MONTH);
		int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
		int dayOfWeek  = calendar.get(Calendar.DAY_OF_WEEK);

		/*** To find the first date of week and last date of the week*/
		int fd=dayOfMonth-dayOfWeek+2;
		int ld=fd+6;
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month);
		calendar.set(Calendar.DAY_OF_MONTH, fd);
		
		System.out.println("First Date of Week:\t"+sdf.format(calendar.getTime()));
		
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month);
		calendar.set(Calendar.DAY_OF_MONTH, ld);
		
		System.out.println("Last Date of Week:\t"+sdf.format(calendar.getTime()));
		
	}

}
