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

    PostAdminRequest request;

    @BeforeTest
    public void setup() {
        Faker faker = new Faker();
        request = new PostAdminRequest(
                faker.name().firstName(),
                faker.name().lastName(),
                faker.funnyName().name(),
                faker.number().digits(9),
                faker.number().digits(8),
                LocalDate.now().toString()
        );

    }

    @Test
    void sendAdminRequestTest() {
        PostAdminResponse response = RequestProvider.postAdminRequest(
                ApiConfig.requestSpecification(),
                ApiConfig.responseSpecification(),
                ApiEndpoints.POSTADMINENDPOINT,
                request,
                PostAdminResponse.class);
        Assert.assertNotNull(response.getRequestId());
    }

}
