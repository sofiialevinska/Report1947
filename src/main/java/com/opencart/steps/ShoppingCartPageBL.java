package com.opencart.steps;

import com.opencart.pages.ShoppingCartPage;
import org.testng.Assert;

public class ShoppingCartPageBL {
    private ShoppingCartPage shoppingCartPage;

    public ShoppingCartPageBL() {
        shoppingCartPage = new ShoppingCartPage();
    }

    public void verifyIfShoppingCartIsEmpty() {
        String expectedMessage = "Your shopping cart is empty!";

        Assert.assertEquals(shoppingCartPage.getEmptyShoppingCartMessage().getText(), expectedMessage);
    }
}
