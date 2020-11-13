import com.opencart.enums.CurrencyName;
import com.opencart.navigation.Navigation;
import com.opencart.steps.HeaderPageBL;
import com.opencart.steps.MainPageBL;
import org.testng.annotations.Test;

import static com.opencart.enums.URLs.BASE_URL;

public class ChangeCurrencyTest extends BaseTest {

    @Test
    public void changeCurrencyToEur() throws InterruptedException {
        new Navigation().navigateToURrl(BASE_URL.getValue());
        MainPageBL mainPageBL = new MainPageBL();
        HeaderPageBL headerPageBL = mainPageBL.getHeaderPageBL()
                .clickOnChangeCurrencyButton()
                .clickOnEurButton(CurrencyName.GBP.getValue());
        Thread.sleep(3000);
        headerPageBL.verifyMacBookCost(CurrencyName.GBP.getValue());
    }
}
