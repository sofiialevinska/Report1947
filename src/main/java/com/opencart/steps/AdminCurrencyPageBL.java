package com.opencart.steps;

import com.opencart.containers.CurrencyContainerAdmin;
import com.opencart.pages.AdminCurrencyPage;
import com.opencart.util.DriverUtils;
import io.qameta.allure.Step;
import org.testng.Assert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdminCurrencyPageBL {
    private final AdminCurrencyPage adminCurrencyPage;

    public AdminCurrencyPageBL() {
        adminCurrencyPage = new AdminCurrencyPage();
    }

    @Step("put Currencies names and values from Admin Page to Map <String,String>")
    public Map<String, String> getCurrencyValues() {
        Map<String, String> currencyValuesMap = new HashMap<>();
        List<CurrencyContainerAdmin> currencyContainersAdmin = new AdminCurrencyPage().getCurrencyContainersAdmin();
        for (CurrencyContainerAdmin container
                : currencyContainersAdmin) {
            if (container.getCurrencyCode().length() == 3) {
                currencyValuesMap.put(container.getCurrencyCode(), container.getCurrencyValue());
            }
        }
        return currencyValuesMap;
    }

    @Step ("verifySubscriptionEdit")
    public AdminCurrencyPageBL clickOnAddNewCurrencyButton() {
        adminCurrencyPage.getAddNewCurrencyButton().click();
        return this;
    }

    @Step ("addNewCurrency through Admin Page")
    public AdminCurrencyPageBL addNewCurrency(String newCurrencyName, String newCurrencyValue) {
        inputCurrencyTitle(newCurrencyName);
        inputCurrencyCode(newCurrencyName);
        inputCurrencySymbolRight(newCurrencyName);
        inputCurrencyValue(newCurrencyValue);
        selectEnabledStatus(1);
        clickOnSaveCurrencyButton();
        return this;
    }

    private void inputCurrencyTitle(String currencyName) {
        adminCurrencyPage.getInputCurrencyTitle().clear();
        adminCurrencyPage.getInputCurrencyTitle().sendKeys(currencyName);
    }

    private void inputCurrencyCode(String currencyCode) {
        adminCurrencyPage.getInputCurrencyCode().clear();
        adminCurrencyPage.getInputCurrencyCode().sendKeys(currencyCode);
    }

    private void inputCurrencySymbolRight(String currencyName) {
        adminCurrencyPage.getInputCurrencySymbolRight().clear();
        adminCurrencyPage.getInputCurrencySymbolRight().sendKeys(currencyName);
    }

    private void inputCurrencyValue(String currencyValue) {
        adminCurrencyPage.getInputValue().clear();
        adminCurrencyPage.getInputValue().sendKeys(currencyValue);
    }

    private void selectEnabledStatus(int yesNo) {
        adminCurrencyPage.getStatusEnabled(yesNo).selectByValue("1");
    }

    private void clickOnSaveCurrencyButton() {
        adminCurrencyPage.getSaveNewCurrency().click();
    }

    @Step ("deleteCurrency through Admin Page")
    public AdminCurrencyPageBL deleteCurrency(String currencyName) {
        clickOnCurrencyCheckbox(currencyName);
        clickOnDeleteCurrencyButton();
        verifySuccessCurrencyEdit();
        return this;
    }

    private void clickOnCurrencyCheckbox(String currencyName) {
        List<CurrencyContainerAdmin> currencyContainersAdmin = new AdminCurrencyPage().getCurrencyContainersAdmin();
        for (CurrencyContainerAdmin container
                : currencyContainersAdmin) {
            if (container.getCurrencyCode().equals(currencyName)) {
                new DriverUtils().clickOnElementJS(container.getCurrencyCheckbox());
                break;
            }
        }
    }

    private void clickOnDeleteCurrencyButton() {
        adminCurrencyPage.getDeleteCurrencyButton().click();
        new DriverUtils().acceptAlert();
    }

    @Step ("verifySuccessCurrencyEdit on Admin Page")
    public AdminCurrencyPageBL verifySuccessCurrencyEdit() {
        String expectedSuccessMessage = "Success: You have modified currencies!";
        Assert.assertTrue(adminCurrencyPage.getSuccessCurrencyEditMessage().getText().contains(expectedSuccessMessage), "\nCurrency was not changed through the Admin Page.");
        return this;
    }
}