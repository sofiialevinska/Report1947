package com.opencart.tests.userRegister;

import com.opencart.navigation.Navigation;
import com.opencart.steps.MainPageBL;
import com.opencart.steps.RegisterPageBL;
import com.opencart.tests.BaseTest;
import org.testng.annotations.Test;

import static com.opencart.enums.URLs.BASE_URL;

public class RegisterUserWithoutPrivacyPolicy extends BaseTest {

    @Test
    public void registerUserWithoutPrivacyPolicy() {
        new Navigation().navigateToURrl(BASE_URL.getValue());
        MainPageBL mainPageBL = new MainPageBL();
        RegisterPageBL registerPageBL = mainPageBL.getHeaderPageBL()
                .clickOnMyAccountButton()
                .clickOnRegisterButton()
                .registerNewPersonWithoutPrivacyPolicy();
        registerPageBL.verifyPrivatePolicyWarning();
    }
}
