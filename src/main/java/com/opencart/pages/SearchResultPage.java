package com.opencart.pages;

import com.opencart.containers.ProductContainer;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.stream.Collectors;

public class SearchResultPage extends BasePage {

    @FindBy(css = ".product-layout")
    private List<WebElement> productContainers;

    public List<ProductContainer> getProductContainers() {
        wait.until(ExpectedConditions.visibilityOfAllElements(productContainers));
        return productContainers.stream()
                .map(ProductContainer::new)
                .collect(Collectors.toList());
    }
}