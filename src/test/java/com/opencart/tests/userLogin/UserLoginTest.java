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
        LoginModel loginModel = LoginModelRepository.getValidLoginModel();
        new MainPageBL()
                .getHeaderPageBL()
                .clickOnMyAccountButton()
                .clickOnLoginButton();
        new LoginPageBL()
                .userLogin(loginModel)
                .verifyLogin();
    }

    @Test
    public void userLoginWithoutPassword() {
        new Navigation().navigateToURrl(BASE_URL.getValue());

        LoginModel loginModel = LoginModelRepository.getLoginWithoutPassword();
        new MainPageBL()
                .getHeaderPageBL()
                .clickOnMyAccountButton()
                .clickOnLoginButton();
        new LoginPageBL()
                .userLogin(loginModel)
                .verifyLoginWithoutPassword();
    }

    @Test
    public void userLoginWithoutEmail() {
        new Navigation().navigateToURrl(BASE_URL.getValue());
        LoginModel loginModel = LoginModelRepository.getLoginModelWithoutEmail();
        new MainPageBL()
                .getHeaderPageBL()
                .clickOnMyAccountButton()
                .clickOnLoginButton();
        new LoginPageBL()
                .userLogin(loginModel)
                .verifyLoginWithoutEmail();
    }

    @Test
    public void userLoginWithInvalidData() {
        new Navigation().navigateToURrl(BASE_URL.getValue());
        LoginModel loginModel = LoginModelRepository.getLoginWithInvalidData();
        new MainPageBL()
                .getHeaderPageBL()
                .clickOnMyAccountButton()
                .clickOnLoginButton();
        new LoginPageBL()
                .userLogin(loginModel)
                .verifyLoginWithInvalidData();
    }

    @Test
    public void userLoginWithEmptyFields() {
        new Navigation().navigateToURrl(BASE_URL.getValue());
        LoginModel loginModel = LoginModelRepository.getLoginWithoutData();
        new MainPageBL()
                .getHeaderPageBL()
                .clickOnMyAccountButton()
                .clickOnLoginButton();
        new LoginPageBL()
                .userLogin(loginModel)
                .verifyLoginWithEmptyFields();
    }
}