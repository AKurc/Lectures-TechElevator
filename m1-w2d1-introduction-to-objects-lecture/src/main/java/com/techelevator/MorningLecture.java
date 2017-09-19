package com.techelevator;

import java.time.LocalDate;
import java.util.Date;

public class MorningLecture {

	public static void main(String[] args) {
		char[] name = new char [] {'A', 'n', 'n', 'a'};
		char[] space = new char[] {' '};
		char[] lastName = new char[] {'K', 'u', 'r', 'c', 'h', 'a', 'k'};
		
		char[] fullName = new char [name.length + space.length + lastName.length];
		
		for(int i = 0; i < name.length; i++) {
			fullName[i] = name[i];
		}
		
		for(int i = 0; i < space.length; i++) {
			fullName[i + name.length] = space[i];
		}
		for(int i = 0; i < lastName.length; i++) {
			fullName[i + name.length +space.length] = lastName[i];
		}
		System.out.println(fullName);
		
		String fullNameString = "Anna";
		
		String upperCaseName = fullNameString.toUpperCase();
		System.out.println(fullNameString.equalsIgnoreCase(upperCaseName));
		
		System.out.println(fullNameString);
		
		System.out.println("Starts with Ann " + (fullNameString.startsWith("Ann")));
		
		String choppedString = fullNameString.substring(1, fullNameString.length() - 1);
		System.out.println(choppedString);
		
		LocalDate today = LocalDate.now(); 
		//change from new LocalDate to LocalDate.now this is a method called on a class- this is a factory method//
		// factory method is a type of static method//
		// now and of most frequently used//
		
		//need LocalDate Time to get date and time//
		System.out.println(today);
		
		long rounded = Math.round(9.6);
		System.out.println(rounded);
		
		LocalDate lastWeek = today.minusDays(7);
		System.out.println(lastWeek);
	}
}
