package tests;

import DataProviders.SignUpDataProvider;
import Pages.SignUpPage;
import Utils.SeleniumUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignUpTest extends BaseUITest {

    @Test(dataProvider = "negativeSignUpDataProvider", dataProviderClass = SignUpDataProvider.class)
    public void testNegativeSignUp(String browserType, String username, String password, String gender, String confirmPassword,
                                   String firstName, String lastName, String email, String dateOfBirth, String nationality,
                                   boolean termsAndConditionSelected, String expectedUserNameErr, String expectedPasswordErr,
                                   String expectedConfirmationPasswordErr, String expectedFirstNameError, String expectedLastNameErr,
                                   String expectedEmailErr, String expectedTermsAndConditionErr) {

        driver = SeleniumUtils.getDriver(browserType);
        SignUpPage signUpPage = new SignUpPage(driver);

        signUpPage.open(signUpPageUrl);

        signUpPage.registerNewUser(username, password, confirmPassword, gender, firstName, lastName, email, dateOfBirth, nationality, termsAndConditionSelected);
        Assert.assertTrue(signUpPage.checkErr(expectedUserNameErr, "userErr"));

    }
}
