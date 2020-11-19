package com.opencart.steps;

import com.opencart.containers.ProductContainer;
import com.opencart.pages.SearchResultPage;
import org.testng.Assert;

import java.util.List;

public class SearchResultPageBL {

    private SearchResultPage searchResultPage;

    public SearchResultPageBL() {
        searchResultPage = new SearchResultPage();
    }

    public void verifyNegativeSearch() {
        String expectedMessage = "There is no product that matches the search criteria.";

        Assert.assertEquals(searchResultPage.getUnsuccessfulTitle().getText(), expectedMessage);
    }

    public void verifySearching(String product) {
        List<ProductContainer> productContainers = searchResultPage.getProductContainers();

        for (ProductContainer container : productContainers) {
            Assert.assertTrue(container.getName().toLowerCase().contains(product.toLowerCase()));
        }
    }
}
