package com.techelevator;


	public class Rectangle { //want instance variables that need declaring almost always after class declaration
		
		//all instance variables should only be able to be accessed by the object => private!! 
		//private so no one can change initial data
		//allow access via getters and setters
		private int length = 1; //private int length; 
		private int height = 1;

		public Rectangle() {//is default constructor that takes no arguments and does nothing but--
			//in order to create the object without initialization
			
		}
		
		//block below is the constructor-- and goes here
		public Rectangle(int length, int height) { //could change to square: Rectangle(int side)
			this.length = length; //square: this.lenght = side;
			this.height = height; //square: this.height = side;
		}
		
		
		//type this way, but usually just generate thru eclipse-- getter than setter below
		public int getLength() {
			return length; //building a buffer b/t data and someone using an object
			
		}
		
			//methods go above getters and setters
		public int getArea() { //no arguments because it should be declared elsewhere
			return length * height;
		}
		//checking which rectangle is larger than other to return true
		public boolean isLargerThan(Rectangle otherWall) {
			return this.getArea() > otherWall.getArea();
		}
		
		//overloading a method below-- takes diff arguments and applies them in a diff way
		public boolean isLargerThan(int length, int height) {
			return this.getArea() > (length * height);
		}
		
		
	//generated getter/setters via eclipse below
		public int getHeight() {
			return height;
		}
		public void setHeight(int height) {
			if(height > 0) {
				this.height = height;
			}
		}
//generates an initial representation of what a rectangle is like is a string
//R click in window-- source-- generate a string
//this is a "two-string method" that java calls
//same thing as "currentWall+" 
		@Override //method overrides another method
		public String toString() {
			return length + "x" + height; //make this whatever you want to give object a representation of a string
		}
}