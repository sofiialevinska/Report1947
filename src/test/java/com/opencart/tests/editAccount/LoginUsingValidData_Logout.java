package com.opencart.tests.editAccount;

import com.opencart.navigation.Navigation;
import com.opencart.steps.AccountDashboardBL;
import com.opencart.steps.HeaderPageBL;
import com.opencart.steps.LoginPageBL;
import com.opencart.steps.MainPageBL;
import com.opencart.tests.BaseTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static com.opencart.enums.URLs.BASE_URL;

public class LoginUsingValidData_Logout extends BaseTest {

    protected MainPageBL mainPageBL;
    protected HeaderPageBL headerPageBL;
    protected LoginPageBL loginPageBL;
    protected AccountDashboardBL accountDashboardBL;

    @BeforeMethod
    public void loginUsingValidData() {
        new Navigation().navigateToURrl(BASE_URL.getValue());
        mainPageBL = new MainPageBL();
        headerPageBL = mainPageBL.getHeaderPageBL();
        loginPageBL = new LoginPageBL();
        accountDashboardBL = new AccountDashboardBL();
        headerPageBL
                .clickOnMyAccountButton()
                .clickOnLoginButton();
        loginPageBL
                .login();
    }

    @AfterMethod
    public void logout() {
        headerPageBL
                .clickOnMyAccountButton()
                .clickOnLogoutButton();
    }
}
