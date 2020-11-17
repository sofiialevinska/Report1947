package com.opencart.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderPage extends BasePage{

    @FindBy(css = "input[name = 'search']")
    private WebElement searchInput;

    @FindBy(css = "* button > i.fa.fa-search")
    private WebElement searchButton;

    public WebElement getSearchButton() {
        return searchButton;
    }

    public WebElement getSearchInput() {
        return searchInput;
    }
}
