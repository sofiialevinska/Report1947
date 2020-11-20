package com.opencart.datamodel;

public class AdminLoginModel {

    private String username = "admin";
    private String password = "admin";

    private String currencyName = "UAH";
    private String currencyValue = "28.22";

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public String getCurrencyValue() {
        return currencyValue;
    }
}
