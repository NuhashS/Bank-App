package bankApp;

import java.util.List;

public class BankApplication {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String file = "C:\\Users\\nuhash\\Desktop\\Projects\\Bank-App\\bankInfo.csv";
		//Read CSV file and create new accounts based on the data
		List<String[]> newAccountHolders = utilities.CSV.read(file);
		for(String[] accountHolder : newAccountHolders) {
			System.out.println("New Accounts:");
			System.out.println(accountHolder[0]);
			System.out.println(accountHolder[1]);
			System.out.println(accountHolder[2]);
			System.out.println(accountHolder[3]);
		}
		
		//Chequing chqacc1 = new Chequing("John Smith", 123456789, 15000);
		
	 	//Savings savacc1 = new Savings("Rich Lowe", 987654321, 321);
		//
		//savacc1.showInfo();
		//System.out.println("########################");
		//chqacc1.showInfo();
		
		
	}

}
