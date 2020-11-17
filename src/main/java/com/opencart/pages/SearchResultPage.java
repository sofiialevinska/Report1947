package com.opencart.pages;

import com.opencart.containers.ProductContainer;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class SearchResultPage extends BasePage {

    @FindBy(css = ".product-layout")
    private List<WebElement> productContainers;

    public List<ProductContainer> getProductContainers() {
        return productContainers.stream()
                .map(ProductContainer::new)
                .collect(Collectors.toList());
    }
}
