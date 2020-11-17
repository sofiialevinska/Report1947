package com.opencart.tests.editAccount;

import org.testng.annotations.Test;

public class ChangeName extends LoginUsingValidData_Logout {

    @Test (description = "Test checks if customer can change First Name to new First Name.")
    public void changeUserName() {
        accountDashboardBL
                .clickOnEditAccountButton()
                .setNewName()
                .verifyAccountEdit();
    }
}
