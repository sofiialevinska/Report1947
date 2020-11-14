package com.opencart.tests.editAccount;

import org.testng.annotations.Test;

public class ChangePassword extends LoginUsingValidData_Logout {

    @Test
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
