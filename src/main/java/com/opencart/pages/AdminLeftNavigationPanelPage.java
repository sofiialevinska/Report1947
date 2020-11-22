package com.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AdminLeftNavigationPanelPage extends BasePage {

    public WebElement getButtonFromLeftNavigationPanel(String buttonName) {
        wait.until(ExpectedConditions.visibilityOf
                (driver.findElement(By.xpath(".//*[contains(text(), '" + buttonName + "')]"))));
        return driver.findElement(By.xpath(".//*[contains(text(), '" + buttonName + "')]"));
    }
}
