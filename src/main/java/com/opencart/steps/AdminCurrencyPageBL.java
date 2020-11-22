package com.opencart.steps;

import com.opencart.containers.CurrencyContainerAdmin;
import com.opencart.datamodel.CurrencyModel;
import com.opencart.pages.AdminCurrencyPage;
import com.opencart.util.DriverUtils;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.List;

public class AdminCurrencyPageBL {
    private final AdminCurrencyPage adminCurrencyPage;
    private WebDriver driver;

    public AdminCurrencyPageBL() {
        adminCurrencyPage = new AdminCurrencyPage();
    }

    public void getCurrencyValues() {
        new CurrencyModel();
    }

    public AdminCurrencyPageBL clickOnAddNewCurrencyButton() {
        adminCurrencyPage.getAddNewCurrencyButton().click();
        return this;
    }

    public AdminCurrencyPageBL addNewCurrency() {
        inputCurrencyTitle(CurrencyModel.getNewCurrencyName());
        inputCurrencyCode(CurrencyModel.getNewCurrencyName());
        inputCurrencySymbolRight(CurrencyModel.getNewCurrencyName());
        inputCurrencyValue(CurrencyModel.getNewCurrencyValue());
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
        new DriverUtils().clickOnElementJS(adminCurrencyPage.getStatusEnabled(yesNo));
    }

    private void clickOnSaveCurrencyButton() {
        adminCurrencyPage.getSaveNewCurrency().click();
    }

    public AdminCurrencyPageBL deleteNewCurrency() {
        new CurrencyModel();
        clickOnCurrencyCheckbox(CurrencyModel.getNewCurrencyName());
        clickOnDeleteCurrencyButton();
        verifySuccessCurrencyEdit();
        return this;
    }

    private void clickOnCurrencyCheckbox(String currencyName) {
        List<CurrencyContainerAdmin> currencyContainersAdmin = new AdminCurrencyPage().getCurrencyContainersAdmin();
        for (CurrencyContainerAdmin container
                : currencyContainersAdmin) {
            if (container.getCurrencyCode().equals(currencyName.toLowerCase())) {
                new DriverUtils().clickOnElementJS(container.getCurrencyCheckbox());
                break;
            }
        }
    }

    private void clickOnDeleteCurrencyButton() {
        adminCurrencyPage.getDeleteCurrencyButton().click();
        new DriverUtils().acceptAlert();
    }

    public AdminCurrencyPageBL verifySuccessCurrencyEdit() {
        String expectedSuccessMessage = "Success: You have modified currencies!";
        Assert.assertTrue(adminCurrencyPage.getSuccessCurrencyEditMessage().getText().contains(expectedSuccessMessage), "\nCurrency was not changed through the Admin Page.");
        return this;
    }
}
