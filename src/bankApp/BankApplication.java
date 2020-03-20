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
		
		System.out.println("Hello. Welcome to online banking. Please select which account you would like to work from: ");
		String accountType = in.next();
		if(accountType.equals("Checking")) {
			System.out.println("Please enter 12-digit card number: ");
			int debitCardNum = in.nextInt();
			
		}
		
		System.out.println("What would operation would you like to do. "+	
							"\nType D for Deposit, W for Withdraw or T for Transfer: ");
		String answer = in.next();
		/*
		System.out.println("From which account: ");
		String accountType = in.next();
		*/
		
		if(accountType.equals("Checking")) {
			if(answer.equals("D")) {
				System.out.println("How much would you like to deposit:");
				double amount = in.nextDouble();
				accounts.get(1).deposit(amount);
			}
			
			else if(answer.equals("W")) {
				System.out.println("How much would you like to withdraw:");
				double amount = in.nextDouble();
				accounts.get(1).withdraw(amount);;
			}
			
			else if(answer.equals("T")) {
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
		}
		
		else if(accountType.equals("Savings")) {
			if(answer.equals("D")) {
				System.out.println("How much would you like to deposit:");
				double amount = in.nextDouble();
				accounts.get(1).deposit(amount);
			}
			
			else if(answer.equals("W")) {
				System.out.println("How much would you like to withdraw:");
				double amount = in.nextDouble();
				accounts.get(1).withdraw(amount);;
			}
			
			else if(answer.equals("T")) {
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
		}
		
		else {
			System.out.println("Not a valid account type.");
		}
		
		
		/*
		for (Account acc: accounts) {
			System.out.println("\n######################");
			acc.showInfo();
		}*/
	
		
	}

}
