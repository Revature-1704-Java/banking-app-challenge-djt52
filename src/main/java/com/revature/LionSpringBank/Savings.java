package com.revature.LionSpringBank;

import java.io.*;
import java.util.Scanner;
import java.time.LocalDate;
import static java.lang.Math.toIntExact;

//A Savings type of account that utilizes interest over time
public class Savings extends Account {
	
	public float interest;
	
	public Savings(float interest) {
		this.interest = interest;
		System.out.println("Please enter a name for this account");
		Scanner sc = new Scanner(System.in);
		name = sc.nextLine();
		System.out.println("Please enter a password for this account");
		String pass1 = sc.nextLine();
		System.out.println("Please confirm password for this account");
		String pass2 = sc.nextLine();
		if(pass1.equals(pass2)) {
			write(pass1,0);
		} else {
			new Savings(interest);
		}
		System.out.println("Account created");
	}
	
	
	public Savings(String name, float interest) {
		this.name = name;
		this.interest = interest;
		System.out.println("Account created");
	}
	
	
	//Note: interest has not really been tested as it takes place over multiple days
	public int interest(int amm) {
		try (FileReader fr = new FileReader("src/resources/" + name + ".txt")) {
			StringBuilder builder = new StringBuilder();
			int i;
			for(int c = 0;c < 4;c++) {
				while((i = fr.read()) != ';') {
				}
			}
			while((i = fr.read()) != ';') {
				builder.append((char) i);
			}
			long d1 = Long.parseLong(builder.toString());
			long d2 = LocalDate.now().toEpochDay();
			long d3 = d1 - d2;
			return (int)((d3/365) * interest);
		} catch(FileNotFoundException ex) {
			System.out.println("Not with correct interest");
		} catch(IOException ex) {
				ex.printStackTrace();
		}
		return amm;
	}
	
	public void write(String pass,int balance) {
		try (FileWriter fw = new FileWriter("src/resources/" + name + ".txt")){
			fw.write("Savings;");
			fw.write(pass + ";");
			fw.write(balance + ";");
			fw.write(interest + ";");
			fw.write(((int) (LocalDate.now().toEpochDay())) + ";");
			fw.close();
		} catch(IOException ex) {
			ex.printStackTrace();
		}
	}
}