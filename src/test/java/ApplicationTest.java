import org.senla.eu.client.ApiConfig;
import org.senla.eu.client.ApiEndpoints;
import org.senla.eu.client.RequestProvider;
import org.senla.eu.dto.GetApplicationsResponse;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class ApplicationTest {
    @Test(testName = "Application Test")
    public void getApplications() {
        GetApplicationsResponse response = RequestProvider.getRequest(ApiConfig.requestSpecification(),
                ApiConfig.responseSpecification(), ApiEndpoints.GET_APPLICATION_ENDPOINT, GetApplicationsResponse.class);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertNotNull(response.getTotal(), "Total is not null");
        softAssert.assertFalse(response.getData().isEmpty(), "Data is not empty");
        softAssert.assertNotNull(response.getRequestId(), "RequestId is not null");
        softAssert.assertAll();
    }
}
