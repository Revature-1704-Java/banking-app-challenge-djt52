package com.revature.LionSpringBank;

import java.io.*;
import java.util.Scanner;

//The class that contains methods for all types of accounts
//Abstract methods need to be specified by child account types
public abstract class Account {
	
	 protected String name;
	
	
	public void withdrawal() {
		int i;
		StringBuilder builder = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		String command = "";
		try (FileReader fr = new FileReader("src/resources/" + name + ".txt")) {
			while((i = fr.read()) != ';') {
			}
			while((i = fr.read()) != ';') {
				builder.append((char) i);
			}
			int count = 0;
			boolean passed = false;
			while(!passed && count < 5) {
				count++;
				System.out.println("Please enter your password");
				String pass = sc.nextLine();
				if(pass.equals(builder.toString())) {
					passed = true;
					boolean processed = false;
					StringBuilder builder2 = new StringBuilder();
					int i2;
					while((i2 = fr.read()) != ';') {
						builder2.append((char) i2);
					}
					while(!processed) {
						System.out.println("Please enter an ammount to withdraw");
						command = sc.nextLine();
						int accamm = Integer.parseInt(builder2.toString());
						accamm = interest(accamm);
						int wamm = Integer.parseInt(command);
						if(wamm < accamm && wamm > 0) {
							processed = true;
							System.out.println(wamm + " dollars have been withdrawn from account " + name);
							accamm = accamm - wamm;
							write(pass,accamm);
						} else {
							System.out.println("Invalid withdrawal amount");
						}
					}
				} else {
					System.out.println("Incorrect password, attempts remaining: " + (5 - count));
				}
			}
		} catch(FileNotFoundException ex) {
			System.out.println("Incorrect account name");
		} catch(IOException ex) {
				ex.printStackTrace();
		}
	}
	
	public void deposit() {
		int i;
		StringBuilder builder = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		String command = "";
		try (FileReader fr = new FileReader("src/resources/" + name + ".txt")) {
			while((i = fr.read()) != ';') {
			}
			while((i = fr.read()) != ';') {
				builder.append((char) i);
			}
			int count = 0;
			boolean passed = false;
			while(!passed && count < 5) {
				count++;
				System.out.println("Please enter your password");
				String pass = sc.nextLine();
				if(pass.equals(builder.toString())) {
					passed = true;
					boolean processed = false;
					StringBuilder builder2 = new StringBuilder();
					int i2;
					while((i2 = fr.read()) != ';') {
						builder2.append((char) i2);
					}
					while(!processed) {
						System.out.println("Please enter an ammount to deposit");
						command = sc.nextLine();
						int accamm = Integer.parseInt(builder2.toString());
						accamm = interest(accamm);
						int wamm = Integer.parseInt(command);
						processed = true;
						System.out.println(wamm + " dollars have been deposited into account " + name);
						accamm = accamm + wamm;
						write(pass,accamm);

					}
				} else {
					System.out.println("Incorrect password, attempts remaining: " + (5 - count));
				}
			}
		} catch(FileNotFoundException ex) {
			System.out.println("Incorrect account name");
		} catch(IOException ex) {
				ex.printStackTrace();
		}
	}
	public void balance() {
		int i;
		StringBuilder builder = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		String command = "";
		try (FileReader fr = new FileReader("src/resources/" + name + ".txt")) {
			while((i = fr.read()) != ';') {
			}
			while((i = fr.read()) != ';') {
				builder.append((char) i);
			}
			int count = 0;
			boolean passed = false;
			while(!passed && count < 5) {
				count++;
				System.out.println("Please enter your password");
				String pass = sc.nextLine();
				if(pass.equals(builder.toString())) {
					passed = true;
					StringBuilder builder2 = new StringBuilder();
					int i2;
					while((i2 = fr.read()) != ';') {
						builder2.append((char) i2);
					}
					int accamm = Integer.parseInt(builder2.toString());
					accamm = interest(accamm);
					System.out.println(name + " account balance is: " + accamm);
				} else {
					System.out.println("Incorrect password, attempts remaining: " + (5 - count));
				}
			}
		} catch(FileNotFoundException ex) {
			System.out.println("Incorrect account name");
		} catch(IOException ex) {
				ex.printStackTrace();
		}
	}
		
	
	
	public abstract int interest(int amm);
	
	public abstract void write(String pass,int balance);
}