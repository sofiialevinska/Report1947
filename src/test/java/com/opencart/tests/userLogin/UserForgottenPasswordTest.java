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
        MainPageBL mainPageBL = new MainPageBL();
        ForgottenPasswordPageBL forgottenPasswordPageBL = mainPageBL.getHeaderPageBL()
                .clickOnMyAccountButton()
                .clickOnLoginButton()
                .clickOnForgottenPassword();
        forgottenPasswordPageBL.resetPassword().verifyForgottenPasswordText();
    }
}
