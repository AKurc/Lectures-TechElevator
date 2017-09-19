package com.techelevator.farm;

public class Chicken extends Animal {
	
//	public Chicken() {
//		setName("Chicken");
////		setSound("cluck!"); //change from "cluck!"
//		setPrice(30);
//	}
//	
//	//make a new method to return the sound
//	protected String makeSound() {
//		return "cluck!";
//	}
	private int eggsLaidPerDay;
	public Chicken(String name, int price) {
		super(name, price); 
		this.eggsLaidPerDay = eggsLaidPerDay;
	}
	
	public void layEgg() {
		System.out.println("Chicken laid an egg!");
	}

}