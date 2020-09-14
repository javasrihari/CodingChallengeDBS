package com.dbs.coding.challenge;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class QuoteServiceImpl {

	private  Map<String, Quote> quoteDataCache = new HashMap<>();
	private  Map<String, Quote> frquentQuotes = new HashMap<>();
	private Date frquentQuotesUpdatedDate = Calendar.getInstance().getTime();;

	public int getQuoteDataCacheSize() {
		return quoteDataCache.size();
	}

	public void submitQuote(Quote quote) {

		if (quote == null || quote.getSymbol() == null)
			throw new RuntimeException("Invalid quote");

		String key = quote.getSymbol();
		Quote historyQuote = quoteDataCache.get(key);
		if (historyQuote != null) {
			double changeAmount = Math.abs(quote.getPriceTraded() - historyQuote.getPriceTraded());
			String changeDirection = "down";
			if (quote.getChangeAmount() > historyQuote.getChangeAmount())
				changeDirection = "up";

			quote.setChangeAmount(changeAmount);
			quote.setChangeDirection(changeDirection);
		}

		Instant instant = Instant.now();
		quote.setTimestamp(instant.toString());
		
		quoteDataCache.put(key, quote);

		Date currentDate = Calendar.getInstance().getTime();
		long diffInMillies = Math.abs(currentDate.getTime() - frquentQuotesUpdatedDate.getTime());
		long diff = TimeUnit.MINUTES.convert(diffInMillies, TimeUnit.MILLISECONDS);
		if (diff > 10) {
			frquentQuotes = new HashMap<>();
			frquentQuotesUpdatedDate = currentDate;
		}
		frquentQuotes.put(key, quote);


	}

	public List<Quote> queryFrquentQuotes() {
		List<Quote> quoteList = new ArrayList<>(frquentQuotes.values());
		return quoteList;
	}
}
