package com.wakaleo.dojo.melbourne1.checkout;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * A description goes here.
 * User: john
 * Date: 18/09/13
 * Time: 7:46 PM
 */
public class WhenGettingItemPrice {

    @Test
    public void price_rule_knows_the_price_for_an_item() throws UnknownItemCodeException {
        PriceRules rules = new PriceRules();
        rules.tell("AA", 3);
        assertThat(rules.getPriceFor("AA"), is(3));
    }

    @Test(expected=UnknownItemCodeException.class)
    public void price_rule_cannot_price_an_unknown_item() throws UnknownItemCodeException {
        PriceRules rules = new PriceRules();
        rules.getPriceFor("AA");
    }
}
