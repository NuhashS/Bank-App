package bankApp;

public class BankApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Chequing chqacc1 = new Chequing("John Smith", 123456789, 15000);
		
		Savings savacc1 = new Savings("Rich Lowe", 987654321, 321);
		//
		savacc1.showInfo();
		System.out.println("########################");
		chqacc1.showInfo();
		//Read CSV file and create new accounts based on the data
	}

}
