import org.senla.eu.client.ApiConfig;
import org.senla.eu.client.ApiEndpoints;
import org.senla.eu.client.RequestProvider;
import org.senla.eu.dto.PostProcessRequest;
import org.senla.eu.dto.JdbcConnection;
import org.senla.eu.dto.PostProcessResponse;
import org.senla.eu.dto.PreparedStatementJdbc;
import org.senla.eu.dto.ProcessData;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.sql.SQLException;

public class ProcessTest {
    private PostProcessRequest request;

    private final int applId = 49898;
    private final int staffId = 27659;

    @BeforeTest
    public void setup() {
        request = new PostProcessRequest("approved", applId, staffId);
    }

    @Test (testName = "Change Status Test")
    public void processTest() throws SQLException {
        JdbcConnection jdbcConnection = new JdbcConnection();
        PostProcessResponse response = RequestProvider.postAdminRequest(ApiConfig.requestSpecification(),
                ApiConfig.responseSpecification(), ApiEndpoints.POST_CHANGE_STATUS_ENDPOINT, request,
                PostProcessResponse.class);

        int reqApplId = response.getData().get(0).getApplicationId();
        int applIdFromDB = PreparedStatementJdbc.checkStatus(reqApplId);


        SoftAssert softAssert = new SoftAssert();
        softAssert.assertNotNull(response.getData(), "Field data is not null");
        softAssert.assertFalse(response.getRequestId().isEmpty(), "RequestId is not empty");
        for (ProcessData data : response.getData()) {
            softAssert.assertNotNull(data.getApplicationId(), "applicationId is not null");
            softAssert.assertNotNull(data.getCitizenId(), "citizenId is not null");
            softAssert.assertNotNull(data.getApplicantId(), "applicantId is not null");
            softAssert.assertEquals(data.getStaffid(), request.staffid(), "staffId the same as in request");
            softAssert.assertNotNull(data.getDateOfApplication(), "dateOfApplication is not null");
            softAssert.assertNotNull(data.getKindOfApplication(), "kindOfApplication is not null");
            softAssert.assertEquals(reqApplId, applIdFromDB, "ApplId from response and DB should match");
            softAssert.assertAll();

            jdbcConnection.connectToDB().close();
       }
    }
}
