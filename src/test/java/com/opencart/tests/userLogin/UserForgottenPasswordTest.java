package com.opencart.tests.userLogin;

import com.opencart.navigation.Navigation;
import com.opencart.steps.ForgottenPasswordPageBL;
import com.opencart.steps.LoginPageBL;
import com.opencart.steps.MainPageBL;
import com.opencart.tests.BaseTest;
import org.testng.annotations.Test;

import static com.opencart.enums.URLs.BASE_URL;

public class UserForgottenPasswordTest extends BaseTest {

    @Test
    public void UserForgetPasswordWithValidData() throws Exception{
        new Navigation().navigateToURrl(BASE_URL.getValue());
        new MainPageBL()
                .getHeaderPageBL()
                .clickOnMyAccountButton()
                .clickOnLoginButton();
        new LoginPageBL()
                .clickOnForgottenPassword();
        new ForgottenPasswordPageBL()
                .resetPassword()
                .verifyForgottenPasswordText();
    }
}
