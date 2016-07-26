package com.androidclass.model;

import java.util.HashMap;

/**
 * Created by jsingh on 7/26/16.
 */
public class StockService {

    private HashMap<String, Stock> stockList = new HashMap<String, Stock>();

    public StockService() {

        Stock s = new Stock();
        s.setSymbol("MSFT");
        s.setName("Microsoft");
        s.setPrice(24.50d);
        stockList.put(s.getSymbol(), s);

        Stock s1 = new Stock();
        s1.setSymbol("AMZN");
        s1.setName("Amazon");
        s1.setPrice(158.25d);
        stockList.put(s1.getSymbol(), s1);

        Stock s2 = new Stock();
        s2.setSymbol("GOOG");
        s2.setName("Google");
        s2.setPrice(203.25d);
        stockList.put(s2.getSymbol(), s2);


    }


    public Stock get(String symbol) {

        return stockList.get(symbol);
    }
}
