package com.revature.LionSpringBank;

import java.io.*;
import java.util.Scanner;
import java.time.LocalDate;

//The main class that acts as an interface between the user and accounts
public class BankSystem {
	
	//apr interest
	private float interest = 1.04f;
	
	public static void main(String[] args) {
		System.out.println("Welcome to the LionSpring Banking Application");
		BankSystem running = new BankSystem();
		running.home();
	}
	
	public BankSystem() {
	}
	
	public void home() {
		boolean exit = false;
		Scanner sc = new Scanner(System.in);
		String command = "";
		while(!exit) {
			System.out.println("Would you like to make a deposit, make a withdrawal, check balance, or open a new account?");
			command = sc.nextLine();
			if(command.equals("deposit") || command.equals("Deposit") || command.equals("d")) {
				deposit();
			} else if(command.equals("withdraw") || command.equals("withdrawal") || command.equals("w") ||
				command.equals("Withdraw") || command.equals("Withdrawal")) {
				withdrawal();
			} else if(command.equals("New Account") || command.equals("new account") || command.equals("a") ||
				command.equals("account") || command.equals("Account")) {
				account();
			} else if(command.equals("Check Balance") || command.equals("check balance") || command.equals("b") ||
				command.equals("balance") || command.equals("Balance")) {
				balance();
			} else if(command.equals("q") || command.equals("exit") || command.equals("Exit") ||
				command.equals("Quit") || command.equals("q")) {
				exit = true;
			} else {
				System.out.println("Please insert a valid command.");
			}
		}
	}
	
	public void withdrawal() {
		boolean exit = false;			
		Scanner sc = new Scanner(System.in);
		Account acc = null;
		while(!exit) {
			System.out.println("Please enter your account name");
			String command = sc.nextLine();
			String accname = command;
			try (FileReader fr = new FileReader("src/resources/" + command + ".txt")) {
				StringBuilder builder = new StringBuilder();
				int i;
				while((i = fr.read()) != ';') {
					builder.append((char) i);
				}
				if(builder.toString().equals("Savings")) {
					exit = true;
					acc = new Savings(accname,interest);
					fr.close();
					acc.withdrawal();
				} else if(builder.toString().equals("Checking")) {
					exit = true;
					acc = new Checking(accname);
					fr.close();
					acc.withdrawal();
				}
			} catch(FileNotFoundException ex) {
				System.out.println("Incorrect account name");
			} catch(IOException ex) {
					ex.printStackTrace();
			}
		}
	}
	
	public void deposit() {
		boolean exit = false;			
		Scanner sc = new Scanner(System.in);
		Account acc = null;
		while(!exit) {
			System.out.println("Please enter your account name");
			String command = sc.nextLine();
			String accname = command;
			try (FileReader fr = new FileReader("src/resources/" + command + ".txt")) {
				StringBuilder builder = new StringBuilder();
				int i;
				while((i = fr.read()) != ';') {
					builder.append((char) i);
				}
				if(builder.toString().equals("Savings")) {
					exit = true;
					acc = new Savings(accname,interest);
					fr.close();
					acc.deposit();
				} else if(builder.toString().equals("Checking")) {
					exit = true;
					acc = new Checking(accname);
					fr.close();
					acc.deposit();
				}
			} catch(FileNotFoundException ex) {
				System.out.println("Incorrect account name");
			} catch(IOException ex) {
					ex.printStackTrace();
			}
		}
	}
	
	public void balance() {
		boolean exit = false;			
		Scanner sc = new Scanner(System.in);
		Account acc = null;
		while(!exit) {
			System.out.println("Please enter your account name");
			String command = sc.nextLine();
			String accname = command;
			try (FileReader fr = new FileReader("src/resources/" + command + ".txt")) {
				StringBuilder builder = new StringBuilder();
				int i;
				while((i = fr.read()) != ';') {
					builder.append((char) i);
				}
				if(builder.toString().equals("Savings")) {
					exit = true;
					acc = new Savings(accname,interest);
					fr.close();
					acc.balance();
				} else if(builder.toString().equals("Checking")) {
					exit = true;
					acc = new Checking(accname);
					fr.close();
					acc.balance();
				}
			} catch(FileNotFoundException ex) {
				System.out.println("Incorrect account name");
			} catch(IOException ex) {
					ex.printStackTrace();
			}
		}
	}
		
	
	public void account() {
		System.out.println("Which type of account would you like to create?");
		Scanner sc = new Scanner(System.in);
		String type = sc.nextLine();
		Account acc = null;
		if(type.equals("Checking") || type.equals("checking") || type.equals("c")) {
			acc = new Checking();
		} else if(type.equals("Savings") || type.equals("savings") || type.equals("s")) {
			acc = new Savings(interest);
		} else if(type.equals("q") || type.equals("exit") || type.equals("Exit") ||
				type.equals("Quit") || type.equals("q")) {
			home();
		} else {
			System.out.println("Invalid account type");
			account();
		}
	}
	
	public void setInterest(float i) {
		interest = i;
	}
	
	public float getInterest() {
		return interest;
	}
}
			
			
			
		