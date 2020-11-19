package com.opencart.containers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ProductContainer {

    private final WebElement webElement;

    public ProductContainer(WebElement webElement) {
        this.webElement = webElement;
    }

    public String getName() {
        return this.webElement.findElement(By.xpath(".//div[@class = 'caption']/h4")).getText();
    }

    public String getDescription() {
        return this.webElement.findElement(By.cssSelector("* div:nth-child(2) > p:nth-child(2)")).getText();
    }

    public String getPrice() {
        return this.webElement.findElement(By.cssSelector(".price")).getText();
    }

    public String getPriceTax() {
        return this.webElement.findElement(By.cssSelector(".price-tax")).getText();
    }

    public WebElement getShoppingCartButton() {
        return this.webElement.findElement(By.cssSelector("button > i.fa fa-shopping-cart"));
    }

    public WebElement getWishListButton() {
        return this.webElement.findElement(By.cssSelector("button > i.fa fa-heart"));
    }

    public WebElement getCompareButton() {
        return this.webElement.findElement(By.cssSelector("button > i.fa fa-exchange"));
    }
}
