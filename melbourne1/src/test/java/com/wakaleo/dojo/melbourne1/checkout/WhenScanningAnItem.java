package com.wakaleo.dojo.melbourne1.checkout;

import com.sun.tools.doclets.internal.toolkit.util.TextTag;
import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * A description goes here.
 * User: john
 * Date: 18/09/13
 * Time: 6:58 PM
 */
public class WhenScanningAnItem {

    @Test
    public void checkout_should_contain_no_items_by_default() {
    Checkout checkout = new Checkout(new PriceRules());
        assertThat(checkout.numItemsScanned(), is(0));

    }

    @Test
    public void checkout_tracks_the_number_of_items_scanned() {
        Checkout checkout = new Checkout(new PriceRules());
        checkout.scan("AA");
        checkout.scan("BB");
        assertThat(checkout.numItemsScanned(), is(2));

    }
    @Test
    public void checkout_should_track_one_item() {
        Checkout checkout = new Checkout(new PriceRules());
        checkout.scan("AA");
        assertThat(checkout.numItemsScanned(), is(1));

    }

    @Test
    public void should_track_total_count_of_each_item() {
        Checkout checkout = new Checkout(new PriceRules());
        checkout.scan("AA");
        checkout.scan("AA");
        checkout.scan("SH");
        checkout.scan("AA");
        checkout.scan("SH");
        checkout.scan("AA");
        assertThat(checkout.countOf("AA"), is(4));
        assertThat(checkout.countOf("SH"), is(2));
    }

    @Test
    public void checkout_should_calculate_total_of_one_item() throws UnknownItemCodeException {

        PriceRules priceRules = mock(PriceRules.class);

        when(priceRules.getPriceFor("AA")).thenReturn(100);
        Checkout checkout = new Checkout(priceRules);
        checkout.scan("AA");
        assertThat(checkout.calculateTotal(), is(100));

    }
    @Test
    public void checkout_should_calculate_total_of_two_item() throws UnknownItemCodeException {

        PriceRules priceRules = mock(PriceRules.class);

        when(priceRules.getPriceFor("AA")).thenReturn(100);
        when(priceRules.getPriceFor("BB")).thenReturn(10);
        Checkout checkout = new Checkout(priceRules);
        checkout.scan("AA");
        checkout.scan("BB");
        assertThat(checkout.calculateTotal(), is(110));

    }

}
