package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage {
    private WebDriver driver;

    // Locators
    private By signupLoginButton = By.linkText("Signup / Login");
    private By newUserSignupHeader = By.xpath("//h2[text()='New User Signup!']");
    private By nameField = By.xpath("//input[@data-qa='signup-name']");
    private By emailField = By.xpath("//input[@data-qa='signup-email']");
    private By signupButton = By.xpath("//button[@data-qa='signup-button']");
    private By enterAccountInfoHeader = By.xpath("//b[text()='Enter Account Information']");
    private By passwordField = By.xpath("//input[@id='password']");
    private By firstNameField = By.xpath("//input[@id='first_name']");
    private By lastNameField = By.xpath("//input[@id='last_name']");
    private By addressField = By.xpath("//input[@id='address1']");
    private By countryDropdown = By.xpath("//select[@id='country']");
    private By stateField = By.xpath("//input[@id='state']");
    private By cityField = By.xpath("//input[@id='city']");
    private By zipcodeField = By.xpath("//input[@id='zipcode']");
    private By mobileNumberField = By.xpath("//input[@id='mobile_number']");
    private By createAccountButton = By.xpath("//button[@data-qa='create-account']");
    private By accountCreatedMessage = By.xpath("//h2[@data-qa='account-created']//b");
    private By continueButton = By.xpath("//a[@data-qa='continue-button']");
    //private By loggedInAs = By.xpath("//a[i[contains(@class, 'fa-user')] and contains(., 'Logged in as') and contains(.,'fatma essa')]");
    private By logoutButton = By.linkText("Logout");

    // Constructor
    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    // Methods
    @Step("Navigate to the Signup/Login page")
    public void navigateToSignupLogin() {
        driver.findElement(signupLoginButton).click();
    }

    @Step("Verify 'New User Signup!' is visible")
    public boolean isNewUserSignupVisible() {
        return driver.findElement(newUserSignupHeader).isDisplayed();
    }

    @Step("Enter Name: {name} and Email: {email}")
    public void enterNameAndEmail(String name, String email) {
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(emailField).sendKeys(email);
    }

    @Step("Click Signup button")
    public void clickSignupButton() {
        driver.findElement(signupButton).click();
    }

    @Step("Verify 'Enter Account Information' is visible")
    public boolean isEnterAccountInfoVisible() {
        return driver.findElement(enterAccountInfoHeader).isDisplayed();
    }

    @Step("Fill account details")
    public void fillAccountDetails(String password, String firstName, String lastName, String address, String country, String state, String city, String zipcode, String mobileNumber) {
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(firstNameField).sendKeys(firstName);
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(addressField).sendKeys(address);
        driver.findElement(countryDropdown).sendKeys(country);
        driver.findElement(stateField).sendKeys(state);
        driver.findElement(cityField).sendKeys(city);
        driver.findElement(zipcodeField).sendKeys(zipcode);
        driver.findElement(mobileNumberField).sendKeys(mobileNumber);
    }

    @Step("Click 'Create Account' button")
    public void clickCreateAccountButton() {
        driver.findElement(createAccountButton).click();
    }

    @Step("Verify 'ACCOUNT CREATED!' message is visible")
    public boolean isAccountCreatedVisible() {
        return driver.findElement(accountCreatedMessage).isDisplayed();
    }

    @Step("Click Continue button")
    public void clickContinueButton() {
        driver.findElement(continueButton).click();
    }

    /*@Step("Verify 'Logged in as username' is visible")
    public boolean isLoggedInAsVisible() {
        return driver.findElement(loggedInAs).isDisplayed();
    }*/

    @Step("Log out from the application")
    public void clickLogoutButton() {
        driver.findElement(logoutButton).click();
    }


}
