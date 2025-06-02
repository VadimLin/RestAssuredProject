import net.datafaker.Faker;
import org.senla.eu.client.ApiConfig;
import org.senla.eu.client.ApiEndpoints;
import org.senla.eu.client.RequestProvider;
import org.senla.eu.dto.PostUserRequest;
import org.senla.eu.dto.PostUserResponse;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.LocalDate;
import java.time.Period;
import java.util.Random;

public class UserTest {

    private PostUserRequest request;

    public PostUserRequest getRequest() {
        return request;
    }
    @BeforeTest
    public void setup() {
        Faker faker = new Faker();


        request = new PostUserRequest(
                        "birth",
                        faker.name().lastName(),
                        faker.name().femaleFirstName(),
                        faker.name().firstName(),
                        faker.number().digits(9),
                        faker.number().digits(8),
                        faker.address().cityName(),
                        faker.name().lastName(),
                        faker.name().femaleFirstName(),
                        faker.name().firstName(),
                        LocalDate.now().minus(Period.ofDays((new Random().nextInt(365 * 50)))).toString(),
                        faker.number().digits(8),
                        faker.gender().binaryTypes(),
                        faker.address().cityName(),
                        LocalDate.now().minus(Period.ofDays((new Random().nextInt(365)))).toString(),
                        faker.name().lastName(),
                        faker.name().lastName(),
                        faker.name().maleFirstName(),
                        faker.name().firstName(),
                        LocalDate.now().minus(Period.ofDays((new Random().nextInt(365 * 50)))).toString(),
                        faker.number().digits(8),
                        faker.address().cityName(),
                        faker.name().fullName(),
                        faker.name().fullName(),
                        LocalDate.now().minus(Period.ofDays((new Random().nextInt(7)))).toString(),
                        faker.address().cityName());
    }
    @Test
    public void createUserRequestTest() {
        PostUserResponse response = RequestProvider.postUserRequest(ApiConfig.requestSpecification(),
                ApiConfig.responseSpecification(), ApiEndpoints.POST_USER_ENDPOINT, PostUserResponse.class);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertNotNull(response.getRequestId());
    }
}
