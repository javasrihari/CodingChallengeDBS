package com.dbs.coding.challenge;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.dbs.coding.challenge.Quote;
import com.dbs.coding.challenge.QuoteServiceImpl;

class QuoteServiceImplTest {

	@Test
	void testSubmitQuote() {
		Quote quote = new Quote();
		quote.setSymbol("D05.SI");
		quote.setSharesTraded("5k");
		quote.setPriceTraded(26.55);

		QuoteServiceImpl testClass = new QuoteServiceImpl();
		testClass.submitQuote(quote);
		int size = testClass.getQuoteDataCacheSize();
		assertEquals(1, size);
	}

	@Test
	void testSubmitQuote_changeDirection() {
		Quote quote1 = new Quote();
		quote1.setSymbol("D05.SI");
		quote1.setSharesTraded("5k");
		quote1.setPriceTraded(26.55);

		Quote quote2 = new Quote();
		quote2.setSymbol("D05.SI");
		quote2.setSharesTraded("5k");
		quote2.setPriceTraded(25.55);

		QuoteServiceImpl testClass = new QuoteServiceImpl();
		testClass.submitQuote(quote1);
		testClass.submitQuote(quote2);
		assertEquals(1, quote2.getChangeAmount());
		assertEquals("down", quote2.getChangeDirection());

	}

	
	@Test
	void testQueryFrquentQuotes() {

		//Given
		List<Quote> quotes = new ArrayList<>();

		for (int i = 0; i < 10; i++) {
			Quote quote1 = new Quote();
			quote1.setSymbol("D05.SI");
			quote1.setSharesTraded("5k");
			quote1.setPriceTraded(20.55 + i);
			quotes.add(quote1);
		}
		
		Quote quote2 = new Quote();
		quote2.setSymbol("A01.DI");
		quote2.setSharesTraded("1k");
		quote2.setPriceTraded(15.55);
		quotes.add(quote2);
		
		//When
		QuoteServiceImpl testClass = new QuoteServiceImpl();
		for (Iterator<Quote> iterator = quotes.iterator(); iterator.hasNext();) {
			Quote quote = iterator.next();
			testClass.submitQuote(quote);
		}
		List<Quote> results=	testClass.queryFrquentQuotes();

		
		//Then
		assertEquals(2, results.size());

	}

}
