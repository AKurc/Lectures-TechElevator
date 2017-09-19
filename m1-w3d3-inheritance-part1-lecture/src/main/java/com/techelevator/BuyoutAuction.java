package com.techelevator;

/**
 * This class models an auction with an additional set price (the 'buyout' price) that any bidder 
 * can accept at any time during the auction, thereby immediately ending the auction and winning 
 * the item.  If no bidder chooses to utilize the buyout option before the end of bidding the 
 * highest bidder wins.
 */
public class BuyoutAuction extends Auction {

	private int buyoutPrice;

	/**
	 * @param description the description of the auction
	 * @param buyoutPrice the set price that immediately wins the auction
	 */
	public BuyoutAuction(String itemForSale, int buyoutPrice) {
		super(itemForSale); // super calls the superclass' constructor- only goes up one level
//		this.itemForSale = "nothing"; //not allowed when it's set to private in supercode
		this.buyoutPrice = buyoutPrice;
	}
	
	/*
	 * This class overrides the default placeBid behavior of the parent class.
	 * If the offeredBid meets or exceeds the buyout price, the bid is set
	 * to the buyout price and all future bids are ignored.
	 */
	@Override
	public boolean placeBid(Bid offeredBid) { //same signature as superclass- if it wasn't it wouldn't be overriding it
		boolean isCurrentWinningBid = false; //false because assuming not current winning bid unless told otherwise
		if(getHighBid().getBidAmount() < buyoutPrice) {
			if(offeredBid.getBidAmount() >= buyoutPrice) { //they just bought it
				offeredBid = new Bid(offeredBid.getBidder(), buyoutPrice); //being nice and didn't take the extra money over the buyit price
			}
			isCurrentWinningBid = super.placeBid(offeredBid); //need super to call the superclass's constructor
		}
		return isCurrentWinningBid;
	}
	@Override //R click- source- override 
	public String toString() {
		
//		return super.toString(); //start with then modify to below
		return "Reserve $" + buyoutPrice + " | " + super.toString();
	}
	
	//override 2 string to add more to string when it's reserved

	public int getBuyoutPrice() { //specific to subclass
		return buyoutPrice;
	}

}
