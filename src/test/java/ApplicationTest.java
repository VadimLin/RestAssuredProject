import org.senla.eu.client.ApiConfig;
import org.senla.eu.client.ApiEndpoints;
import org.senla.eu.client.RequestProvider;
import org.senla.eu.dto.GetApplicationsResponse;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

public class ApplicationTest {

    @Test
    public void getApplications() {
        GetApplicationsResponse response = RequestProvider.getRequest(ApiConfig.requestSpecification(),
                ApiConfig.responseSpecification(), ApiEndpoints.GETAPPLICATIONENPOINT, GetApplicationsResponse.class);

        Assert.assertNotNull(response.getTotal());
    }
}
