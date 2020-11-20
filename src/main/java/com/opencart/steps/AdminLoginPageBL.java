package com.opencart.steps;

import com.opencart.datamodel.AdminLoginModel;
import com.opencart.pages.AdminLoginPage;

public class AdminLoginPageBL {
    private AdminLoginPage adminLoginPage;

    public AdminLoginPageBL() {
        adminLoginPage = new AdminLoginPage();
    }

    public AdminLoginPageBL adminLogin() {
        AdminLoginModel adminLoginModel = new AdminLoginModel();
        inputUsername(adminLoginModel.getUsername());
        inputPassword(adminLoginModel.getPassword());
        clickOnSubmitButton();
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
