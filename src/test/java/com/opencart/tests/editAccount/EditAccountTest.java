package com.opencart.tests.editAccount;

import com.opencart.datamodel.LoginModel;
import com.opencart.navigation.Navigation;
import com.opencart.repository.LoginModelRepository;
import com.opencart.steps.AccountDashboardBL;
import com.opencart.steps.HeaderPageBL;
import com.opencart.steps.LoginPageBL;
import com.opencart.steps.MainPageBL;
import com.opencart.tests.BaseTest;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import jdk.jfr.Description;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.opencart.enums.URLs.BASE_URL;

public class EditAccountTest extends BaseTest {

    private MainPageBL mainPageBL;
    private HeaderPageBL headerPageBL;
    private LoginPageBL loginPageBL;
    private AccountDashboardBL accountDashboardBL;
    private LoginModel loginModel;
    private final String newPassword = "newPassword";
    private final String newEmail = "newemail@gmail.com";

    @Description("Method logins to valid user account")
    @BeforeMethod (alwaysRun = true)
    public void loginUsingValidData() {
        new Navigation().navigateToURrl(BASE_URL.getValue());
        mainPageBL = new MainPageBL();
        headerPageBL = mainPageBL.getHeaderPageBL();
        accountDashboardBL = new AccountDashboardBL();
        loginPageBL = new LoginPageBL();
        mainPageBL
                .getHeaderPageBL()
                .clickOnMyAccountButton()
                .clickOnLoginButton();
        loginModel = LoginModelRepository.getValidLoginModel();
        loginPageBL.userLogin(loginModel);
    }

    @Severity(value = SeverityLevel.CRITICAL)
    @Test(description = "Test checks if customer can change email to newEmail, logout and login\n" +
            "with newEmail and change email to previousEmail")
    public void changeUserEmailVerifyLogin() {
        accountDashboardBL
                .clickOnEditAccountButton()
                .setNewEmail(newEmail)
                .verifyAccountEdit();
        loginModel = LoginModelRepository.getValidLoginModel ();
        loginModel.setEmail(newEmail);
        headerPageBL
                .clickOnMyAccountButton()
                .clickOnLogoutButton()
                .clickOnMyAccountButton()
                .clickOnLoginButton();
        loginPageBL.userLogin(loginModel);
        accountDashboardBL
                .clickOnEditAccountButton()
                .returnOldEmail()
                .verifyAccountEdit();
    }

    @Severity(value = SeverityLevel.CRITICAL)
    @Test(description = "Test checks if customer can change Password to newPassword, logout and\n" +
            "login with newPassword and change Password to previousPassword")
    public void changePasswordVerifyLogin() {
        accountDashboardBL
                .clickOnEditPasswordButton()
                .setNewPassword(newPassword)
                .verifyPasswordEdit();
        loginModel = LoginModelRepository.getValidLoginModel ();
        loginModel.setPassword(newPassword);
        headerPageBL
                .clickOnMyAccountButton()
                .clickOnLogoutButton()
                .clickOnMyAccountButton()
                .clickOnLoginButton();
        loginPageBL.userLogin(loginModel);
        accountDashboardBL
                .clickOnEditPasswordButton()
                .returnOldPassword()
                .verifyPasswordEdit();
    }

    @Severity(value = SeverityLevel.MINOR)
    @Test(description = "Test checks if customer can change First Name to new First Name")
    public void changeUserName() {
        accountDashboardBL
                .clickOnEditAccountButton()
                .setNewName()
                .verifyAccountEdit();
    }

    @Severity(value = SeverityLevel.TRIVIAL)
    @Test (description = "Test checks if customer can change subscription settings to opposite and verify the change")
    public void changeSubscription () {
        accountDashboardBL
                .clickOnEditSubscriptionButton()
                .chooseOtherSubscription()
                .verifySubscriptionEdit();
    }

    @Description("Method logouts from user account")
    @AfterMethod (alwaysRun = true)
    public void logout() {
        headerPageBL
                .clickOnMyAccountButton()
                .clickOnLogoutButton();
    }
}