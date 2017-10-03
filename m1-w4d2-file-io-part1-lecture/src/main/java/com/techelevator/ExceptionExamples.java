package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.techelevator.exceptions.OverdraftException;

public class ExceptionExamples {

	public static void main(String[] args) throws OverdraftException {
		int[] nums = null; //can't declare this in the try block because blocks have a scope
		// => declare outside and define inside
	
	try {	
		nums = getArray();
	}catch (ArrayIndexOutOfBoundsException ex) {
		System.out.println(ex.getMessage());
	}
	if(nums != null) {
		
//		try {
//			nums[1] = 42; //index 2 gets changed to 42-- does each line of code until it hits an error
//			nums[3] = 18; //to catch this exception- wrap in a try
//			nums[0] = 99; //so this line never happens because of the error above it
//		} catch(ArrayIndexOutOfBoundsException ex) { //more specific here, the better
//		} catch(FileNotFoundException ex) { //never happens because this exception never gets thrown here
//			System.out.println(ex.getMessage()); //can get message even though java created it- says 3 => can figure out that it's index 3
//		} //next catch would go here on this block
		
		System.out.println(nums[0] + " " + nums[1] + " " + nums[2]);
		}
	
	//using overdraftException
		try {
			System.out.println(withdraw(50.00, 100.00));
			System.out.println(withdraw(100.00, 50.00));//CheckedException is an exception that must be handled-- handle with a throw declaration OR
			// handle with a try/catch
			// (UncheckedException is youdon't have to handle it, but you can --example: arrayIndexOutOfBounds)
		} catch (OverdraftException e) {
			System.out.println(e.getMessage());
//			throw e; //want parent to know about the Exception-- really don't use all that often-- essentially just used
			//if you already know of an instance where you'll need to know that the Exception was used
		}
		//FILE IO-- about 50 diff ways to do it in java
		//just putting it in the main method because it'll work here
		File readMe = new File("/Users/annakurchak/ScannerEx");
		System.out.println(readMe.exists());
		
		try(Scanner input = new Scanner(readMe)) { //try with resources =>trying with Scanner resource-- everything we do lives within block
			while(input.hasNextLine()) { //to file- do you have another file we can read
				String line = input.nextLine(); //DO THE FOLLOWING IN CAPSTONE
				if(! line.equals("")) { //makes sure you're covering all of the empty spaces you imported too
					String[] parts = line.split("\\|"); //assuming you're importing a file with all of these pieces and characters
					String date = parts[0];
					String name = parts[1];
					String email = parts[3];
					System.out.println(line); //tell system to keep printing while it has lines
				}
			}
		}catch (FileNotFoundException e) {
			System.out.println("Your file doesn't exist.");
		}
		
		System.out.println("Done.");
	
	}
	public static int[] getArray() { //move all the code above into below
		int[] nums = {1, 2, 3};
//		try {
			nums[1] = 42; 
			nums[2] = 18; //nums[3] = 18;
			nums[0] = 99; 
//		} catch(ArrayIndexOutOfBoundsException ex) { //more specific here, the better
//			System.out.println(ex.getMessage());
		return nums;
	}
	/* OverdraftException is a "checked exception" (i.e. it is a subclass of java.lang.Exception)
	 * so we need to either catch it or declare that it is thrown.  This method declares that 
	 * it can throw an OverdraftException using the "throws" keyword */
	public static double withdraw(double currentBalance, double amountToWithdraw) throws OverdraftException { //throws is a clause
		//throws is keyword letting callers of a method know that we throw an Exception AND they have to handle it
		double newBalance;
		if(amountToWithdraw <= currentBalance) {
			newBalance = currentBalance - amountToWithdraw;
		} else {
			throw new OverdraftException("The requested withdrawal amount is greater than the current balance", Math.abs(currentBalance - amountToWithdraw));
		} //nothing returns because of exception thrown
		return newBalance;		
	}

}
