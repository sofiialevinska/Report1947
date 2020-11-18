package com.opencart.tests.userRegister;

import com.opencart.navigation.Navigation;
import com.opencart.steps.MainPageBL;
import com.opencart.steps.RegisterPageBL;
import com.opencart.tests.BaseTest;
import org.testng.annotations.Test;

import static com.opencart.enums.URLs.BASE_URL;

public class UserRegisterTest extends BaseTest {

    @Test
    public void registerUserWithValidParameters() {
        new Navigation().navigateToURrl(BASE_URL.getValue());
        MainPageBL mainPageBL = new MainPageBL();
        RegisterPageBL registerPageBL = mainPageBL.getHeaderPageBL()
                .clickOnMyAccountButton()
                .clickOnRegisterButton()
                .registerNewPerson();
        registerPageBL.verifyUserRegistration();
    }

    @Test
    public void registerUserWithoutTelephone() {
        new Navigation().navigateToURrl(BASE_URL.getValue());
        MainPageBL mainPageBL = new MainPageBL();
        RegisterPageBL registerPageBL = mainPageBL.getHeaderPageBL()
                .clickOnMyAccountButton()
                .clickOnRegisterButton()
                .regiterNewPersonWithoutTelephone();
        registerPageBL.verifyTelephoneTextError();
    }

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

    @Test
    public void registerUserWithoutName() {
        new Navigation().navigateToURrl(BASE_URL.getValue());
        MainPageBL mainPageBL = new MainPageBL();
        RegisterPageBL registerPageBL = mainPageBL.getHeaderPageBL()
                .clickOnMyAccountButton()
                .clickOnRegisterButton()
                .registerNewPersonWithoutName();
        registerPageBL.verifyNameTextError();
    }

    @Test
    public void registerUserWithoutLastName() {
        new Navigation().navigateToURrl(BASE_URL.getValue());
        MainPageBL mainPageBL = new MainPageBL();
        RegisterPageBL registerPageBL = mainPageBL.getHeaderPageBL()
                .clickOnMyAccountButton()
                .clickOnRegisterButton()
                .registerNewPersonWithoutLastName();
        registerPageBL.verifyLastNameTextError();
    }

    @Test
    public void registerUserWithoutEmail() {
        new Navigation().navigateToURrl(BASE_URL.getValue());
        MainPageBL mainPageBL = new MainPageBL();
        RegisterPageBL registerPageBL = mainPageBL.getHeaderPageBL()
                .clickOnMyAccountButton()
                .clickOnRegisterButton()
                .registerNewPersonWithoutEmail();
        registerPageBL.verifyEmailTextError();
    }


}