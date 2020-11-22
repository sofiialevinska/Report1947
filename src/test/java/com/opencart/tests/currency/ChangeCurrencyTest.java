package com.opencart.tests.currency;

import com.opencart.driver.DriverRepository;
import com.opencart.enums.CurrencyName;
import com.opencart.navigation.Navigation;
import com.opencart.steps.AdminCurrencyPageBL;
import com.opencart.steps.AdminDashboardBL;
import com.opencart.steps.AdminLoginPageBL;
import com.opencart.steps.MainPageBL;
import com.opencart.tests.BaseTest;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.opencart.enums.URLs.ADMIN_BASE_URL;
import static com.opencart.enums.URLs.BASE_URL;

/**
 * Test checks if the cost in EUR, USD, GBP, UAH of all products on the website's main page is correct"
 */
public class ChangeCurrencyTest extends BaseTest {

    @BeforeClass
    public void getCurrenciesValuesFromAdminPage() {
        new Navigation().navigateToURrl(ADMIN_BASE_URL.getValue());
        new AdminLoginPageBL().adminLogin();
        new AdminDashboardBL()
                .getAdminLeftNavigationPanelPageBL()
                .clickOnLeftNavigationPanelButton("System")
                .clickOnLeftNavigationPanelButton("Localisation")
                .clickOnLeftNavigationPanelButton("Currencies");
        new AdminCurrencyPageBL().getCurrencyValues();
    }

    @DataProvider(name = "data-provider-currency")
    public Object[][] dataProviderMethod() {
        return new Object[][]{{CurrencyName.EUR.getValue()}, {CurrencyName.USD.getValue()},
                {CurrencyName.GBP.getValue()}};
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

    @AfterClass
    public void closeAdminBrowser() {
        DriverRepository.closeBrowser();
    }
}
