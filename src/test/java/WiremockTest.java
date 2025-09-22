import io.restassured.RestAssured;
import org.senla.eu.property.PropertyFile;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;

public class WiremockTest {
    private final int statusCode = 200;
    @BeforeMethod
    public static void setup() {
        RestAssured.baseURI = PropertyFile.getProperty("BASEURI");
    }
    @Test
    public void testGetStubEndpoint() {
        RestAssured
                .given()
                .when()
                .get("/api/test")
                .then()
                .statusCode(statusCode)
                .body("message", equalTo("This is a test response from Wiremock!"));

    }
}
