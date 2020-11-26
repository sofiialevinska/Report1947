package com.opencart.containers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TaxRatesContainerAdmin {
    private final WebElement webElement;

    public TaxRatesContainerAdmin (WebElement webElement) {
        this.webElement = webElement;
    }

    public String getTaxName() {
        return this.webElement.findElement(By.cssSelector("tr td:nth-child(2)")).getText();
    }

    public String getTaxRate() {
        return this.webElement.findElement(By.cssSelector("tr td:nth-child(3)")).getText();
    }

    public WebElement getEditTaxRateButton() {
        return this.webElement.findElement(By.cssSelector("tr td:nth-child(8)"));
    }

    public WebElement getTaxRateCheckbox() {
        return this.webElement.findElement(By.cssSelector("tr td:nth-child(1) input"));
    }
}
