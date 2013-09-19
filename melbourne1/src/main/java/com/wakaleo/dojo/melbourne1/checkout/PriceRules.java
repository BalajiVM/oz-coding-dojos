package com.wakaleo.dojo.melbourne1.checkout;

import java.util.HashMap;
import java.util.Map;

/**
 * A description goes here.
 * User: john
 * Date: 18/09/13
 * Time: 6:54 PM
 */
public class PriceRules {
    private Map<String, Integer> itemToPriceMap = new HashMap<String, Integer>();

    public void tell(String itemCode, int price) {
        itemToPriceMap.put(itemCode, price);


    }

    public int getPriceFor(String itemCode) throws UnknownItemCodeException {
        if (!itemToPriceMap.containsKey(itemCode))   {
            throw new UnknownItemCodeException();
        }
        return itemToPriceMap.get(itemCode);

    }
}
