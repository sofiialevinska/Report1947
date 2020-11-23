import com.opencart.datamodel.RegisterModel;
import com.opencart.navigation.Navigation;
import com.opencart.repository.RegisterModelRepository;
import com.opencart.steps.MainPageBL;
import com.opencart.steps.RegisterPageBL;
import com.opencart.tests.BaseTest;
import org.apache.regexp.RE;
import org.testng.annotations.Test;

import static com.opencart.enums.URLs.BASE_URL;

public class UserRegisterTest extends BaseTest {

    @Test
    public void registerUserWithValidParameters(){
        new Navigation().navigateToURrl(BASE_URL.getValue());
        MainPageBL mainPageBL = new MainPageBL();
        RegisterModel registerModel = RegisterModelRepository.getRegisterModel();
        RegisterPageBL registerPageBL = mainPageBL.getHeaderPageBL()
                .clickOnMyAccountButton()
                .clickOnRegisterButton()
                .userRegister(registerModel)
                .clickPolicyCheckbox()
                .clickOnContinueButton();
        registerPageBL.verifyUserRegistration();
    }


    @Test
    public void registerUserWithoutTelephone() {
        new Navigation().navigateToURrl(BASE_URL.getValue());
        MainPageBL mainPageBL = new MainPageBL();
        RegisterModel registerModel = RegisterModelRepository.getRegisterModelWithoutTelephone();
        RegisterPageBL registerPageBL = mainPageBL.getHeaderPageBL()
                .clickOnMyAccountButton()
                .clickOnRegisterButton()
                .userRegister(registerModel)
                .clickPolicyCheckbox()
                .clickOnContinueButton();
        registerPageBL.verifyTelephoneTextError();
    }

    @Test
    public void registerUserWithoutPrivacyPolicy() {
        new Navigation().navigateToURrl(BASE_URL.getValue());
        MainPageBL mainPageBL = new MainPageBL();
        RegisterModel registerModel = RegisterModelRepository.getRegisterModel();
        RegisterPageBL registerPageBL = mainPageBL.getHeaderPageBL()
                .clickOnMyAccountButton()
                .clickOnRegisterButton()
                .userRegister(registerModel)
                .clickOnContinueButton();
        registerPageBL.verifyPrivatePolicyWarning();
    }

    @Test
    public void registerUserWithoutName() {
        new Navigation().navigateToURrl(BASE_URL.getValue());
        MainPageBL mainPageBL = new MainPageBL();
        RegisterModel registerModel = RegisterModelRepository.getRegisterModelWithoutFirstName();
        RegisterPageBL registerPageBL = mainPageBL.getHeaderPageBL()
                .clickOnMyAccountButton()
                .clickOnRegisterButton()
                .userRegister(registerModel)
                .clickPolicyCheckbox()
                .clickOnContinueButton();
        registerPageBL.verifyNameTextError();
    }

    @Test
    public void registerUserWithoutLastName() {
        new Navigation().navigateToURrl(BASE_URL.getValue());
        MainPageBL mainPageBL = new MainPageBL();
        RegisterModel registerModel = RegisterModelRepository.getRegisterModelWithoutLastName();
        RegisterPageBL registerPageBL = mainPageBL.getHeaderPageBL()
                .clickOnMyAccountButton()
                .clickOnRegisterButton()
                .userRegister(registerModel)
                .clickPolicyCheckbox()
                .clickOnContinueButton();
        registerPageBL.verifyLastNameTextError();
    }

    @Test
    public void registerUserWithoutEmail() {
        new Navigation().navigateToURrl(BASE_URL.getValue());
        MainPageBL mainPageBL = new MainPageBL();
        RegisterModel registerModel = RegisterModelRepository.getRegisterModelWithoutEmail();
        RegisterPageBL registerPageBL = mainPageBL.getHeaderPageBL()
                .clickOnMyAccountButton()
                .clickOnRegisterButton()
                .userRegister(registerModel)
                .clickPolicyCheckbox()
                .clickOnContinueButton();
        registerPageBL.verifyEmailTextError();
    }

    @Test
    public void registerUserWithoutPassword() {
        new Navigation().navigateToURrl(BASE_URL.getValue());
        MainPageBL mainPageBL = new MainPageBL();
        RegisterModel registerModel = RegisterModelRepository.getRegisterModelWithoutPassword();
        RegisterPageBL registerPageBL = mainPageBL.getHeaderPageBL()
                .clickOnMyAccountButton()
                .clickOnRegisterButton()
                .userRegister(registerModel)
                .clickPolicyCheckbox()
                .clickOnContinueButton();
        registerPageBL.verifyPasswordTextError();
    }

    @Test
    public void registerUserWithoutVerifyPassword() {
        new Navigation().navigateToURrl(BASE_URL.getValue());
        MainPageBL mainPageBL = new MainPageBL();
        RegisterModel registerModel = RegisterModelRepository.getRegisterModelWithoutPasswordConfirm();
        RegisterPageBL registerPageBL = mainPageBL.getHeaderPageBL()
                .clickOnMyAccountButton()
                .clickOnRegisterButton()
                .userRegister(registerModel)
                .clickPolicyCheckbox()
                .clickOnContinueButton();
        registerPageBL.verifyConfirmPasswordTextError();
    }

    @Test
    public void registerUserWithEmptyFields() {
        new Navigation().navigateToURrl(BASE_URL.getValue());
        MainPageBL mainPageBL = new MainPageBL();
        RegisterModel registerModel = RegisterModelRepository.getRegisterModelWithEmptyFields();
        RegisterPageBL registerPageBL = mainPageBL.getHeaderPageBL()
                .clickOnMyAccountButton()
                .clickOnRegisterButton()
                .userRegister(registerModel)
                .clickOnContinueButton();
        registerPageBL.verifyAllFieldsEmptyError();
    }

    @Test
    public void registerUserWithDifferentPasswords() {
        new Navigation().navigateToURrl(BASE_URL.getValue());
        MainPageBL mainPageBL = new MainPageBL();
        RegisterModel registerModel = RegisterModelRepository.getRegisterModelWithDifferentPasswords();
        RegisterPageBL registerPageBL = mainPageBL.getHeaderPageBL()
                .clickOnMyAccountButton()
                .clickOnRegisterButton()
                .userRegister(registerModel)
                .clickOnContinueButton();
        registerPageBL.verifyDifferentPasswordsError();
    }

    @Test
    public void registerUserWithNotValidEmail() {
        new Navigation().navigateToURrl(BASE_URL.getValue());
        MainPageBL mainPageBL = new MainPageBL();
        RegisterModel registerModel = RegisterModelRepository.getRegisterModelWithNotValidEmail();
        RegisterPageBL registerPageBL = mainPageBL.getHeaderPageBL()
                .clickOnMyAccountButton()
                .clickOnRegisterButton()
                .userRegister(registerModel)
                .clickOnContinueButton();
        registerPageBL.verifyNotValidEmail();
    }

    @Test
    public void registerUserWithNotValidDataLength() {
        new Navigation().navigateToURrl(BASE_URL.getValue());
        MainPageBL mainPageBL = new MainPageBL();
        RegisterModel registerModel = RegisterModelRepository.getRegistrationModelWithNotValidLength();
        RegisterPageBL registerPageBL = mainPageBL.getHeaderPageBL()
                .clickOnMyAccountButton()
                .clickOnRegisterButton()
                .userRegister(registerModel)
                .clickOnContinueButton();
        registerPageBL.verifyNotValidDataLength();
    }
}