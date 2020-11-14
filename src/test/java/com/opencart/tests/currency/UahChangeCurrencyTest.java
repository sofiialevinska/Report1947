package com.opencart.tests.currency;

import com.opencart.enums.CurrencyName;
import com.opencart.navigation.Navigation;
import com.opencart.steps.HeaderPageBL;
import com.opencart.steps.MainPageBL;
import com.opencart.tests.BaseTest;
import org.testng.annotations.Test;

import static com.opencart.enums.URLs.BASE_URL;

public class UahChangeCurrencyTest extends BaseTest {

    /**
     * Test checks MacBook cost in Ukrainian Hryvnia on the website's main page.
     */
    @Test
    public void ChangeCurrencyToUah() {
        new Navigation().navigateToURrl(BASE_URL.getValue());
        MainPageBL mainPageBL = new MainPageBL();
        HeaderPageBL headerPageBL = mainPageBL.getHeaderPageBL()
                .clickOnChangeCurrencyButton()
                .clickOnCurrencyButton(CurrencyName.UAH.getValue())
                .verifyMacBookCost(CurrencyName.UAH.getValue());
    }
}
