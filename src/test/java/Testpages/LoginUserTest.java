package Testpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.RegisterPage;

import java.time.Duration;

public class LoginUserTest {
    private WebDriver driver;
    private static final String URL = "http://automationexercise.com";

    private String generatedEmail; // Dynamically generated email
    private final String name = "usertest";
    private final String password = "password12300";

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); // Implicit wait for all interactions
        generatedEmail = System.currentTimeMillis() + "@example.com";
        System.out.println("Generated Email: " + generatedEmail); // Log the generated email
    }

    @Test(priority = 1)
    public void registerUserTest() {
        driver.get(URL);

        RegisterPage registerPage = new RegisterPage(driver);

        // Step 1: Navigate to 'Signup/Login' page
        registerPage.navigateToSignupLogin();

        // Step 2: Verify 'New User Signup!' is visible
        Assert.assertTrue(registerPage.isNewUserSignupVisible(), "'New User Signup!' is not visible.");

        // Step 3: Enter name and email
        registerPage.enterNameAndEmail(name, generatedEmail);

        // Step 4: Click 'Signup' button
        registerPage.clickSignupButton();

        // Step 5: Verify 'Enter Account Information' is visible
        Assert.assertTrue(registerPage.isEnterAccountInfoVisible(), "'Enter Account Information' is not visible.");

        // Step 6: Fill in account details
        registerPage.fillAccountDetails(
                password,
                "Test",
                "User",
                "Test Address",
                "India",
                "Test State",
                "Test City",
                "123456",
                "9876543210"
        );

        // Step 7: Click 'Create Account' button
        registerPage.clickCreateAccountButton();

        // Step 8: Verify 'ACCOUNT CREATED!' message is visible
        Assert.assertTrue(registerPage.isAccountCreatedVisible(), "'ACCOUNT CREATED!' message is not visible.");

        // Step 9: Click 'Continue' button
        registerPage.clickContinueButton();

        // Step 10: Log out
        registerPage.clickLogoutButton();
    }

    @Test(priority = 2)
    public void loginUserTest() throws InterruptedException {
        // Add explicit wait before starting the second test
        Thread.sleep(3000); // Simple wait (3 seconds), replaceable with WebDriverWait if specific conditions need to be checked

        driver.get(URL);

        LoginPage loginPage = new LoginPage(driver);

        // Verify home page is visible
        //assert loginPage.isHomePageVisible() : "Home page is not visible";

          // Click 'Signup / Login' button
        loginPage.clickSignupLoginButton();
        // Step 1: Navigate to 'Signup/Login' page and login
        loginPage.login(generatedEmail, password);

        // Step 2: Verify 'Logged in as username' is visible
        Assert.assertTrue(loginPage.isLoggedInAsVisible(), "'Logged in as username' is not visible.");

        // Step 3: Click 'Delete Account' button
        loginPage.deleteAccount();

        // Step 4: Verify 'ACCOUNT DELETED!' message is visible
        Assert.assertTrue(loginPage.isAccountDeletedVisible(), "'ACCOUNT DELETED!' message is not visible.");
        //step 5
      // Assert.assertTrue(loginPage.go_to_homepage());
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }


}
