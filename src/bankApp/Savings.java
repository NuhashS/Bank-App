package bankApp;

public class Savings extends Account{
	//List properties specific to the Savings account
	int safetyDepositBoxID;
	int safetyDepositBoxKey;
	
	//Constructor to initialize settings for the Savings properties
	public Savings(String name, int sSN, double initDeposit) {
		super(name, sSN, initDeposit);
		accountNum = "1" + accountNum;
		//System.out.println("New Savings Account");
		//System.out.println(accountNum);
		setSafetyDepositBox();
	}
	
	private void setSafetyDepositBox() {
		safetyDepositBoxID = (int)(Math.random()*Math.pow(10, 3));
		safetyDepositBoxKey = (int)(Math.random()*Math.pow(10, 4));
	}
	//List any methods specific to savings account
	public void showInfo() {
		super.showInfo();
		System.out.println("Account Type: Savings");
		System.out.println("Safety Deposit Box ID: " + safetyDepositBoxID);
		System.out.println("Safety Deposit Box Key: " + safetyDepositBoxKey);
	}
}
