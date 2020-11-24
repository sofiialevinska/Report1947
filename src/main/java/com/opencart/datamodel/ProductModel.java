package com.opencart.datamodel;

import java.util.*;

public class ProductModel {

    private static Map <String, Double> productPriceList;

    public ProductModel () {
     productPriceList = new HashMap<String, Double>();

     productPriceList.put("MacBook",602.00);
     productPriceList.put("iPhone",123.20);
     productPriceList.put("Apple Cinema 30\"",110.00);
     productPriceList.put("Canon EOS 5D",98.00);
 }

    public static Double getProductPriceInUSD (String productName) {
        return productPriceList.get(productName);
    }
}
