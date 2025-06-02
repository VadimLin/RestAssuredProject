import org.senla.eu.client.ApiConfig;
import org.senla.eu.client.ApiEndpoints;
import org.senla.eu.client.RequestProvider;
import org.senla.eu.dto.GetApplicationsResponse;
import org.testng.Assert;
import org.testng.annotations.Test;


public class ApplicationTest {

    @Test
    public void getApplications() {
        GetApplicationsResponse response = RequestProvider.getRequest(ApiConfig.requestSpecification(),
                ApiConfig.responseSpecification(), ApiEndpoints.GET_APPLICATION_ENDPOINT, GetApplicationsResponse.class);

        Assert.assertNotNull(response.getTotal());
    }
}
