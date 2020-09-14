package com.dbs.coding.challenge;

public class Quote {

	private String timestamp;
	private String symbol;
	private String sharesTraded;
	private double priceTraded;
	private String changeDirection;
	private double changeAmount;

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getSharesTraded() {
		return sharesTraded;
	}

	public void setSharesTraded(String sharesTraded) {
		this.sharesTraded = sharesTraded;
	}

	public double getPriceTraded() {
		return priceTraded;
	}

	public void setPriceTraded(double priceTraded) {
		this.priceTraded = priceTraded;
	}

	public String getChangeDirection() {
		return changeDirection;
	}

	public void setChangeDirection(String changeDirection) {
		this.changeDirection = changeDirection;
	}

	public double getChangeAmount() {
		return changeAmount;
	}

	public void setChangeAmount(double changeAmount) {
		this.changeAmount = changeAmount;
	}

	@Override
	public String toString() {
		return "Quote [timestamp=" + timestamp + ", symbol=" + symbol + ", sharesTraded=" + sharesTraded + ", priceTraded=" + priceTraded + ", changeDirection=" + changeDirection
				+ ", changeAmount=" + changeAmount + "]";
	}

}
