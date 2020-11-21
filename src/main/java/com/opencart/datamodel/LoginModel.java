package com.opencart.datamodel;


public class LoginModel {

    private String email = "dfghszdfgh@gmail.com";
    private String newEmail = "newEmail@gmail.com";
    private String password = "dfghszdfgh";
    private String newPassword = "newPassword";
    private String newFirstName = "NewFirstName";
    private String wrongEmail = "uiu1@k.o";
    private String wrongPassword = "12345678";

    public LoginModel() {
    }

    public static LoginModel.Builder getBuilder() {return new LoginModel().new Builder();}

    public class Builder {
        public LoginModel.Builder email(String value) {
            email = value;
            return this;
        }

        public LoginModel.Builder password(String value) {
            password = value;
            return this;
        }

        public LoginModel build() {
            return LoginModel.this;
        }
    }

    public String getWrongPassword() {
        return wrongPassword;
    }

    public String getWrongEmail() {
        return wrongEmail;
    }

    public String getEmail() {
        return email;
    }

    public String getNewEmail() {
        return newEmail;
    }

    public String getNewFirstName() {
        return newFirstName;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public String getPassword() {
        return password;
    }
}

