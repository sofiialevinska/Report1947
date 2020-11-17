package com.opencart.steps;

import com.opencart.pages.HeaderPage;
import com.opencart.pages.SearchResultPage;

public class HeaderPageBL {

    private HeaderPage headerPage;

    public HeaderPageBL() {
        headerPage = new HeaderPage();
    }

    private HeaderPageBL clickOnSearchInput() {
        headerPage.getSearchInput().click();
        return this;
    }

    private SearchResultPage clickOnSearchButton() {
        headerPage.getSearchButton().click();
        return new SearchResultPage();
    }

    public SearchResultPage searchProduct(String product) {
        clickOnSearchInput();
        inputSearch(product);

        return clickOnSearchButton();
    }

    private void inputSearch(String search) {
        headerPage.getSearchInput().clear();
        headerPage.getSearchInput().sendKeys(search);
    }

}
