package com.techelevator.cardgame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	private List<Card> cards = new ArrayList<>();  //cards is instance variable in deck object
	//create all cards and fill up list when deck is created
	//cards is instance variable
	
	public Deck() {
		//array of rank and array of suits-- lives on class, but not object => back to static
		//for loops with every suit and every rank
		for(String suit : Card.POSSIBLE_SUITS) {
			for(String rank : Card.POSSIBLE_RANKS) {
				cards.add(new Card(suit, rank));
			}
		}
	}
	
	public void shuffle() { //shuffle doesn't return anything-- add shuffle to deck class b/c data to do this lives here
		Collections.shuffle(cards); //so .shuffle changes list
	}
	
	
//deal a new, single card off deck
	public Card draw() {
		return cards.remove(0);
	}
	
	//deligation method-- call flip on deck to call flip on cards-- gives ability to print all values out again-- creates method on deck
	public void flip() {
		for(Card playingCard : cards){
			playingCard.flip();
		}
	}
	
//deligation method-- calling another method-- to allow size of list to be seen
	public int size() {
		return cards.size();
	}
	
	//add a 2 string method to deck-- string representation of order of cards in deck- way to look at all cards
	public String toString() {
		String result = "";  //need to define string you're building on
		for(Card playingCard : cards) {
			result += playingCard + " ";
		}
		return result;
}
}
