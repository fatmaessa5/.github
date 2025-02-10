package AutomationExerciseApi;


import org.testng.annotations.Test;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import java.util.UUID;
import io.qameta.allure.Description;

public class LoginTest {

    private String uniqueEmail;
    private String uniquePassword;

    @Test
    @Description("Register and Login with valid credentials")
    public void Register_andLogin_withValidCred() {
        uniqueEmail = "usernamee" + UUID.randomUUID().toString() + "@gmail.com";
        uniquePassword = "passwordd" + UUID.randomUUID().toString();

        // 1. Register the user
        given()
                .baseUri("https://automationexercise.com")
                .multiPart("name", "fatma")
                .multiPart("email", uniqueEmail)
                .multiPart("password", uniquePassword)
                .multiPart("title", "Mr")
                .multiPart("birth_date", "15")
                .multiPart("birth_month", "12")
                .multiPart("birth_year", "1899")
                .multiPart("firstname", "fatma")
                .multiPart("lastname", "mohammed")
                .multiPart("company", "ExampleCorp")
                .multiPart("address1", "123 Main St")
                .multiPart("address2", "Apt 2B")
                .multiPart("country", "United States")
                .multiPart("zipcode", "12345")
                .multiPart("state", "California")
                .multiPart("city", "sdfsd")
                .multiPart("mobile_number", "1234567890")
                .header("Content-Type", "multipart/form-data")
                .when().post("/api/createAccount");

        // 2. Now, try to log in with the same credentials
        Response response = given()
                .baseUri("https://automationexercise.com")
                .multiPart("email", uniqueEmail)
                .multiPart("password", uniquePassword)
                .header("Content-Type", "multipart/form-data")
                .when().post("/api/verifyLogin");

        String jsonResponse = response.getBody().asString();
        JsonPath jsonPath = new JsonPath(jsonResponse);

        assertThat(response.getStatusCode(), equalTo(200));
        assertThat(jsonPath.getString("message"), equalTo("User exists!"));
        assertThat(response.getTime(), lessThan(2000L));
        assertThat(jsonPath.getInt("responseCode"), equalTo(200));
    }
}