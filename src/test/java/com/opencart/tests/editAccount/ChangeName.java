package com.opencart.tests.editAccount;

import org.testng.annotations.Test;

public class ChangeName extends LoginUsingValidData_Logout {

    @Test
    public void changeUserName() {
        accountDashboardBL
                .clickOnEditAccountButton()
                .setNewName()
                .verifyAccountEdit();
    }
}
