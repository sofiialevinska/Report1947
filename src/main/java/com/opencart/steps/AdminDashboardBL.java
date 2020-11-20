package com.opencart.steps;

import com.opencart.datamodel.AdminLoginModel;
import com.opencart.pages.AdminDashboard;

public class AdminDashboardBL {
    private final AdminDashboard adminDashboard;

    public AdminDashboardBL() {
        adminDashboard = new AdminDashboard();
    }

    public AdminDashboardBL clickOnSidebarButton (String buttonName) {
        adminDashboard.getButton(buttonName).click();
        return this;
    }

    public AdminDashboardBL clickOnAddNewCurrencyButton () {
        adminDashboard.getAddNewCurrencyButton().click();
        return this;
    }

    public AdminDashboardBL addNewCurrency () {
        AdminLoginModel adminLoginModel = new AdminLoginModel();
        inputCurrencyTitle(adminLoginModel.getCurrencyName());
        inputCurrencyCode(adminLoginModel.getCurrencyName());
        inputCurrencySymbolRight(adminLoginModel.getCurrencyName());
        inputCurrencyValue(adminLoginModel.getCurrencyValue());
        clickOnSaveCurrencyButton();
        return this;
    }

    private void inputCurrencyTitle (String currencyName) {
        adminDashboard.getInputCurrencyTitle().clear();
    adminDashboard.getInputCurrencyTitle().sendKeys(currencyName);
    }

    private void inputCurrencyCode (String currencyCode) {
        adminDashboard.getInputCurrencyCode().clear();
        adminDashboard.getInputCurrencyCode().sendKeys(currencyCode);
    }

    private void inputCurrencySymbolRight (String currencyName) {
        adminDashboard.getInputCurrencySymbolRight().clear();
        adminDashboard.getInputCurrencySymbolRight().sendKeys(currencyName);
    }

    private void inputCurrencyValue (String currencyValue) {
        adminDashboard.getInputValue().clear();
        adminDashboard.getInputValue().sendKeys(currencyValue);
    }

    private void clickOnSaveCurrencyButton () {
        adminDashboard.getSaveNewCurrency().click();
    }

}
