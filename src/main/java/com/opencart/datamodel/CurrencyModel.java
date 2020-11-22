package com.opencart.datamodel;

import com.opencart.containers.CurrencyContainerAdmin;
import com.opencart.pages.AdminCurrencyPage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CurrencyModel {

    private static Map<String, String> currencyValuesMap;
    private static final String newCurrencyName = "UAH";
    private static final String newCurrencyValue = "28.22";

    public CurrencyModel() {
        currencyValuesMap = new HashMap<String, String>();
        List<CurrencyContainerAdmin> currencyContainersAdmin = new AdminCurrencyPage().getCurrencyContainersAdmin();
        for (CurrencyContainerAdmin container
                : currencyContainersAdmin) {
            currencyValuesMap.put(container.getCurrencyCode(), container.getCurrencyValue());
        }
    }

    public static String getCurrencyValue(String currencyCode) {
        return currencyValuesMap.get(currencyCode.toLowerCase());
    }

    public static String getNewCurrencyName() {
        return newCurrencyName;
    }

    public static String getNewCurrencyValue() {
        return newCurrencyValue;
    }
}
