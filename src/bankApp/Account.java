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
		
	}
	// List common methods
	
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
