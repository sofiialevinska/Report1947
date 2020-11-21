package com.opencart.tests.ShoppingCartTest;

import com.opencart.navigation.Navigation;
import com.opencart.steps.MainPageBL;
import com.opencart.tests.BaseTest;
import org.testng.annotations.Test;

import static com.opencart.enums.URLs.BASE_URL;

public class EmptyDropDownInfoShoppingCartTest extends BaseTest {
    @Test
    public void emptyDropDownInfoShoppingCartTest() {
        new Navigation().navigateToURrl(BASE_URL.getValue());

        MainPageBL mainPageBL = new MainPageBL();

        mainPageBL.getHeaderPageBL().verifyIfShoppingCartDropDownInfoIsEmpty();
        mainPageBL.getHeaderPageBL().verifyShoppingCartDropDownMessage();
    }
}
