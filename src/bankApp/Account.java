package bankApp;

public abstract class Account implements IBaseRate{
	//List common properties for Savings and Chequing accounts
	double rate;
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
		this.balance = initDeposit;
		//System.out.println("First name: " + firstName);
		//System.out.println("Last name: " + lastName);
		//System.out.println("SSN: " + sSN);
		//System.out.println("Balance: " + balance);
		this.accountNum = setAccountNumber(sSN);
		setRate();
		
	}
	// List common methods
	
	private String setAccountNumber(int sSN) {
		int lastTwoOfSSN = (sSN%100 - sSN%10) + sSN%10;
		int uniqueID = index++;
	 	int randomNumber = (int)(Math.random()*Math.pow(10, 3));
		return "" + lastTwoOfSSN + uniqueID + randomNumber;
	}
	
	public abstract void setRate();
	
	public void deposit(double amount){
		balance = balance + amount;
		System.out.println("Depositing " + amount);
		printBalance();
	}
	
	public void withdraw(double amount){
		balance = balance - amount;
		System.out.println("Withdrawing " + amount);
		printBalance();
	}
	
	public void transfer(String toWhere, double amount) {
		balance = balance + amount;
		System.out.println("Tranfering $" + amount + " to " + toWhere);
	}
	
	public void printBalance() {
		System.out.println("Your balance is: " + balance);
	}
	
	public void showInfo() {
		System.out.println("Name: " + firstName + " " + 
						lastName + "\nAccount Number: " 
						+ accountNum + "\nBalance: $" 
						+ balance + "\nRate: " + rate + "%"); 
	}
}
