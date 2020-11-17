package com.opencart.tests.editAccount;

import org.testng.annotations.Test;

public class ChangePassword extends LoginUsingValidData_Logout {

    @Test (description = "Test checks if customer can change Password to new Password " +
            "and change it back to previous Password.")
    public void changePassword() {
        accountDashboardBL
                .clickOnEditPasswordButton()
                .setNewPassword()
                .verifyPasswordEdit()
                .clickOnEditPasswordButton()
                .returnOldPassword()
                .verifyPasswordEdit();
    }
}
