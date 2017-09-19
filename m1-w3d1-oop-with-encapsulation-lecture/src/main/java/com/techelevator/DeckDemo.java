package com.techelevator;

import com.techelevator.cardgame.Card;
import com.techelevator.cardgame.Deck;

public class DeckDemo {
	public static void main(String[] args) {
//		Card fiveOfHearts = new Card("h", "5");
//		System.out.println(fiveOfHearts);
//		
//		fiveOfHearts.flip();
//		System.out.println(fiveOfHearts);
//		
		Deck myPlayingDeck = new Deck();
		myPlayingDeck.shuffle(); //shuffle here-- since it doesn't return anything
		
		myPlayingDeck.flip(); //gives back ability to print everything out
		System.out.println(myPlayingDeck);
		
		//create new deck, flip it, print it out, now draw a new card
		Card drawnCard = myPlayingDeck.draw();
		System.out.println(drawnCard);
		System.out.println(myPlayingDeck);
	}
}
