package AutomationExerciseApi;


import org.testng.annotations.Test;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import io.qameta.allure.Description;

import java.util.UUID;

public class EmptyEmailTest {

    private String uniquePassword;

    @Test
    @Description("Register with empty email")
    public void Register_withEmptyEmail() {
        String emptyEmail = "";
        uniquePassword = "passwordd" + UUID.randomUUID().toString();

        Response response = given()
                .baseUri("https://automationexercise.com")
                .multiPart("email", emptyEmail)
                .multiPart("password", uniquePassword)
                .header("Content-Type", "multipart/form-data")
                .when().post("/api/verifyLogin")
                .then().log().all().extract().response();

        String jsonResponse = response.getBody().asString();
        JsonPath jsonPath = new JsonPath(jsonResponse);

        assertThat(response.getStatusCode(), equalTo(200));
        assertThat(jsonPath.getString("message"), equalTo("User not found!"));
        assertThat(response.getTime(), lessThan(2000L));
        assertThat(jsonPath.getInt("responseCode"), equalTo(404));
    }
}