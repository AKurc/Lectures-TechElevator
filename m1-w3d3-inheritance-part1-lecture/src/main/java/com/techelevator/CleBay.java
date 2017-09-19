package com.techelevator; //packages are the same, that's how clebay knows how to work with the auction superclass

import java.util.ArrayList;
import java.util.List;

public class CleBay {

	public static void main(String[] args) {
//		Auction bowlingBallAuction = new Auction("Bowling Ball");
//		bowlingBallAuction.placeBid(new Bid("Joe", 5));
//		
//		System.out.println(bowlingBallAuction);
//		
//		bowlingBallAuction.placeBid(new Bid("Bobby", 13)); //inherited 2 string method from object class-- starts at subclass and goes up tree to find  2 string method
//		System.out.println(bowlingBallAuction);
//		
//		//create a buyout auction-- subclass
//		BuyoutAuction indiansTickets = new BuyoutAuction("Indian Tickets", 1000);
//		
//		indiansTickets.placeBid(new Bid("Joe", 2));
//		System.out.println(indiansTickets);
//		
//		indiansTickets.placeBid(new Bid("Anna", 1500));
//		System.out.println(indiansTickets);
//		
//		indiansTickets.placeBid(new Bid("Troy", 2000)); //doesn't get it because Anna already won the bid
//		System.out.println(indiansTickets);
//		
//	}

		Auction bowlingBallAuction = new Auction("Bowling Ball");
		BuyoutAuction indiansTickets = new BuyoutAuction("Indian Tickets", 1000);
		ReserveAuction superCars = new ReserveAuction("Super Cars", 750);
		
		List<Auction> allAuctions = new ArrayList<>();
		
		allAuctions.add(bowlingBallAuction);
		allAuctions.add(indiansTickets); //buyout auction gets cast to auction via upcasting
		allAuctions.add(superCars);
		
		//want all of these items-- for loop
		for(Auction a : allAuctions) {
			a.placeBid(new Bid("Joe", 500)); //still calling place bid on that object, just treated all the same as auction
//			a.getBuyoutPrice(); // doesn't even show up here because it's not in the auction superclass, only in called in buyout subclass
		}
		for(Auction a : allAuctions) {
			System.out.println(a);;
		}
		Auction tickets = indiansTickets; //allowed b/c a buyout auction is an auction (indiansTickets is variable) ==upcasting-- upcasting is implicit
		BuyoutAuction newVariable = (BuyoutAuction)tickets; //can't convert an auction to a buyout-- downcasting -- without being explicit in saying that tickets are a buyoutAuction
		//downcasting sets subclass' variable to the superclass'
		if(tickets instanceof BuyoutAuction) { //really never a reason to do this- means can design objects better
			newVariable = (BuyoutAuction)tickets;
		}
	}
}
