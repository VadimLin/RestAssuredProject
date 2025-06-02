import net.datafaker.Faker;
import org.senla.eu.client.ApiConfig;
import org.senla.eu.client.ApiEndpoints;
import org.senla.eu.client.RequestProvider;
import org.senla.eu.dto.PostAdminRequest;
import org.senla.eu.dto.PostAdminResponse;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.LocalDate;

public class AdminTest {

    private PostAdminRequest request;
    public PostAdminRequest getRequest() {
        return request;
    }

    @BeforeTest
    public void setup() {
        Faker faker = new Faker();

        final int numberForPhoneField = 9;
        final int numberForPassportField = 8;
        request = new PostAdminRequest(
                faker.name().firstName(),
                faker.name().lastName(),
                faker.funnyName().name(),
                faker.number().digits(numberForPhoneField),
                faker.number().digits(numberForPassportField),
                LocalDate.now().toString()
        );

    }

    @Test
    void sendAdminRequestTest() {
        PostAdminResponse response = RequestProvider.postAdminRequest(
                ApiConfig.requestSpecification(),
                ApiConfig.responseSpecification(),
                ApiEndpoints.POST_ADMIN_ENDPOINT,
                request,
                PostAdminResponse.class);
        Assert.assertNotNull(response.getRequestId());
    }

}
