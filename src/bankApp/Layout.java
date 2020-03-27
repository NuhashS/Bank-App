package bankApp;

import javax.swing.*;
import java.awt.*;

public class Layout extends JFrame{

	public Layout(String title) {
		super(title);
		this.setSize(700, 100);
	 	this.setLocation(100, 100);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton button1 = new JButton("OK");
		JButton button2 = new JButton("Cancel");
		TextField username = new TextField("", 20);
		
		Container mainContainer = this.getContentPane();
		mainContainer.setLayout(new BorderLayout(500,500));
		mainContainer.setBackground(Color.YELLOW);
		
		JPanel topPanel = new JPanel();
		topPanel.setLayout(new FlowLayout());
		topPanel.add(username);
		mainContainer.add(topPanel, BorderLayout.NORTH);
		
		JPanel bottomPanel = new JPanel();
		bottomPanel.setLayout(new FlowLayout(1,0,5));
		bottomPanel.add(button1);
		bottomPanel.add(button2);
		mainContainer.add(bottomPanel, BorderLayout.SOUTH);
	}
}
