package com.opencart.tests.currency;

import com.opencart.enums.CurrencyName;
import com.opencart.navigation.Navigation;
import com.opencart.steps.MainPageBL;
import com.opencart.tests.BaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.opencart.enums.URLs.BASE_URL;

/**
 * Test checks if the cost in EUR, USD, GBP, UAH of all products on the website's main page is correct"
 */
public class ChangeCurrencyTest extends BaseTest {

    @DataProvider(name = "data-provider-currency")
    public Object[][] dataProviderMethod() {
        return new Object[][]{{CurrencyName.EUR.getValue()}, {CurrencyName.USD.getValue()},
                {CurrencyName.GBP.getValue()}, {CurrencyName.UAH.getValue()}};
    }

    @Test(dataProvider = "data-provider-currency")
    public void ChangeCurrencyTest(String data) {
        new Navigation().navigateToURrl(BASE_URL.getValue());
        MainPageBL mainPageBL = new MainPageBL();
        mainPageBL
                .getHeaderPageBL()
                .clickOnChangeCurrencyButton()
                .clickOnCurrencyButton(data);
        mainPageBL.verifyAllProductsPrices(data);
    }
}
