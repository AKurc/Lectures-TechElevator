package com.techelevator.cardgame;

import java.util.Arrays;

public class Card { // class names always has to be capitalized and a noun in Java
	final static public String[] POSSIBLE_SUITS = { "♠", "♣", "♥", "♦" }; //constant created to live on class card-- is static// put unicode character here!!!
	final static public String[] POSSIBLE_RANKS = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q", "K" };
	//constant goes above instance variables
	//constants always uppercase with words seperated by underscores
	//suits are strings, so this is a stringarray
	
	final private String suit; //final means that as soon as it gets a value it is locked and can't be changed inside/outside object
	final private String rank; //can declare as final and not give it a value
	
	private boolean showing = false; //starts card face down
	
	public Card(String suit, String rank) {
		if(Arrays.asList(POSSIBLE_SUITS).contains(suit) && Arrays.asList(POSSIBLE_RANKS).contains(rank)) {
			this.suit = suit;
			this.rank = rank;
		} else {
			throw new IllegalArgumentException(); //creating object out of clss// throw it means throwing an exception and letting know it's wrong
		}
		
	}
	//methods are typically verbs
	//add a two string method below
	public String toString() {
		if(showing) { //now change for when showing is true-- b/c need value to do something somewhere
			return rank + suit;
		} else {
			return "##";
		}
		
	}
	//flip changes the state of the card, so need an instance variable first
	public boolean flip(){
		showing = ! showing; //flip value so if the face is showing- true
		return showing;
	}
	
	//getters/setters verbs as well
	public String getSuit() {
		return suit;
	}
	public String getRank() {
		return rank;
	}
	public boolean isShowing() {
		return showing;
	}
	public void setShowing(boolean showing) {
		this.showing = showing;
	}
}
