package com.opencart.repository;

import com.opencart.datamodel.RegisterModel;
import org.apache.commons.lang3.RandomStringUtils;


public class RegisterModelRepository {

    private RegisterModelRepository() {
    }

    public static RegisterModel getRegisterModel() {
        String password = RandomStringUtils.randomAlphabetic(7);
        return RegisterModel.getBuilder()
                .firstName(RandomStringUtils.randomAlphabetic(5))
                .lastName(RandomStringUtils.randomAlphabetic(5))
                .email(RandomStringUtils.randomAlphabetic(5) + "@gmail.com")
                .telephone(RandomStringUtils.randomNumeric(10))
                .password(password)
                .passwordConfirm(password)
                .build();
    }



    public static RegisterModel getRegisterModelWithoutFirstName() {
        String password = RandomStringUtils.randomAlphabetic(7);
        return RegisterModel.getBuilder()
                .firstName(RandomStringUtils.randomAlphabetic(0))
                .lastName(RandomStringUtils.randomAlphabetic(5))
                .email(RandomStringUtils.randomAlphabetic(5) + "@gmail.com")
                .telephone(RandomStringUtils.randomNumeric(10))
                .password(password)
                .passwordConfirm(password)
                .build();
    }

    public static RegisterModel getRegisterModelWithoutLastName() {
        String password = RandomStringUtils.randomAlphabetic(7);
        return RegisterModel.getBuilder()
                .firstName(RandomStringUtils.randomAlphabetic(5))
                .lastName(RandomStringUtils.randomAlphabetic(0))
                .email(RandomStringUtils.randomAlphabetic(5) + "@gmail.com")
                .telephone(RandomStringUtils.randomNumeric(10))
                .password(password)
                .passwordConfirm(password)
                .build();
    }

    public static RegisterModel getRegisterModelWithoutEmail() {
        String password = RandomStringUtils.randomAlphabetic(7);
        return RegisterModel.getBuilder()
                .firstName(RandomStringUtils.randomAlphabetic(5))
                .lastName(RandomStringUtils.randomAlphabetic(5))
                .email(RandomStringUtils.randomAlphabetic(0))
                .telephone(RandomStringUtils.randomNumeric(10))
                .password(password)
                .passwordConfirm(password)
                .build();
    }

    public static RegisterModel getRegisterModelWithoutTelephone() {
        String password = RandomStringUtils.randomAlphabetic(7);
        return RegisterModel.getBuilder()
                .firstName(RandomStringUtils.randomAlphabetic(5))
                .lastName(RandomStringUtils.randomAlphabetic(5))
                .email(RandomStringUtils.randomAlphabetic(5) + "@gmail.com")
                .telephone(RandomStringUtils.randomNumeric(0))
                .password(password)
                .passwordConfirm(password)
                .build();
    }

    public static RegisterModel getRegisterModelWithoutPassword() {
        return RegisterModel.getBuilder()
                .firstName(RandomStringUtils.randomAlphabetic(5))
                .lastName(RandomStringUtils.randomAlphabetic(5))
                .email(RandomStringUtils.randomAlphabetic(5) + "@gmail.com")
                .telephone(RandomStringUtils.randomNumeric(10))
                .password(RandomStringUtils.randomAlphabetic(0))
                .passwordConfirm(RandomStringUtils.randomAlphabetic(0))
                .build();
    }

    public static RegisterModel getRegisterModelWithoutPasswordConfirm() {
        return RegisterModel.getBuilder()
                .firstName(RandomStringUtils.randomAlphabetic(5))
                .lastName(RandomStringUtils.randomAlphabetic(5))
                .email(RandomStringUtils.randomAlphabetic(5) + "@gmail.com")
                .telephone(RandomStringUtils.randomNumeric(10))
                .password(RandomStringUtils.randomAlphabetic(5))
                .passwordConfirm(RandomStringUtils.randomAlphabetic(0))
                .build();
    }

    public static RegisterModel getRegisterModelWithEmptyFields() {
        return RegisterModel.getBuilder()
        .firstName(RandomStringUtils.randomAlphabetic(0))
                .lastName(RandomStringUtils.randomAlphabetic(0))
                .email(RandomStringUtils.randomAlphabetic(0))
                .telephone(RandomStringUtils.randomNumeric(0))
                .password(RandomStringUtils.randomAlphabetic(0))
                .passwordConfirm(RandomStringUtils.randomAlphabetic(0))
                .build();
    }

    public static RegisterModel getRegisterModelWithDifferentPasswords() {
        return RegisterModel.getBuilder()
                .firstName(RandomStringUtils.randomAlphabetic(5))
                .lastName(RandomStringUtils.randomAlphabetic(5))
                .email(RandomStringUtils.randomAlphabetic(5) + "@gmail.com")
                .telephone(RandomStringUtils.randomNumeric(10))
                .password(RandomStringUtils.randomAlphabetic(6))
                .passwordConfirm(RandomStringUtils.randomAlphabetic(6))
                .build();
    }

    public static RegisterModel getRegisterModelWithNotValidEmail() {
        String password = RandomStringUtils.randomAlphabetic(10);
        return RegisterModel.getBuilder()
                .firstName(RandomStringUtils.randomAlphabetic(5))
                .lastName(RandomStringUtils.randomAlphabetic(5))
                .email("!#$%^&*||@j.ia")
                .telephone(RandomStringUtils.randomNumeric(10))
                .password(password)
                .passwordConfirm(password)
                .build();
    }

    public static RegisterModel getRegistrationModelWithNotValidLength() {
        String password = RandomStringUtils.randomAlphabetic(3);
        String emailBreaker =
                "superdima2020undefeatedtanoskillertonystarkisnotdeadwhyicanentertheresomuchsymbols@gmail.com";
        return RegisterModel.getBuilder()
                .firstName(RandomStringUtils.randomAlphabetic(33))
                .lastName(RandomStringUtils.randomAlphabetic(33))
                .email(emailBreaker)
                .telephone(RandomStringUtils.randomNumeric(33))
                .password(password)
                .passwordConfirm(password)
                .build();
    }

}