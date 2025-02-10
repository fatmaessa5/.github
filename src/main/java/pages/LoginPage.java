package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    // Locators
    //private By homePageVisible = By.xpath("//h1[contains(text(), 'Welcome')]"); // Replace with an actual unique element from the home page
    private By signupLoginButton = By.xpath("//a[contains(text(),'Signup / Login')]");
    private By emailField = By.xpath("//input[@data-qa='login-email']");
    private By passwordField = By.xpath("//input[@data-qa='login-password']");
    private By loginButton = By.xpath("//button[@data-qa='login-button']");
    private By loggedInAs = By.xpath("//a[i[contains(@class,'fa-user')]and contains(.,'Logged in as')]");
    private By deleteAccountButton = By.linkText("Delete Account");
    private By accountDeletedMessage = By.cssSelector("b");
    //private By continuetohome=By.xpath("//a[@class=btn btn-primary]");
    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

   /* @Step("Verify that the home page is visible successfully")
    public boolean isHomePageVisible() {
        return driver.findElement(homePageVisible).isDisplayed();
    }*/

    @Step("Click on 'Signup / Login' button")
    public void clickSignupLoginButton() {
        driver.findElement(signupLoginButton).click();
    }

    @Step("Login with email: {email} and password")
    public void login(String email, String password) {
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    @Step("Verify 'Logged in as username' is visible")
    public boolean isLoggedInAsVisible() {
        return driver.findElement(loggedInAs).isDisplayed();
    }

    @Step("Click 'Delete Account' button")
    public void deleteAccount() {
        driver.findElement(deleteAccountButton).click();
    }

    @Step("Verify 'ACCOUNT DELETED!' message is visible")
    public boolean isAccountDeletedVisible() {
        return driver.findElement(accountDeletedMessage).isDisplayed();
    }
   /* @Step("Verify 'ACCOUNT DELETED!' go to home")
    public boolean go_to_homepage() {
         driver.findElement(continuetohome).click();
        return false;
    }*/
   @Step("Verify 'Your email or password is incorrect!' error message is visible")
   public boolean isIncorrectLoginMessageVisible() {
       By errorMessage = By.xpath("//p[contains(text(),'Your email or password is incorrect!')]");
       return driver.findElement(errorMessage).isDisplayed();
   }

}
