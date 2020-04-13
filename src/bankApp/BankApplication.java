package bankApp;

public class BankApplication {
	
	public static void main(String[] args) {
		
		//Initialize Database
		LoginDatabase database = new LoginDatabase();
		
		//Create layout. Pass database so that you can verify login
		Layout mylayout = new Layout("My Custom Layout", database);
		mylayout.setVisible(true); 
		
	}

}
