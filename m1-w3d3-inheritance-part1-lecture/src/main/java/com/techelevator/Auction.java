package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class Auction { //does not have an extends-- so it's superclass is Object

	protected String itemForSale; //protected still protected from the outside but subclasses have access to it
	private Bid currentHighBid;
	private List<Bid> allBids;

	public Auction(String itemForSale) { //buyoutauction has this data, but needs to be clalled on in the superclass to set values
		this.itemForSale = itemForSale;
		this.currentHighBid = new Bid("", 0);
		allBids = new ArrayList<>(); //could be put up top-- doesn't have to be inside the constructor
	}
	
	public boolean placeBid(Bid offeredBid) {
		allBids.add(offeredBid);
		boolean isCurrentWinningBid = false;
		if(offeredBid.getBidAmount() > currentHighBid.getBidAmount()) {
			currentHighBid = offeredBid;
			isCurrentWinningBid = true;
		}
		return isCurrentWinningBid;
	}
	@Override //annotation to put in to let other coders know you got this from your parent class
	//2 string method above getters/setters
	public String toString() { 
		return itemForSale + " - " + currentHighBid.getBidder() + " $" + currentHighBid.getBidAmount();
	}
	
	
	public Bid getHighBid() {
		return currentHighBid;
	}
	
	public List<Bid> getAllBids() {
		return new ArrayList<>(allBids); //makes a new arrayList, not arrayList from our object => protection against pass by reference problem
	}

	public String getItemForSale() {
		return itemForSale;
	}
}
