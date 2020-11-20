package com.opencart.datamodel;

import com.opencart.containers.CurrencyContainerAdmin;
import com.opencart.pages.AdminDashboard;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CurrencyModel {

    private static Map<String, String> currencyValuesMap;

    public CurrencyModel () {
        currencyValuesMap = new HashMap<String, String>();
        List<CurrencyContainerAdmin> currencyContainersAdmin = new AdminDashboard().getCurrencyContainersAdmin();
        for (CurrencyContainerAdmin container
                : currencyContainersAdmin) {
            currencyValuesMap.put(container.getCurrencyCode (), container.getCurrencyValue());
        }
    }

    public static String getCurrencyValue (String currencyCode) {
        return currencyValuesMap.get(currencyCode.toLowerCase());
    }
}
