package com.wakaleo.dojo.melbourne1.checkout;

import org.junit.Test;

import java.math.BigDecimal;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class WhenCheckingOutItems {

    @Test
    public void should_calculate_total_price_for_scanned_items() {

        PriceRules priceRules = new PriceRules();

        Checkout checkout = new Checkout(priceRules);

        checkout.scan("PE");

//        checkout.scan("PE"); 
//        checkout.scan("PI");  
//        checkout.scan("PI");  
//        checkout.scan("PI");  
//        checkout.scan("PI"); 
//        checkout.scan("SH");  
//        checkout.scan("SH");  
//        checkout.scan("SH");  
//        checkout.scan("SH"); 
//
        int price = 0;//checkout.getTotal();

        assertThat(price, is(70));
    }





}
