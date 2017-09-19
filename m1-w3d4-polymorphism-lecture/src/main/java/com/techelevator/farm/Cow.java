package com.techelevator.farm;

public class Cow extends Animal {
		public Cow(String name, int price) {
			super(name, price); 
		}
	protected String makeSound() {
		return "moo!";
	}
}