import net.datafaker.Faker;
import org.senla.eu.client.ApiConfig;
import org.senla.eu.client.ApiEndpoints;
import org.senla.eu.client.RequestProvider;
import org.senla.eu.dto.JdbcConnection;
import org.senla.eu.dto.PostAdminRequest;
import org.senla.eu.dto.PostAdminResponse;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.sql.SQLException;


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

    @Test(testName = "Admin Test")
   public void sendAdminRequestTest() throws SQLException {
       JdbcConnection jdbcConnection = new JdbcConnection();

        PostAdminResponse response = RequestProvider.postAdminRequest(
                ApiConfig.requestSpecification(),
                ApiConfig.responseSpecification(),
                ApiEndpoints.POST_ADMIN_ENDPOINT,
                request,
                PostAdminResponse.class);

        Integer reqStaffId = (response.getData().get(0).getStaffId());
        Integer staffIdFromDB = JdbcTest.checkAdminRequestById(response.getData().get(0).getStaffId());
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertNotNull(response.getRequestId(), "RequestId is not null");
        softAssert.assertFalse(response.getData().isEmpty(), "List data should not be empty");
        softAssert.assertEquals(reqStaffId, staffIdFromDB, "StaffId from response and DB should match");
        softAssert.assertAll();

        jdbcConnection.connectToDB().close();

    }

}
