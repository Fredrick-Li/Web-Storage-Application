package Fredrick.Li.Personal.Cloud.Storage;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {

    @FindBy(id = "inputUsername")
    private WebElement usernameField;

    @FindBy(id = "inputPassword")
    private WebElement passwordField;

    @FindBy(id = "login-button")
    private WebElement buttonField;

    public void LoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public void login(String username, String password){
        this.usernameField.sendKeys(username);
        this.passwordField.sendKeys(password);
        this.buttonField.click();
    }
}
