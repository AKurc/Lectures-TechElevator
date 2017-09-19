package com.techelevator;

public class Tester {

	public static void main(String[] args) {
		Rectangle square = new Rectangle();
		square.setLength(5);
		square.setHeight(5);
		
		square.h = 90;
		square.height = -1000; //now treated like an int
		
		System.out.println(square.getLength());
		
		Rectangle wall = new Rectangle(20, 35); //rectangle on L side says this is going to hold a rectangle object- says what type variable is
		System.out.println(wall.getArea()); //area is a derived value

		
		if(square.isLargerThan(otherWall)) { //isLargerThan takes a rectangle at argument 1
			System.out.println("Square is bigger");
		} else {
			System.out.println("Square is not bigger");
		}
	}

}
