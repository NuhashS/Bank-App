package bankApp;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import javax.swing.*;

public class BankApplication {
	
	public static void main(String[] args) {
	
		
		/*
		JFrame f=new JFrame();
		JButton b=new JButton("click");//creating instance of JButton  
		b.setBounds(130,100,100, 40);//x axis, y axis, width, height  
		
		f.add(b);//adding button in JFrame  
		
		f.setSize(400,400);//400 width and 500 height  
		f.setLayout(new FlowLayout(2));//using no layout managers  
		f.setVisible(true);//making the frame visible  
		*/
		
		Layout mylayout = new Layout("My Custom Layout");
		mylayout.setVisible(true); 
		
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
				transaction(accounts, i);
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
				transaction(accounts, i);
				return;
			}
		}
		System.out.println("Login failed. Please try again.");
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
