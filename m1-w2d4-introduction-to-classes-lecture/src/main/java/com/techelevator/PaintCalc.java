package com.techelevator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PaintCalc { //command line application that lets you calculate paint

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		List<Rectangle> allWalls = new ArrayList<>();//need so you can just add to rectangle created below
		while(true) {
			
			System.out.println();
			System.out.println("[1] Add a wall");
			System.out.println("[2] Calculate paint required (and Exit)");
			System.out.print("Please choose >>> ");
			String userChoice = scan.nextLine();
			
			System.out.println();
			
			if(userChoice.equals("1")) {
				
				System.out.print("Enter wall height >>> ");
				int height = Integer.parseInt(scan.nextLine());
				System.out.print("Enter wall width >>> ");
				int width = Integer.parseInt(scan.nextLine());
				int area = height * width;
				
				//w/height and width, create a new rectangle
				Rectangle wall = new Rectangle(height, width); //height and width given by user
				allWalls.add(wall);
				
				System.out.println("Added "+wall.getHeight() + "x" + wall.getLength() + " wall - " + wall.getArea() + " square feet");
				//object gone after ran because it's out of scope => use a list, of rectangle objects, outside of while statement
				
				
			} else if(userChoice.equals("2")) {
				
				int totalArea = 0; // needs to be above for loop
				for(Rectangle currentWall : allWalls)
				System.out.println("Wall: "+currentWall.getHeight() + "x" + currentWall.getLength() + " wall - " + currentWall.getArea() + " square feet");
				System.out.println("Total Area: "+totalArea+" square feet");
				
				// Here we need to sum up the areas of all walls that have been entered
				for(Rectangle currentWall : allWalls) {
				System.out.println("Wall: "+currentWall.getHeight() + "x" + currentWall.getLength() + " wall - " + currentWall.getArea() + " square feet"); // PROTOTYPE ONLY!!!
				}
				
				
				
				// 1 gallon of paint covers 400 square feet
				float gallonsRequired = (float)totalArea / 400;
				System.out.println("Paint Required: "+gallonsRequired+" gallons");
				
				System.exit(0); // Causes the program to end
			}
		}
	}

}
