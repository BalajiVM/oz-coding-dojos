package com.wakaleo.dojo.melbourne1.checkout;

import java.util.HashMap;
import java.util.Map;

public class Checkout {
    private final PriceRules priceRules;
    private int numItems = 0;

    private Map<String, Integer> itemCountMap = new HashMap<String, Integer>();
    public Checkout(PriceRules priceRules) {
        this.priceRules = priceRules;
    }

    public void scan(String itemCode) {
        numItems++;

        itemCountMap.put(itemCode, countOf(itemCode)+1);
    }

    public int numItemsScanned() {
        return numItems;
    }

    public int calculateTotal() throws UnknownItemCodeException {
        int total = 0;
        for (String itemCode: itemCountMap.keySet())  {
            int count = countOf(itemCode);
            int price = priceRules.getPriceFor(itemCode);
            total += (count * price);
        }
        return total;
    }

    public int countOf(String itemCode) {

        return hasItem(itemCode) ? itemCountMap.get(itemCode) : 0;
    }

    private boolean hasItem(String itemCode) {
        return itemCountMap.containsKey(itemCode);
    }
}
