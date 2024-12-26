package org.example;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Client {
    private List<Trade> trades;

    public static void main(String[] args) {
        List<Trade> trades = new ArrayList<>();
        List<ShortTrade> shortTrades = new ArrayList<>();
        List<LongTrade> longTrades = new ArrayList<>();
        List<Object> objTrades = new ArrayList<>();

        Client client = new Client();
        client.addTrades(shortTrades);
    }

    public void addTrades(Collection<?> newTrades) {
        for (Object newTrade : newTrades) {
            if (newTrade instanceof  Trade) {
                trades.add((Trade) newTrade);
                continue;
            }
            throw new IllegalArgumentException("Unexpected type of object");
        }

    }

    private static class Trade {
        private int amount;
    }

    private static class ShortTrade extends Trade {
    }

    private static class LongTrade extends Trade {
    }
}