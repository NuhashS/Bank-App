package bankApp;

import javax.swing.*;
import javax.swing.text.NumberFormatter;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.NumberFormat;

public class Layout extends JFrame implements ActionListener{
	
	private JTextField username;
	private JPasswordField password;
	private JLabel message;
	private LoginDatabase db;
	
	public Layout(String title, LoginDatabase database) {
		super(title);
		this.setSize(400, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);

		JButton button1 = new JButton("Login");
		username = new JTextField("", 15);
		password = new JPasswordField(15);
		db = database;

		Container mainPanel = this.getContentPane();
		mainPanel.setLayout(new GridBagLayout());

		GridBagConstraints usernameTextfieldConstraints = new GridBagConstraints();
		usernameTextfieldConstraints.gridx = 0;
		usernameTextfieldConstraints.gridy = 0;
		usernameTextfieldConstraints.ipadx = 5;
		usernameTextfieldConstraints.ipady = 5;
		usernameTextfieldConstraints.insets = new Insets(10, 50, 10, 50);
		mainPanel.add(username, usernameTextfieldConstraints);
		
		GridBagConstraints passwordTextfieldConstraints = new GridBagConstraints();
		passwordTextfieldConstraints.weightx = 0.5;
		passwordTextfieldConstraints.gridx = 0;
		passwordTextfieldConstraints.gridy = 1;
		passwordTextfieldConstraints.ipadx = 5;
		passwordTextfieldConstraints.ipady = 5;
		passwordTextfieldConstraints.insets = new Insets(10, 0, 10, 0);
		mainPanel.add(password, passwordTextfieldConstraints);
		
		GridBagConstraints button1Constraints = new GridBagConstraints();
		button1Constraints.weightx = 0.2;
		button1Constraints.gridx = 0;
		button1Constraints.gridy = 2;
		button1Constraints.ipadx = 5;
		button1Constraints.ipady = 5;
		button1Constraints.insets = new Insets(10, 0, 10, 0); 
		mainPanel.add(button1, button1Constraints);
		
		button1.addActionListener(this);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String myusername = String.valueOf(username.getText());
		String mypassword = String.valueOf(password.getPassword()); 
		
		if(db.accountCheck(myusername, mypassword)) {
			JOptionPane.showMessageDialog(this, "Welcome");
		}
		else {
			JOptionPane.showMessageDialog(this, "Invalid Password");
		}
		
	}
}
