package com.opencart.tests.currency;

import com.opencart.enums.CurrencyName;
import com.opencart.navigation.Navigation;
import com.opencart.steps.HeaderPageBL;
import com.opencart.steps.MainPageBL;
import com.opencart.tests.BaseTest;
import org.testng.annotations.Test;

import static com.opencart.enums.URLs.BASE_URL;


public class EurChangeCurrencyTest extends BaseTest {

    /**
     * Test checks MacBook cost in EUR on the website's header.
     */
    @Test
    public void changeCurrencyToEur() {
        new Navigation().navigateToURrl(BASE_URL.getValue());
        MainPageBL mainPageBL = new MainPageBL();
        HeaderPageBL headerPageBL = mainPageBL.getHeaderPageBL()
                .clickOnChangeCurrencyButton()
                .clickOnCurrencyButton(CurrencyName.EUR.getValue())
                .verifyMacBookCost(CurrencyName.EUR.getValue());
    }
}
