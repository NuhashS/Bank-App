package bankApp;

import javax.swing.*;
import java.awt.*;

public class Layout extends JFrame{

	public Layout(String title) {
		super(title);
		this.setSize(400, 300);
	 	//this.setLocation(100, 100);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		JButton button1 = new JButton("Login");
		JTextField username = new JTextField("", 15);
		//TextPrompt usernameText = new TextPrompt("Account/Card Number", username);
		JPasswordField password = new JPasswordField(15);
		
		Container mainPanel = this.getContentPane();
		mainPanel.setLayout(new GridBagLayout());
		
		GridBagConstraints usernameTextfieldConstraints = new GridBagConstraints();
		//usernameTextfield.fill = GridBagConstraints.BOTH;
		//usernameTextfield.weightx = 1;
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
		
	}
}
