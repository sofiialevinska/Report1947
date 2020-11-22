package com.opencart.datamodel;


public class LoginModel {

    private String email;
    private String password;

    public LoginModel() {
    }

    public static LoginModel.Builder getBuilder() {
        return new LoginModel().new Builder();
    }

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

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}

