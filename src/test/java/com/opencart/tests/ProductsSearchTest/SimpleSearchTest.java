package com.opencart.tests.ProductsSearchTest;

import com.opencart.containers.ProductContainer;
import com.opencart.dataprovider.DataProviderClass;
import com.opencart.navigation.Navigation;
import com.opencart.pages.SearchResultPage;
import com.opencart.steps.MainPageBL;
import com.opencart.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static com.opencart.enums.URLs.BASE_URL;

public class SimpleSearchTest extends BaseTest {

    @Test(dataProviderClass = DataProviderClass.class, dataProvider = "SetValidSearchProducts")
    public void searchProductWithValidParameters(String product) {
        new Navigation().navigateToURrl(BASE_URL.getValue());

        MainPageBL mainPageBL = new MainPageBL();
        mainPageBL.getHeaderPageBL().searchProduct(product);
        mainPageBL.getHeaderPageBL().getSearchResultPageBL().verifySearching(product);
    }
}
