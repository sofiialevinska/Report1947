package com.opencart.steps;

import com.opencart.pages.WishListPage;

public class WishListPageBL {

    private WishListPage wishListPage;

    public WishListPageBL() {wishListPage = new WishListPage();}


    private void clickYourStoreButton() {
        wishListPage.getYourStoreButton().click();
    }

    private void clickOnContinueButton() {
        wishListPage.getContinueButton().click();
    }
}
