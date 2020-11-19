package com.opencart.tests.ProductsSearchTest;

import com.opencart.containers.ProductContainer;
import com.opencart.navigation.Navigation;
import com.opencart.pages.SearchResultPage;
import com.opencart.steps.MainPageBL;
import com.opencart.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static com.opencart.enums.URLs.BASE_URL;

public class SimpleSearchTest extends BaseTest {

    @Test
    public void searchProductWithValidParameters() {
        new Navigation().navigateToURrl(BASE_URL.getValue());

        String product = "MacBook";
        MainPageBL mainPageBL = new MainPageBL();
        mainPageBL.getHeaderPageBL().searchProduct(product);

        List<ProductContainer> productContainers = new SearchResultPage().getProductContainers();

        for (ProductContainer container : productContainers) {
            Assert.assertTrue(container.getName().contains(product));
        }
    }
}
