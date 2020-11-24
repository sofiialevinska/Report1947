package com.opencart.tests.userLogin;

import com.opencart.datamodel.LoginModel;
import com.opencart.navigation.Navigation;
import com.opencart.repository.LoginModelRepository;
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
        LoginModel loginModel = LoginModelRepository.getValidLoginModel();
        LoginPageBL loginPageBL = mainPageBL.getHeaderPageBL()
                .clickOnMyAccountButton()
                .clickOnLoginButton()
                .userLogin(loginModel);
        loginPageBL.verifyLogin();
    }

    @Test
    public void userLoginWithoutPassword() {
        new Navigation().navigateToURrl(BASE_URL.getValue());
        MainPageBL mainPageBL = new MainPageBL();
        LoginModel loginModel = LoginModelRepository.getLoginWithoutPassword();
        LoginPageBL loginPageBL = mainPageBL.getHeaderPageBL()
                .clickOnMyAccountButton()
                .clickOnLoginButton()
                .userLogin(loginModel);
        loginPageBL.verifyLoginWithoutPassword();
    }

    @Test
    public void userLoginWithoutEmail() {
        new Navigation().navigateToURrl(BASE_URL.getValue());
        MainPageBL mainPageBL = new MainPageBL();
        LoginModel loginModel = LoginModelRepository.getLoginModelWithoutEmail();
        LoginPageBL loginPageBL = mainPageBL.getHeaderPageBL()
                .clickOnMyAccountButton()
                .clickOnLoginButton()
                .userLogin(loginModel);
        loginPageBL.verifyLoginWithoutEmail();
    }

    @Test
    public void userLoginWithInvalidData() {
        new Navigation().navigateToURrl(BASE_URL.getValue());
        MainPageBL mainPageBL = new MainPageBL();
        LoginModel loginModel = LoginModelRepository.getLoginWithInvalidData();
        LoginPageBL loginPageBL = mainPageBL.getHeaderPageBL()
                .clickOnMyAccountButton()
                .clickOnLoginButton()
                .userLogin(loginModel);
        loginPageBL.verifyLoginWithInvalidData();
    }

    @Test
    public void userLoginWithEmptyFields() {
        new Navigation().navigateToURrl(BASE_URL.getValue());
        MainPageBL mainPageBL = new MainPageBL();
        LoginModel loginModel = LoginModelRepository.getLoginWithoutData();
        LoginPageBL loginPageBL = mainPageBL.getHeaderPageBL()
                .clickOnMyAccountButton()
                .clickOnLoginButton()
                .userLogin(loginModel);
        loginPageBL.verifyLoginWithEmptyFields();
    }
}