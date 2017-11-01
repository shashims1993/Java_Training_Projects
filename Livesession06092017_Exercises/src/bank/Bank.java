package bank;

public class Bank extends Account{

	
	
	public int withdrawAmount(int amnt)
	{
		try
		{
			int bal=getBalance();
			if(amnt<bal)
			{
				setBalance(getBalance()-amnt);
				return getBalance();
			}
			else
			{
				throw new InsuffucientAmountClass();
				
				
			}

		}catch(InsuffucientAmountClass e)
		{
			System.out.println(e.toString());
			
		}
		return getBalance();
		
	}
	public void depositAmount(int amnt)
	{
		setBalance(getBalance()+amnt);
	}
}
