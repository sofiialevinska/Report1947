package ProductsSearchTest;

import BaseTest.BaseTest;
import com.opencart.containers.ProductContainer;
import com.opencart.navigation.Navigation;
import com.opencart.pages.SearchResultPage;
import com.opencart.steps.MainPageBL;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.opencart.steps.HeaderPageBL;

import java.util.List;
import java.util.ListIterator;

import static com.opencart.enums.URLs.BASE_URL;

public class SimpleSearchTest extends BaseTest {

    @Test
    public void searchProductWithValidParameters() {
        new Navigation().navigateToURrl(BASE_URL.getValue());

        String product = "MacBook";
        MainPageBL mainPageBL = new MainPageBL();
        SearchResultPage searchResultPage = mainPageBL.getHeaderPageBL().searchProduct(product);

        List<ProductContainer> productContainers = new SearchResultPage().getProductContainers();

        for (ProductContainer container : productContainers) {
            Assert.assertTrue(container.getName().contains(product));
        }
    }
}
