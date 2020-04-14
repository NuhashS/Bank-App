package bankApp;

import javax.swing.*;
import javax.swing.text.NumberFormatter;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.NumberFormat;

public class Layout extends JFrame{
	
	private JTextField username = new JTextField("", 15);
	private JPasswordField password= new JPasswordField(15);
	private JLabel message;
	private LoginDatabase db;
	private Container mainPanel = this.getContentPane();
	private JPanel loginPanel = new JPanel(new GridBagLayout());
	private JPanel secondPanel = new JPanel(new GridBagLayout());
	
	public Layout(String title, LoginDatabase database) {
		//Setting frame attributes
		super(title);
		this.setSize(400, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		//Database of all the accounts. Used to verify various information using LoginDatabase class
		db = database;

		mainPanel.setLayout(new GridBagLayout());
		mainPanel.add(loginPanel);
		mainPanel.add(secondPanel);
		secondPanel.setVisible(false);
		initializeMainScreen();
		
	}
	
	private void initializeMainScreen() {
		JButton button1 = new JButton("Login");
		
		GridBagConstraints usernameTextfieldConstraints = new GridBagConstraints();
		usernameTextfieldConstraints.gridx = 0;
		usernameTextfieldConstraints.gridy = 0;
		usernameTextfieldConstraints.ipadx = 5;
		usernameTextfieldConstraints.ipady = 5;
		usernameTextfieldConstraints.insets = new Insets(10, 50, 10, 50);
		loginPanel.add(username, usernameTextfieldConstraints);
		
		GridBagConstraints passwordTextfieldConstraints = new GridBagConstraints();
		passwordTextfieldConstraints.weightx = 0.5;
		passwordTextfieldConstraints.gridx = 0;
		passwordTextfieldConstraints.gridy = 1;
		passwordTextfieldConstraints.ipadx = 5;
		passwordTextfieldConstraints.ipady = 5;
		passwordTextfieldConstraints.insets = new Insets(10, 0, 10, 0);
		loginPanel.add(password, passwordTextfieldConstraints);
		
		GridBagConstraints button1Constraints = new GridBagConstraints();
		button1Constraints.weightx = 0.2;
		button1Constraints.gridx = 0;
		button1Constraints.gridy = 2;
		button1Constraints.ipadx = 5;
		button1Constraints.ipady = 5;
		button1Constraints.insets = new Insets(10, 0, 10, 0); 
		loginPanel.add(button1, button1Constraints);
		
		button1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String myusername = String.valueOf(username.getText());
				String mypassword = String.valueOf(password.getPassword()); 
				
				if(db.accountCheck(myusername, mypassword)) {
					loginPanel.setVisible(false);
					initializeBankActionsScreen();
				}
				else {
					JOptionPane.showMessageDialog(null, "Invalid Password");
				}
				
			}
		});
	}
	
	private void initializeBankActionsScreen() {
		secondPanel.setVisible(true);
		JButton okButton = new JButton("OK");
		JLabel chooseOperationText = new JLabel("What operation would you like to perform:");
		ButtonGroup bankActions = new ButtonGroup();
		
		GridBagConstraints chooseOperationTextConstraints = new GridBagConstraints();
		chooseOperationTextConstraints.gridwidth = GridBagConstraints.REMAINDER;
		secondPanel.add(chooseOperationText, chooseOperationTextConstraints);
		
		JRadioButton withdraw = new JRadioButton("Withdraw");
		bankActions.add(withdraw);
		GridBagConstraints withdrawConstraints = new GridBagConstraints();
		withdrawConstraints.gridx = 0;
		withdrawConstraints.gridy = 1;
		withdrawConstraints.ipadx = 5;
		withdrawConstraints.ipady = 5;
		secondPanel.add(withdraw, withdrawConstraints);
		
		JRadioButton deposit = new JRadioButton("Deposit");
		bankActions.add(deposit);
		GridBagConstraints depositConstraints = new GridBagConstraints();
		depositConstraints.gridx = 1;
		depositConstraints.gridy = 1;
		depositConstraints.ipadx = 5;
		depositConstraints.ipady = 5; 
		secondPanel.add(deposit, depositConstraints);
		
		JRadioButton transfer = new JRadioButton("Transfer");
		bankActions.add(transfer);
		GridBagConstraints transferConstraints = new GridBagConstraints();
		transferConstraints.gridx = 2;
		transferConstraints.gridy = 1;
		transferConstraints.ipadx = 5;
		transferConstraints.ipady = 5;
		secondPanel.add(transfer, transferConstraints);
		
		GridBagConstraints okButtonConstraints = new GridBagConstraints();
		okButtonConstraints.gridx = 1;
		okButtonConstraints.gridy = 2;
		secondPanel.add(okButton,okButtonConstraints);
		
		okButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(withdraw.isSelected()) {
					JOptionPane.showMessageDialog(null, "Withdrawing");
				}
				
				else if(deposit.isSelected()) {
					JOptionPane.showMessageDialog(null, "Depositing");
				}
				
				else if(transfer.isSelected()) {
					JOptionPane.showMessageDialog(null, "Transfering");
				}
				
				else {
					JOptionPane.showMessageDialog(null, "Invalid Operation");
				}
				
			}
		});
	}
	
	
}
