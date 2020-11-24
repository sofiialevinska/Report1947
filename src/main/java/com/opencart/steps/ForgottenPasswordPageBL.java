package com.opencart.steps;

import com.opencart.datamodel.LoginModel;
import com.opencart.pages.ForgottenPasswordPage;
import org.junit.Assert;

public class ForgottenPasswordPageBL {
    private ForgottenPasswordPage forgottenPasswordPage;

    public ForgottenPasswordPageBL() {
        forgottenPasswordPage = new ForgottenPasswordPage();
    }

    public LoginPageBL resetPassword() {
        LoginModel loginModel = new LoginModel();
        inputEmail(loginModel.getEmail());
        clickOnContinueButton();

        return new LoginPageBL();
    }

    private void inputEmail(String email) {
        forgottenPasswordPage.getInputEmail().clear();
        forgottenPasswordPage.getInputEmail().sendKeys(email);
    }

    private void clickOnContinueButton() {
        forgottenPasswordPage.getContinueButton().click();
    }

    public LoginPageBL getLoginPageBL() {
        return new LoginPageBL();
    }
}