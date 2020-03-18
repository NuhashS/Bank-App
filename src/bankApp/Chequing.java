package bankApp;

public class Chequing extends Account{
	//List properties specific to Chequing account
	int debitCardNum;
	int debitCardPIN;
	//List any methods specific to Chequing account
	
	//Call Constructor to initialize Chequing account properties
	public Chequing(String name, int sSN, double initDeposit) {
		super(name, sSN, initDeposit);
		accountNum = "2" + accountNum;
		System.out.println("New Chequing Account");
		System.out.println(accountNum);
	}
}
