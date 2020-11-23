package com.opencart.containers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CurrencyContainerAdmin {
    private final WebElement webElement;

    public CurrencyContainerAdmin(WebElement webElement) {
        this.webElement = webElement;
    }

    public String getCurrencyCode() {
        return this.webElement.findElement(By.cssSelector("tr td:nth-child(3)")).getText();
    }

    public String getCurrencyValue() {
        return this.webElement.findElement(By.cssSelector("tr td:nth-child(4)")).getText();
    }

    public WebElement getEditCurrencyButton() {
        return this.webElement.findElement(By.cssSelector("tr td:nth-child(6)"));
    }

    public WebElement getCurrencyCheckbox() {
        return this.webElement.findElement(By.cssSelector("tr td:nth-child(1) input"));
    }
}
