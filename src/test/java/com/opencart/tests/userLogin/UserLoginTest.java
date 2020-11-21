package com.opencart.tests.userLogin;

import com.opencart.navigation.Navigation;
import com.opencart.steps.LoginPageBL;
import com.opencart.steps.MainPageBL;
import com.opencart.tests.BaseTest;
import org.testng.annotations.Test;

import static com.opencart.enums.URLs.BASE_URL;

public class UserLoginTest extends BaseTest {

    @Test
    public void userLoginTestWithValidInput() {
        new Navigation().navigateToURrl(BASE_URL.getValue());
        MainPageBL mainPageBL = new MainPageBL();
        LoginPageBL loginPageBL = mainPageBL.getHeaderPageBL()
                .clickOnMyAccountButton()
                .clickOnLoginButton()
                .login();
        loginPageBL.verifyLogin();
    }

    @Test
    public void userLoginWithoutPassword() {
        new Navigation().navigateToURrl(BASE_URL.getValue());
        MainPageBL mainPageBL = new MainPageBL();
        LoginPageBL loginPageBL = mainPageBL.getHeaderPageBL()
                .clickOnMyAccountButton()
                .clickOnLoginButton()
                .loginWithoutPassword();
        loginPageBL.verifyLoginWithoutPassword();
    }

    @Test
    public void userLoginWithoutEmail() {
        new Navigation().navigateToURrl(BASE_URL.getValue());
        MainPageBL mainPageBL = new MainPageBL();
        LoginPageBL loginPageBL = mainPageBL.getHeaderPageBL()
                .clickOnMyAccountButton()
                .clickOnLoginButton()
                .loginWithoutEmail();
        loginPageBL.verifyLoginWithoutEmail();
    }

    @Test
    public void userLoginWithInvalidData() {
        new Navigation().navigateToURrl(BASE_URL.getValue());
        MainPageBL mainPageBL = new MainPageBL();
        LoginPageBL loginPageBL = mainPageBL.getHeaderPageBL()
                .clickOnMyAccountButton()
                .clickOnLoginButton()
                .loginWithWrongData();
        loginPageBL.verifyLoginWithInvalidData();
    }

    @Test
    public void userLoginWithEmptyFields() {
        new Navigation().navigateToURrl(BASE_URL.getValue());
        MainPageBL mainPageBL = new MainPageBL();
        LoginPageBL loginPageBL = mainPageBL.getHeaderPageBL()
                .clickOnMyAccountButton()
                .clickOnLoginButton()
                .loginWithEmptyFields();
        loginPageBL.verifyLoginWithEmptyFields();
    }
}
