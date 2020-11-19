package com.opencart.dataprovider;

import org.testng.annotations.DataProvider;

public class DataProviderClass {

    @DataProvider(name = "SetValidSearchProducts")
    public Object[][] getValidSearchData() {
        return new Object[][] {{"Iphone"}, {"macbook"}, {"Samsung"}, {"Canon"}};
    }
    @DataProvider(name = "SetInvalidSearchProducts")
    public Object[][] getInvalidSearchData() {
        return new Object[][] {{" "}, {"123"}, {"%"}, {"'"}, {"https://softserve.academy/"}};
    }
}
