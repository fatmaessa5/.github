package AutomationExerciseApi;


import org.testng.annotations.Test;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import java.util.UUID;
import io.qameta.allure.Description;

public class InvalidLoginTest {

    private String uniquePassword;

    @Test
    @Description("Register with invalid credentials")
    public void Register_withInvalidCred() {
        String invalidEmail = "invalidusername" + UUID.randomUUID().toString() + "@gmail.com";
        uniquePassword = "passwordd" + UUID.randomUUID().toString();

        Response response = given()
                .baseUri("https://automationexercise.com")
                .multiPart("email", invalidEmail)
                .multiPart("password", uniquePassword)
                .header("Content-Type", "multipart/form-data")
                .when().post("/api/verifyLogin");

        String jsonResponse = response.getBody().asString();
        JsonPath jsonPath = new JsonPath(jsonResponse);

        assertThat(response.getStatusCode(), equalTo(200));
        assertThat(jsonPath.getString("message"), equalTo("User not found!"));
        assertThat(response.getTime(), lessThan(2000L));
        assertThat(jsonPath.getInt("responseCode"), equalTo(404));
    }
}