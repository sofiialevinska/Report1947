package com.opencart.steps;

import com.opencart.pages.WishListPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class WishListPageBL {

    public WishListPageBL() {wishListPage = new WishListPage();}

    private WishListPage wishListPage;

    private void clickYourStoreButton() {
        wishListPage.getYourStoreButton().click();
    }

    private void clickOnContinueButton() {
        wishListPage.getContinueButton().click();
    }

    public WishListPageBL clickOnRemoveButton() {
        wishListPage.getRemoveButton().click();
        return this;
    }

    public WishListPageBL clickOnAddToCartButton() {
        wishListPage.getAddToCartButton().click();
        return this;
    }

    public void verifyDeletingFromWishList() {
        String expected = "Success: You have modified your wish list!";
        String actual = wishListPage.getSuccessModificationMessage().getText()
                .replaceAll("×", "").trim();
        Assert.assertEquals(actual, expected, "You didn't delete product from wish list!");
    }

    public void verifyAddingToShoppingCart() {
        String expected = "Success: You have added MacBook to your shopping cart!";
        String actual = wishListPage.getSuccessModificationMessage().getText()
                .replaceAll("×", "").trim();
        Assert.assertEquals(actual, expected, "You didn't add product to Shopping Cart");
    }
}
