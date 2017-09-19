package com.techelevator.farm;

public abstract class Animal implements Singable, Sellable { //rename via R click-- Refactor-- rename 
	//abstract class means that it doesn't allow objects to be created from it-- usually not on subclasses
	
	private String name;
	private int price;
	private boolean sleeping; //putting this variable in the animal class because all animals sleep
	
	//since an animal has a name and a price-- put a constructor in to force all the subclasses to create a constructor that takes a name and price
	//CONSTRUCTORS ARE NOT INHERITED - they're there to get data into the instance variables
	//constructors end up being short-hand for setters
	public Animal(String name, int price) {
		this.name = name; //usually put variables in descending order of importance
		this.price = price; 
	}
	
	public String getName( ) {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public final String getSound() { //final keyword is a method that cannot be overridden
		//redefined whether sleeping or not as to return
		if(sleeping){
			return "Zzzzz...";
		} else {
		return makeSound(); //making a method abstract (just like a class!!!!)
		}
	}
	protected abstract String makeSound(); //abstract says a subclass MUST implement this method-- abstract trickles down
//since locking down specific sounds- remove setSound method-- causes problems in chx and cow
	//protected so any other bits of inheritance structure can call it
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public boolean isSleeping() {
		return sleeping;
	}

	public void setSleeping(boolean sleeping) {
		this.sleeping = sleeping;
	}
	
	
}