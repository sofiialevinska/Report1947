package com.opencart.pages;

import com.opencart.containers.CurrencyContainerAdmin;
import com.opencart.containers.ProductsContainersAdmin;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.stream.Collectors;

public class AdminProductsPage extends BasePage {

    @FindBy(css = "tr")
    private List<WebElement> productsContainersAdmin;

    public List<ProductsContainersAdmin> getProductsContainersAdmin() {
        wait.until(ExpectedConditions.visibilityOfAllElements(productsContainersAdmin));
        return productsContainersAdmin.stream()
                .map(ProductsContainersAdmin::new)
                .collect(Collectors.toList());
    }




}
