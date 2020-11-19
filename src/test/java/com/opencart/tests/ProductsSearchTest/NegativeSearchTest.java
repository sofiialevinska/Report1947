package com.opencart.tests.ProductsSearchTest;

import com.opencart.dataprovider.DataProviderClass;
import com.opencart.navigation.Navigation;
import com.opencart.steps.MainPageBL;
import com.opencart.tests.BaseTest;
import org.testng.annotations.Test;

import static com.opencart.enums.URLs.BASE_URL;

public class NegativeSearchTest extends BaseTest {

    @Test(dataProviderClass = DataProviderClass.class, dataProvider = "SetInvalidSearchProducts")
    public void searchProductWithInvalidParameters(String product) {
        new Navigation().navigateToURrl(BASE_URL.getValue());

        MainPageBL mainPageBL = new MainPageBL();
        mainPageBL.getHeaderPageBL().searchProduct(product);

        mainPageBL.getHeaderPageBL().getSearchResultPageBL().verifyNegativeSearch();
    }
}
