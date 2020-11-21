package com.opencart.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends BasePage{

    @FindBy(css = "div#content p")
    private WebElement emptyShoppingCartMessage;

    public WebElement getEmptyShoppingCartMessage() {
        return emptyShoppingCartMessage;
    }
}
