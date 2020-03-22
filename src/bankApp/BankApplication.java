package bankApp;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class BankApplication {
	
	public static void main(String[] args) {
		
		List<Account> accounts = new LinkedList<Account>();
		String file = "C:\\Users\\nuhash\\Desktop\\Projects\\Bank-App\\bankInfo.csv";
		
		//Read CSV file and create new accounts based on the data
		List<String[]> newAccountHolders = utilities.CSV.read(file);
		
		//Store each account holder's info in an arraylist
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
		
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("Welcome to online banking. Please enter account number: ");
		long accountNum = in.nextLong();
		System.out.println("Please enter 4-digit PIN:");
		int pIN = in.nextInt();
		int count=0;
		
		for(long temp = accountNum; temp > 0; temp = temp/10) {
			count++;
		}
		
		if(count == 12) {
			checkingAction(accounts, accountNum, pIN);
		}
		
		else if(count == 4){
			savingsAction(accounts, (int)accountNum, pIN);
		}
		
		else {
			System.out.println("Invalid Account Type.");
		}
		
		System.out.println("Thank you for banking with your generic banking service. Please come again.");
		
		in.close();
	}
	
	private static void checkingAction(List<Account> accounts, long accountNum, int pIN) {
		long debitCardNum = accountNum;
		int debitCardPIN = pIN;
		for(int i = 0; i < accounts.size(); i++) {
			if(accounts.get(i).loginInfo()[0] == debitCardNum && accounts.get(i).loginInfo()[1] == debitCardPIN) {
				System.out.println("Login accepted.");
				transaction(accounts);
				return;
			}
		}
		System.out.println("Login failed. Please try again.");
	}
	
	private static void savingsAction(List<Account> accounts, int accountNum, int pIN) {
		long safetyDepositBoxID = accountNum;
		int safetyDepositBoxKey = pIN;
		for(int i = 0; i < accounts.size(); i++) {
			if(accounts.get(i).loginInfo()[0] == safetyDepositBoxID && accounts.get(i).loginInfo()[1] == safetyDepositBoxKey) {
				System.out.println("Login accepted.");
				transaction(accounts);
				return;
			}
		}
		System.out.println("Login failed. Please try again.");
	}
	
	private static void transaction(List<Account> accounts) {
		Scanner in = new Scanner(System.in);
		System.out.println("What would operation would you like to do. "+	
				"\nType D for Deposit, W for Withdraw or T for Transfer: ");
		String answer = in.next();
		if(answer.equals("D")) {
			System.out.println("How much would you like to deposit:");
			double amount = in.nextDouble();
			accounts.get(1).deposit(amount);
			System.out.println("Is that everything for today?");
			answer = in.next();
		}

		else if(answer.equals("W")) {
			System.out.println("How much would you like to withdraw:");
			double amount = in.nextDouble();
			accounts.get(1).withdraw(amount);;
		}

		else if(answer.equals("T")) {
			System.out.println("From which account: ");
			String accountType = in.next();
			System.out.println("How much would you like to transfer:");
			double amount = in.nextDouble();
			System.out.println("To whom: ");
			answer = in.next();
			for(int i = 0; i < accounts.size(); i++) {
				if(accounts.get(i).findAccountName().equals(answer)) {
					accounts.get(i).deposit(amount);
					accounts.get(1).transfer(accountType, answer, amount);
					return;
				}
			}

			System.out.println("Cannot not find account holder. Please try a different name.");		
		}
		
		else {
			System.out.println("Invalid option.");
		}
	}

}
