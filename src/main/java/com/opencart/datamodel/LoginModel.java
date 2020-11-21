package com.opencart.datamodel;

public class LoginModel {

    private final String email = "dfghszdfgh@gmail.com";
    private final String newEmail = "newEmail@gmail.com";
    private final String password = "dfghszdfgh";
    private final String newPassword = "newPassword";
    private final String newFirstName = "NewFirstName";
    private String wrongEmail = "uiu1@k.o";
    private String wrongPassword = "12345678";

    public String getWrongEmail() {
        return wrongEmail;
    }

    public String getWrongPassword() {
        return wrongPassword;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getNewFirstName() {
        return newFirstName;
    }

    public String getNewEmail() {
        return newEmail;
    }

    public String getNewPassword() {
        return newPassword;
    }
}
