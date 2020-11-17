package com.opencart.steps;

import com.opencart.datamodel.RegisterModel;
import com.opencart.pages.RegisterPage;
import com.opencart.pages.SuccessRegisterPage;
import com.opencart.repository.RegisterModelRepository;
import com.opencart.util.DriverUtils;
import org.testng.Assert;

public class RegisterPageBL {

    private RegisterPage registerPage;
    private SuccessRegisterPage successRegisterPage;

    public RegisterPageBL() {
        registerPage = new RegisterPage();
    }

    public RegisterPageBL registerNewPerson() {
        RegisterModel registerModel = RegisterModelRepository.getRegisterModel();
        inputFirstName(registerModel.getFirstName());
        inputLastName(registerModel.getLastName());
        inputEmail(registerModel.getEmail());
        inputTelephone(registerModel.getTelephone());
        inputPassword(registerModel.getPassword());
        chooseSubscribe(1);
        clickPolicyCheckbox();
        clickOnContinueButton();

        successRegisterPage = new SuccessRegisterPage();
        return this;
    }

    public RegisterPageBL registerNewPersonWithoutPrivacyPolicy() {
        RegisterModel registerModel = RegisterModelRepository.getRegisterModel();
        inputFirstName(registerModel.getFirstName());
        inputLastName(registerModel.getLastName());
        inputEmail(registerModel.getEmail());
        inputTelephone(registerModel.getTelephone());
        inputPassword(registerModel.getPassword());
        clickOnContinueButton();

        return this;
    }

    public RegisterPageBL registerNewPersonWithoutName() {
        RegisterModel registerModel = RegisterModelRepository.getRegisterModel();
        inputLastName(registerModel.getLastName());
        inputEmail(registerModel.getEmail());
        inputTelephone(registerModel.getTelephone());
        inputPassword(registerModel.getPassword());
        clickPolicyCheckbox();
        clickOnContinueButton();
        return this;


    }

    public RegisterPageBL registerNewPersonWithoutLastName() {
        RegisterModel registerModel = RegisterModelRepository.getRegisterModel();
        inputFirstName(registerModel.getFirstName());
        inputEmail(registerModel.getEmail());
        inputTelephone(registerModel.getTelephone());
        inputPassword(registerModel.getPassword());
        clickPolicyCheckbox();
        clickOnContinueButton();
        return this;
    }

    public RegisterPageBL registerNewPersonWithoutEmail() {
        RegisterModel registerModel = RegisterModelRepository.getRegisterModel();
        inputFirstName(registerModel.getFirstName());
        inputLastName(registerModel.getLastName());
        inputTelephone(registerModel.getTelephone());
        inputPassword(registerModel.getPassword());
        clickPolicyCheckbox();
        clickOnContinueButton();
        return this;
    }

    public RegisterPageBL regiterNewPersonWithoutTelephone() {
        RegisterModel registerModel = RegisterModelRepository.getRegisterModel();
        inputFirstName(registerModel.getFirstName());
        inputLastName(registerModel.getLastName());
        inputEmail(registerModel.getEmail());
        inputPassword(registerModel.getPassword());
        clickPolicyCheckbox();
        clickOnContinueButton();
        return this;
    }

    private void inputFirstName(String firstName) {
        registerPage.getFirstNameInput().clear();
        registerPage.getFirstNameInput().sendKeys(firstName);
    }

    private void inputLastName(String lastName) {
        registerPage.getLastNameInput().clear();
        registerPage.getLastNameInput().sendKeys(lastName);
    }

    private void inputEmail(String email) {
        registerPage.getEmailInput().clear();
        registerPage.getEmailInput().sendKeys(email);
    }

    private void inputTelephone(String telephone) {
        registerPage.getTelephoneInput().clear();
        registerPage.getTelephoneInput().sendKeys(telephone);
    }

    private void inputPassword(String password) {
        registerPage.getPasswordInput().clear();
        registerPage.getPasswordInput().sendKeys(password);
        registerPage.getPasswordConfirmInput().clear();
        registerPage.getPasswordConfirmInput().sendKeys(password);
    }

    private void chooseSubscribe(int value) {
        new DriverUtils().clickOnElementJS(registerPage.getSubscribeRadioButton(value));
    }

    private void clickPolicyCheckbox() {
        new DriverUtils().clickOnElementJS(registerPage.getPolicy());
    }

    private void clickOnContinueButton() {
        registerPage.getContinueButton().click();
    }

    public void verifyUserRegistration() {
        String expectedMessage = "Your Account Has Been Created!";
        Assert.assertEquals(successRegisterPage.getSuccessTitle().getText(), expectedMessage, "Incorrect page title");
    }

    public void verifyPrivatePolicyWarning() {
        String expectedMessage = "Warning: You must agree to the Privacy Policy!";
        Assert.assertEquals(registerPage.getPrivacyPolicyWarning().getText(), expectedMessage, "The Privacy Policy is clicked");
    }

    public void verifyNameTextError() {
        String expectedMessage = "First Name must be between 1 and 32 characters!";
        Assert.assertEquals(registerPage.getNameErrorText().getText(), expectedMessage, "The name is correct");
    }

    public void verifyLastNameTextError() {
        String expectedMessage = "Last Name must be between 1 and 32 characters!";
        Assert.assertEquals(registerPage.getLastNameErrorText().getText(), expectedMessage, "The last name is correct");
    }

    public void verifyEmailTextError() {
        String expectedMessage = "E-Mail Address does not appear to be valid!";
        Assert.assertEquals(registerPage.getEmailErrorText().getText(), expectedMessage, "The email is correct");
    }

    public void verifyTelephoneTextError() {
        String expectedMessage = "Telephone must be between 3 and 32 characters!";
        Assert.assertEquals(registerPage.getTelephoneErrorText().getText(),
                expectedMessage, "The telephone number is correct");
    }
}