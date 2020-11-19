package com.opencart.steps;

import com.opencart.pages.SearchResultPage;
import org.testng.Assert;

public class SearchResultPageBL {

    private SearchResultPage searchResultPage;

    public SearchResultPageBL() {
        searchResultPage = new SearchResultPage();
    }

    public void verifyNegativeSearch() {
        String expectedMessage = "There is no product that matches the search criteria.";

        Assert.assertEquals(searchResultPage.getUnsuccessfulTitle().getText(), expectedMessage);
    }
}
