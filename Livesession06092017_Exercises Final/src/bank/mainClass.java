package bank;

public class mainClass {

	public static void main(String[] args) {

		Bank b = new Bank();
		b.setBalance(1000);
		b.depositAmount(500);
		System.out.println(b.withdrawAmount(5000));

	}

}
