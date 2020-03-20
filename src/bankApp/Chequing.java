package bankApp;

public class Chequing extends Account{
	//List properties specific to Chequing account
	private int debitCardNum;
	private int debitCardPIN;
	//List any methods specific to Chequing account
	
	//Call Constructor to initialize Chequing account properties
	public Chequing(String name, int sSN, double initDeposit) {
		super(name, sSN, initDeposit);
		this.accountNum = "2" + accountNum;
		setDebitCard();
	}
	
	private void setDebitCard() {
		debitCardNum = (int)(Math.random()*Math.pow(10,12));
		debitCardPIN = (int)(Math.random()*Math.pow(10,4));
	}
	
	public int[] checkDebitInfo() {
		int[] debitInfo = new int[2];
		debitInfo[0] = debitCardNum;
		debitInfo[1] = debitCardPIN;
		return debitInfo;
	}
	
	@Override
	public void setRate() {
		rate = getBaseRate()*.15;
	}
	
	public void showInfo() {
		super.showInfo();
		System.out.println("Account Type: Chequing");
		System.out.println("Debit Card Number: " + debitCardNum);
		System.out.println("Debit Card PIN: " + debitCardPIN);
	}
}
