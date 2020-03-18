package bankApp;

public class Savings extends Account{
	//List properties specific to the Savings account
	int safetyDepositBoxID;
	int safetyDepositBoxKey;
	
	//Constructor to initialize settings for the Savings properties
	public Savings(String name, int sSN, double initDeposit) {
		super(name, sSN, initDeposit);
		this.accountNum = "1" + accountNum;
		setSafetyDepositBox();
	}
	
	private void setSafetyDepositBox() {
		safetyDepositBoxID = (int)(Math.random()*Math.pow(10, 3));
		safetyDepositBoxKey = (int)(Math.random()*Math.pow(10, 4));
	}
	//List any methods specific to savings account
	
	@Override
	public void setRate() {
		//System.out.print("Implement Rate for Chequing: ");
		rate = getBaseRate()-.25;
		//System.out.println(rate);
	}
	
	public void showInfo() {
		super.showInfo();
		System.out.println("Account Type: Savings");
		System.out.println("Safety Deposit Box ID: " + safetyDepositBoxID);
		System.out.println("Safety Deposit Box Key: " + safetyDepositBoxKey);
	}
}
