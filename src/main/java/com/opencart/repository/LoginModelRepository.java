package com.opencart.repository;

import com.opencart.datamodel.LoginModel;

public class LoginModelRepository {

    private LoginModelRepository() {
    }

    public static LoginModel getValidLoginModel() {
        LoginModel loginModel = new LoginModel();
        return LoginModel.getBuilder()
                .email(loginModel.getEmail())
                .password(loginModel.getPassword())
                .build();
    }

    public static LoginModel getLoginModelWithoutEmail() {
        LoginModel loginModel = new LoginModel();
        return LoginModel.getBuilder()
                .email("")
                .password(loginModel.getPassword())
                .build();
    }

    public static LoginModel getLoginWithoutPassword() {
        LoginModel loginModel = new LoginModel();
        return LoginModel.getBuilder()
                .email(loginModel.getEmail())
                .password("")
                .build();
    }

    public static LoginModel getLoginWithInvalidData() {
        LoginModel loginModel = new LoginModel();
        return LoginModel.getBuilder()
                .email(loginModel.getWrongEmail())
                .password(loginModel.getWrongPassword())
                .build();
    }

    public static LoginModel getLoginWithoutData() {
        return LoginModel.getBuilder()
                .email("")
                .password("")
                .build();
    }
}
