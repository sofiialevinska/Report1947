package com.opencart.containers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductsContainersAdmin {
    private final WebElement webElement;

    public ProductsContainersAdmin(WebElement webElement) {
        this.webElement = webElement;
    }

    public String getProductName() {
        return this.webElement.findElement(By.cssSelector("tr td:nth-child(3)")).getText();
    }

    public String getProductPrice() {
        List<WebElement> dynamicElement = webElement.findElements(By.cssSelector("tr td:nth-child(5) .text-danger"));
        if (dynamicElement.size() != 0) {
            return this.webElement.findElement(By.cssSelector("tr td:nth-child(5) .text-danger")).getText();
        } else {
            return this.webElement.findElement(By.cssSelector("tr td:nth-child(5)")).getText();
        }
    }
}
