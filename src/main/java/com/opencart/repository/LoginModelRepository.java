package com.opencart.repository;

import com.opencart.datamodel.LoginModel;

public class LoginModelRepository {

    private LoginModelRepository() {
    }

    public static LoginModel getValidLoginModel() {
        return LoginModel.getBuilder()
                .email("dfghszdfgh@gmail.com")
                .password("dfghszdfgh")
                .build();
    }

    public static LoginModel getLoginModelWithoutEmail() {
        return LoginModel.getBuilder()
                .email("")
                .password("dfghszdfgh")
                .build();
    }

    public static LoginModel getLoginWithoutPassword() {
        return LoginModel.getBuilder()
                .email("dfghszdfgh@gmail.com")
                .password("")
                .build();
    }

    public static LoginModel getLoginWithInvalidData() {
        return LoginModel.getBuilder()
                .email("uiu1@k.o")
                .password("12345678")
                .build();
    }

    public static LoginModel getLoginWithoutData() {
        return LoginModel.getBuilder()
                .email("")
                .password("")
                .build();
    }
}