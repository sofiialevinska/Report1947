package com.opencart.steps;

import com.opencart.datamodel.AdminLoginModel;
import com.opencart.pages.AdminLoginPage;
import com.opencart.util.DriverUtils;
import io.qameta.allure.Step;

public class AdminLoginPageBL {
    private final AdminLoginPage adminLoginPage;

    public AdminLoginPageBL() {
        adminLoginPage = new AdminLoginPage();
    }

    @Step("Login to Admin Page")
    public AdminLoginPageBL adminLogin() {
        AdminLoginModel adminLoginModel = new AdminLoginModel();
        inputUsername(adminLoginModel.getUsername());
        inputPassword(adminLoginModel.getPassword());
        clickOnSubmitButton();
        if (new DriverUtils().isAlertPresent()) {
            new DriverUtils().cancelAlert();
        }
        return this;
    }

    private void inputUsername(String username) {
        adminLoginPage.getUsernameInput().clear();
        adminLoginPage.getUsernameInput().sendKeys(username);
    }

    private void inputPassword(String password) {
        adminLoginPage.getPasswordInput().clear();
        adminLoginPage.getPasswordInput().sendKeys(password);
    }

    private void clickOnSubmitButton() {
        adminLoginPage.getSubmitButton().click();
    }
}