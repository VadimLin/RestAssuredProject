import org.senla.eu.client.ApiConfig;
import org.senla.eu.client.ApiEndpoints;
import org.senla.eu.client.RequestProvider;
import org.senla.eu.dto.ApplStatusData;
import org.senla.eu.dto.GetApplStatusResponse;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AppStatusTest {
    @Test
    public void getApplStatus() {

         final int applId = 49730;
        GetApplStatusResponse response = RequestProvider.getRequest(ApiConfig.requestSpecification(),
                ApiConfig.responseSpecification(), ApiEndpoints.GET_APP_STATUS_ENDPOINT + applId,
                GetApplStatusResponse.class);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertNotNull(response.getData());
        softAssert.assertFalse(response.getData().isEmpty(), "Data list should not be empty");

        for (ApplStatusData statusData : response.getData()) {
            softAssert.assertNotNull(statusData.getDateOfApplication(), "dateOfApplication should not be null");
            softAssert.assertFalse(statusData.getDateOfApplication().isEmpty(), "dateOfApplication should not be empty");


            softAssert.assertNotNull(statusData.getStatusOfApplication(), "statusOfApplication should not be null");
            softAssert.assertFalse(statusData.getStatusOfApplication().isEmpty(), "statusOfApplication should not be empty");
        }

        softAssert.assertAll();
    }
}
