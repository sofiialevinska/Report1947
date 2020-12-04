package com.opencart.steps;

import com.opencart.pages.AdminLeftNavigationPanelPage;
import io.qameta.allure.Step;

public class AdminLeftNavigationPanelPageBL {
    private final AdminLeftNavigationPanelPage adminLeftNavigationPanelPage;

    public AdminLeftNavigationPanelPageBL() {
        adminLeftNavigationPanelPage = new AdminLeftNavigationPanelPage();
    }

    @Step("clickOnLeftNavigationPanelButton on Admin Page")
    public AdminLeftNavigationPanelPageBL clickOnLeftNavigationPanelButton(String buttonName) {
        adminLeftNavigationPanelPage.getButtonFromLeftNavigationPanel(buttonName).click();
        return this;
    }
}