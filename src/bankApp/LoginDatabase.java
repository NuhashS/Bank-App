package bankApp;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

//This entire class is only temporary. Replace this with a database later on.
public class LoginDatabase {
	
	private List<Account> accounts = new LinkedList<Account>();
	private String file = "C:\\Users\\nuhash\\Desktop\\Projects\\Bank-App\\bankInfo.csv";
	private List<String[]> newAccountHolders = utilities.CSV.read(file);
	private int accountID;
	
	public LoginDatabase(){
		
		for(String[] accountHolder : newAccountHolders) {
			String name = accountHolder[0];
			int sSN = Integer.parseInt(accountHolder[1]);
			String accountType = accountHolder[2];
			double initDeposit = Double.parseDouble(accountHolder[3]);
			if (accountType.equals("Savings")) {
				accounts.add(new Savings(name, sSN, initDeposit));
			}
			else if(accountType.equals("Checking")) {
				accounts.add(new Chequing(name, sSN, initDeposit));
			}
			else {
				System.out.println("ERROR: ACCOUNT TYPE NOT FOUND");
			}
		}
	}
	
	public boolean accountCheck(String accountNum, String pIN) {
		
		int count = 0;
		
		for(int i = 0; i < accountNum.length(); i++) {
			count++;
		}
		
		if(count == 12) {
			return checkingAction(accountNum, pIN);
		}
		
		else if(count == 3){
			return savingsAction(accountNum, pIN);
		}
		
		else {
			return false;
		}
		
	}
	
	private boolean checkingAction(String accountNum, String pIN) {
		String debitCardNum = accountNum;
		String debitCardPIN = pIN;
		for(int i = 0; i < accounts.size(); i++) {
			if(String.valueOf(accounts.get(i).loginInfo()[0]).equals(debitCardNum) && String.valueOf(accounts.get(i).loginInfo()[1]).equals(debitCardPIN)) {
				accountID = i;
				return true;
			}
		}
		return false;
	}
	
	private boolean savingsAction(String accountNum, String pIN) {
		String safetyDepositBoxID = accountNum;
		String safetyDepositBoxKey = pIN;
		for(int i = 0; i < accounts.size(); i++) {
			if(String.valueOf(accounts.get(i).loginInfo()[0]).equals(safetyDepositBoxID) && String.valueOf(accounts.get(i).loginInfo()[1]).equals(safetyDepositBoxKey)) {
				//System.out.println("Login accepted.");
				//transaction(accounts, i);
				accountID = i;
				return true;
			}
		}
		return false;
	}
	
	public String withdrawAction(int amount) {
		return accounts.get(accountID).withdraw(amount, "yes");
	}
	
	public String depositAction(int amount) {
		return accounts.get(accountID).deposit(amount, "yes");
	}
	
	public String transferAction(int amount, String accountType, String answer) {
		/*System.out.println("From which account: ");
		String accountType = in.next();
		System.out.println("How much would you like to transfer:");
		double amount = in.nextDouble();
		System.out.println("To whom: ");
		answer = in.next();*/
		
		boolean realAccount = false;
		
		for(int i = 0; i < accounts.size(); i++) {
			if(accounts.get(i).findAccountName().equals(answer)) {
				accounts.get(i).deposit(amount, "no");
				accounts.get(accountID).transfer(accountType, answer, amount);
				realAccount = true;
				break;
			}
		}
		if(!realAccount) {
			System.out.println("Cannot not find account holder. Please try a different name.");
		}
		
		return "works";
	}
	
	private static void transaction(List<Account> accounts, int accountID) {
		Scanner in = new Scanner(System.in);
		System.out.println("What operation would you like to perform? "+	
				"\nType D for Deposit, W for Withdraw or T for Transfer: ");
		String answer = in.next();
		if(answer.equals("D")) {
			System.out.println("How much would you like to deposit:");
			double amount = in.nextDouble();
			accounts.get(accountID).deposit(amount, "yes");
		}

		else if(answer.equals("W")) {
			System.out.println("How much would you like to withdraw:");
			double amount = in.nextDouble();
			accounts.get(accountID).withdraw(amount, "yes");
		}

		else if(answer.equals("T")) {
			System.out.println("From which account: ");
			String accountType = in.next();
			System.out.println("How much would you like to transfer:");
			double amount = in.nextDouble();
			System.out.println("To whom: ");
			answer = in.next();
			
			boolean realAccount = false;
			
			for(int i = 0; i < accounts.size(); i++) {
				if(accounts.get(i).findAccountName().equals(answer)) {
					accounts.get(i).deposit(amount, "no");
					accounts.get(accountID).transfer(accountType, answer, amount);
					realAccount = true;
					break;
				}
			}
			if(!realAccount) {
				System.out.println("Cannot not find account holder. Please try a different name.");
			}	
		}
		
		System.out.println("Would you like to perform another transaction?");
		answer = in.next();
		
		if(answer.equals("Y") || answer.equals("Yes")) {
			transaction(accounts, accountID);
		}
		else if(answer.equals("N") || answer.equals("No")) {
			return;
		}
		
		else {
			System.out.println("Invalid option");
			return; 
		}
	}
	
}
