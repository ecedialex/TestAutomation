package Pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage {
    WebDriver driver;

    @FindBy(id = "username")
    WebElement userNameInput;

    @FindBy(xpath = "//*[@id=\"svelte\"]/div[1]/div[2]/div[2]/div/div/div/form/div[1]/small[2]")
    WebElement userNameErrElement;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean open(String url) {
        if (driver == null) return false;
        driver.get(url);
        return true;
    }

    public void insertValueIntoInputElement(WebElement inputElement, String value) {
        inputElement.clear();
        inputElement.sendKeys(value);
    }

    public void insertUserName(String value) {
        System.out.println("Username input" + userNameInput);
        insertValueIntoInputElement(userNameInput, value);
    }

    public void registerNewUser(String username, String password, String confirmationPassword, String gender,
                                String firstName, String lastName, String email, String dateOfBirth, String nationality, boolean termsAndConditionsSelected) {
        insertUserName(username);
    }

    public boolean checkErr(String expectedErr, String errorType) {
        switch (errorType) {
            case "userErr":
                String error = "";
                try{
                    error = userNameErrElement.getText();
                } catch (NoSuchElementException e) {

                }
                return expectedErr.equalsIgnoreCase(error);
            default:
                return false;
        }
    }
}
