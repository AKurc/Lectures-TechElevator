package com.techelevator.farm;

public class Cat extends Animal {
//
//	public Cat(String name, int price) {
//		setName("Cat");
//		setPrice(-10);
//	}

	public Cat(String name, int price) {
		super(name, price); 
	}
	
	@Override
	public String makeSound() {
		return "meow!";
	}

}
