package bankApp;

import java.util.LinkedList;
import java.util.List;

public class BankApplication {
	
	public static void main(String[] args) {
		List<Account> accounts = new LinkedList<Account>();
		// TODO Auto-generated method stub
		String file = "C:\\Users\\nuhash\\Desktop\\Projects\\Bank-App\\bankInfo.csv";
		//Read CSV file and create new accounts based on the data
		
		List<String[]> newAccountHolders = utilities.CSV.read(file);
		
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
		
		for (Account acc: accounts) {
			System.out.println("\n######################");
			acc.showInfo();
		}
	
		
	}

}
