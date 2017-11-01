package bank;

import java.util.Arrays;

public class InsuffucientAmountClass extends Exception {

	InsuffucientAmountClass()
	{
		
	}
	@Override
	public String toString() {
		return "Amount to be withdraw is more than balance ";
	}
	
	

}
