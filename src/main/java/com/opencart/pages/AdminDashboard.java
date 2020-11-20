package com.opencart.pages;

import com.opencart.containers.CurrencyContainerAdmin;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.stream.Collectors;

public class AdminDashboard extends BasePage {

    @FindBy (css = "[data-original-title='Add New']")
    WebElement addNewCurrencyButton;

    @FindBy (css = "[type='submit']")
    WebElement saveNewCurrency;

    @FindBy (id = "input-title")
    WebElement inputCurrencyTitle;

    @FindBy (id = "input-code")
    WebElement inputCurrencyCode;

    @FindBy (id = "input-symbol-right")
    WebElement inputCurrencySymbolRight;

    @FindBy (id = "input-value")
    WebElement inputValue;
//
//    @FindBy (xpath = ".//*[contains(text(), '"+20/11/2020+"')]")
//    WebElement edit

    @FindBy(css = "tr")
    private List<WebElement> currencyContainersAdmin;

    public List<CurrencyContainerAdmin> getCurrencyContainersAdmin() {
        wait.until(ExpectedConditions.visibilityOfAllElements(currencyContainersAdmin));
        return currencyContainersAdmin.stream()
                .map(CurrencyContainerAdmin::new)
                .collect(Collectors.toList());
    }

    public WebElement getButton (String buttonName) {
        wait.until(ExpectedConditions.visibilityOf
                (driver.findElement(By.xpath(".//*[contains(text(), '"+ buttonName + "')]"))));
        return driver.findElement(By.xpath(".//*[contains(text(), '"+ buttonName + "')]"));
    }

    public WebElement getAddNewCurrencyButton() {
        wait.until(ExpectedConditions.visibilityOf(addNewCurrencyButton));
        return addNewCurrencyButton;
    }

    public WebElement getInputCurrencyTitle() {
        wait.until(ExpectedConditions.visibilityOf(inputCurrencyTitle));
        return inputCurrencyTitle;
    }

    public WebElement getInputCurrencyCode() {
        return inputCurrencyCode;
    }

    public WebElement getInputCurrencySymbolRight() {
        return inputCurrencySymbolRight;
    }

    public WebElement getInputValue() {
        return inputValue;
    }

    public WebElement getSaveNewCurrency() {
        return saveNewCurrency;
    }
}
