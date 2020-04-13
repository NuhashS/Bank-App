package bankApp;

import java.util.List;

public class Chequing extends Account{
	//List properties specific to Chequing account
	private long debitCardNum;
	private int debitCardPIN;
	//List any methods specific to Chequing account
	
	//Call Constructor to initialize Chequing account properties
	public Chequing(String name, int sSN, double initDeposit) {
		super(name, sSN, initDeposit);
		this.accountNum = "2" + accountNum;
		setDebitCard();
	}
	
	private void setDebitCard() {
		debitCardNum = (long)(Math.random()*Math.pow(10, 12)); 
		debitCardPIN = (int)(Math.random()*Math.pow(10, 4));
	}
	
	@Override
	public long[] loginInfo() {
		long[] debitInfo = new long[2];
		debitInfo[0] = 720753854098L; 
		debitInfo[1] = 1234;
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
