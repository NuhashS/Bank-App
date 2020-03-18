package bankApp;

public abstract class Account implements IBaseRate{
	//List common properties for Savings and Chequing accounts
	double baseRate;
	int sSN;
	int uniqueNum;
	String firstName;
	String lastName;
	double balance;
	String accountNum;
	static int index = 10000;
	
	//Constructor to set base properties and initialize the account
	public Account(String name, int sSN, double initDeposit) {
		String fullName[] = name.split(" ");
		this.firstName = fullName[0];
		this.lastName = fullName[1];
		this.sSN = sSN;
		balance = initDeposit;
		System.out.println("First name: " + firstName);
		System.out.println("Last name: " + lastName);
		System.out.println("SSN: " + sSN);
		System.out.println("Balance: " + balance);
		this.accountNum = setAccountNumber(sSN);
		
	}
	// List common methods
	
	public String setAccountNumber(int sSN) {
		int lastTwoOfSSN = (sSN%100 - sSN%10) + sSN%10;
		int uniqueID = index++;
		int randomNumber = (int)(Math.random()*Math.pow(10, 3));
		return "" + lastTwoOfSSN + uniqueID + randomNumber;
	}
	
	
	
	public void deposit(){
		
	}
	
	public int withdraw(){
		return 0;
	}
	
	public void transfer() {
		
	}
	
	public void showInfo() {
		
	}
}
