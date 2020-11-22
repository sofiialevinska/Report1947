package com.opencart.steps;

import com.opencart.pages.AdminLeftNavigationPanelPage;

public class AdminLeftNavigationPanelPageBL {
    private final AdminLeftNavigationPanelPage adminLeftNavigationPanelPage;

    public AdminLeftNavigationPanelPageBL() {
        adminLeftNavigationPanelPage = new AdminLeftNavigationPanelPage();
    }

    public AdminLeftNavigationPanelPageBL clickOnLeftNavigationPanelButton(String buttonName) {
        adminLeftNavigationPanelPage.getButtonFromLeftNavigationPanel(buttonName).click();
        return this;
    }
}
