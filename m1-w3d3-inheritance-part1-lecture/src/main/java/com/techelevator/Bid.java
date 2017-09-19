package com.techelevator;

public class Bid { //a Bid is a Java Bean = a class that holds data and has getters/setters
	//class is a complex object => holds multiple other data types
	//has a bidder and a bidAmount

	private String bidder;
	private int bidAmount;

	public Bid(String bidder, int bidAmount) {
		this.bidder = bidder;
		this.bidAmount = bidAmount;
	}
	
	public String getBidder() {
		return bidder;
	}
	
	public int getBidAmount() {
		return bidAmount;
	}
}
