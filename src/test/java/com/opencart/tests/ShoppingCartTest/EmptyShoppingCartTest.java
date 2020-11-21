package com.opencart.tests.ShoppingCartTest;

import com.opencart.navigation.Navigation;
import com.opencart.steps.MainPageBL;
import com.opencart.tests.BaseTest;
import org.testng.annotations.Test;

import static com.opencart.enums.URLs.BASE_URL;

public class EmptyShoppingCartTest extends BaseTest {

    @Test
    public void emptyShoppingCartTest() {
        new Navigation().navigateToURrl(BASE_URL.getValue());

        MainPageBL mainPageBL = new MainPageBL();

        mainPageBL.getHeaderPageBL().clickOnShoppingCartSpan();

        mainPageBL.getHeaderPageBL().getShoppingCartPageBL().verifyIfShoppingCartIsEmpty();
    }
}
