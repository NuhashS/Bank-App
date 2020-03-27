package bankApp;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public abstract class Account implements IBaseRate{
	//List common properties for Savings and Chequing accounts
	protected double rate;
	private int sSN;
	private String firstName;
	private String lastName;
	private double balance;
	protected String accountNum;
	private static int index = 10000;
	
	//Constructor to set base properties and initialize the account
	public Account(String name, int sSN, double initDeposit) {
		String fullName[] = name.split(" ");
		this.firstName = fullName[0];
		this.lastName = fullName[1];
		this.sSN = sSN;
		this.balance = initDeposit;
		this.accountNum = setAccountNumber(this.sSN);
		setRate();	
	}
	// List common methods
	
	private String setAccountNumber(int sSN) {
		int lastTwoOfSSN = (sSN%100 - sSN%10) + sSN%10;
		int uniqueNum = index++;
	 	int randomNumber = (int)(Math.random()*Math.pow(10, 3));
		return "" + lastTwoOfSSN + uniqueNum + randomNumber;
	}
	
	public void compoundInterest() {
		double accruedInterest = balance*(rate/100);
		balance += accruedInterest;
		printBalance();
	}
	
	public abstract void setRate();
	
	public abstract long[] loginInfo();
	
	public void deposit(double amount, String myBalance){
		balance = balance + amount;
		System.out.println("Depositing $" + amount);
		if(myBalance.equals("yes")) {
			printBalance();
		}
	}
	
	public void withdraw(double amount, String myBalance){
		if(amount > balance) {
			System.out.println("Insufficient funds.");
		}
		else {
			balance = balance - amount;
			System.out.println("Withdrawing $" + amount); 
			if(myBalance.equals("yes")) {
				printBalance();
			}
		}
	}
	
	public void transfer(String fromWhere, String toWhere, double amount) {
		if(amount > balance) {
			System.out.println("Insufficient funds.");
		}
		else {
			balance = balance - amount;
			System.out.println("Tranfering $" + amount + " from " + fromWhere + " to " + toWhere);
			printBalance();
		}
	}
	
	public void printBalance() {
		System.out.println("Your balance is: $" + balance);
	}
	
	public void showInfo() {
		System.out.println("Name: " + firstName + " " + 
						lastName + "\nAccount Number: " 
						+ accountNum + "\nBalance: $" 
						+ balance + "\nRate: " + rate + "%"); 
	}
	
	public String findAccountName() {
		return firstName;
	}
}
