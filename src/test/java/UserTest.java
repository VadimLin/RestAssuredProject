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
    @BeforeTest
    public void setup() {
        Faker faker = new Faker();

        final int numberForPhoneField = 8;
        final int numberForPassportField = 7;
        final int daysOfPeriod = 365 * 50;
        final int days = 365;

        request = new PostUserRequest(
                        "wedding",
                faker.name().firstName(),
                faker.name().lastName(),
                faker.name().name(),
                faker.number().digits(numberForPassportField),
                faker.number().digits(numberForPhoneField),
                faker.address().streetAddress(),
                faker.name().firstName(),
                faker.name().lastName(),
                faker.name().name(),
                faker.number().digits(numberForPassportField),
                LocalDate.now().minus(Period.ofDays((new Random().nextInt(daysOfPeriod)))).toString(),
                faker.planet().name(),
                faker.name().maleFirstName(),
                faker.name().femaleFirstName(),
                faker.name().maleFirstName(),
                faker.name().femaleFirstName(),
                faker.name().lastName(),
                faker.name().firstName(),
                faker.name().lastName(),
                faker.name().name(),
                LocalDate.now().minus(Period.ofDays((new Random().nextInt(days)))).toString(),
                faker.number().digits(numberForPassportField),
                faker.gender().types(),
                faker.address().streetAddress(),
                LocalDate.now().minus(Period.ofDays((new Random().nextInt(daysOfPeriod)))).toString(),
                LocalDate.now().minus(Period.ofDays((new Random().nextInt(numberForPassportField)))).toString(),
                faker.address().cityName());
        System.out.println("Request " + request);
    }
    @Test (testName = "User Test")
    public void createUserRequestTest() {
        PostUserResponse response = RequestProvider.postUserRequest(ApiConfig.requestSpecification(),
                ApiConfig.responseSpecification(), ApiEndpoints.POST_USER_ENDPOINT, request, PostUserResponse.class);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertNotNull(response.getRequestId());
        softAssert.assertNotNull(response.getData(), "Data list is null");
        softAssert.assertAll();
    }
}
