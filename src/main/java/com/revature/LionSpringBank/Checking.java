package com.revature.LionSpringBank;

import java.io.*;
import java.util.Scanner;


public class Checking extends Account {
	
	public Checking() {
		System.out.println("Please enter a name for this account");
		Scanner sc = new Scanner(System.in);
		name = sc.nextLine();
		System.out.println("Please enter a password for this account");
		String pass1 = sc.nextLine();
		System.out.println("Please confirm password for this account");
		String pass2 = sc.nextLine();
		if(pass1.equals(pass2)) {
			write(pass1,0);
		System.out.println("Account created");
		}
	}
	
	public Checking(String name) {
		this.name = name;
	}
	
	public int interest(int camm) {
		return camm;
	}
	
	
	public void write(String pass,int balance) {
		try (FileWriter fw = new FileWriter("src/resources/" + name + ".txt")){
			fw.write("Checking;");
			fw.write(pass + ";");
			fw.write(balance + ";");
			fw.close();
		} catch(IOException ex) {
			ex.printStackTrace();
		}
	}
	
}