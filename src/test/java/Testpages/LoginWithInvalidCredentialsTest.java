package Testpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.time.Duration;

public class LoginWithInvalidCredentialsTest {
    private WebDriver driver;
    private static final String URL = "http://automationexercise.com";

    private final String incorrectEmail = "invaliduser@example.com"; // Wrong email
    private final String incorrectPassword = "wrongpassword123"; // Wrong password

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); // Implicit wait
    }

    @Test(priority = 1)
    public void loginWithIncorrectCredentialsTest() {
        driver.get(URL);
        LoginPage loginPage = new LoginPage(driver);

        // Click 'Signup / Login' button
        loginPage.clickSignupLoginButton();

        // Enter incorrect credentials
        loginPage.login(incorrectEmail, incorrectPassword);

        // Verify error message is displayed
        Assert.assertTrue(loginPage.isIncorrectLoginMessageVisible(), "'Your email or password is incorrect!' message is not visible.");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
