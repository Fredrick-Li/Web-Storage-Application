package Fredrick.Li.Personal.Cloud.Storage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignupPage {
    @FindBy(id = "inputFirstName")
    private WebElement FirstNameField;

    // debug
    @FindBy(id = "inputLastName")
    private WebElement LastNameField;

    @FindBy(id = "inputUsername")
    private WebElement UsernameField;

    @FindBy(id = "inputPassword")
    private WebElement PasswordField;

    @FindBy(id = "signup-button")
    private WebElement submitField;

    public SignupPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public void signUp(String firstName, String lastName, String username, String password){
        this.FirstNameField.sendKeys(firstName);
        this.LastNameField.sendKeys(lastName);
        this.UsernameField.sendKeys(username);
        this.PasswordField.sendKeys(password);
        this.submitField.click();
    }
}
