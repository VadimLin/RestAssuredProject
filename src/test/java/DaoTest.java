import net.datafaker.Faker;
import org.senla.eu.database.connectionPool.ConnectionPool;
import org.senla.eu.database.dao.ApplicantDAOImpl;
import org.senla.eu.database.dao.ApplicantDao;
import org.senla.eu.database.entity.Applicant;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.sql.Connection;

public class DaoTest {
    @Test
    void daoTest() {
        final int id = 46082;
        //try-with-resources(don't need manual closing)
        try (Connection conn = ConnectionPool.getConnection()) {
            ApplicantDao dao = new ApplicantDAOImpl(conn);
          dao.get(id).ifPresent(applicant -> System.out.println("Found " + applicant.getName()));

          SoftAssert softAssert = new SoftAssert();
          softAssert.assertTrue(dao.get(id).isPresent(),
                    "Applicant with ID " + id + " should exist in db");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void daoInsertTest() {
        final int numberForPassportField = 6;
        final int numberForPhoneField = 9;
        Faker faker = new Faker();
        String randomSurname = faker.name().lastName();
        String randomName = faker.name().firstName();
        String randomMiddleName = faker.funnyName().name();
        String randomPassportNumber = faker.number().digits(numberForPassportField);
        String randomPhoneNumber = faker.number().digits(numberForPhoneField);
        String randomAddress = faker.address().streetAddress();

        Connection conn = null;
        try {
            conn = ConnectionPool.getConnection();
            ApplicantDao dao = new ApplicantDAOImpl(conn);
            Applicant applicant = Applicant.builder()
                    .surname(randomSurname)
                    .name(randomName)
                    .middleName(randomMiddleName)
                    .passportNumber(randomPassportNumber)
                    .phoneNumber(randomPhoneNumber)
                    .registrationAddress(randomAddress)
                    .build();
            dao.save(applicant);
            System.out.println(applicant);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
    @Test
    void daoUpdateTest() {
        Faker faker = new Faker();
        final int testId = 46082;

        try (Connection conn = ConnectionPool.getConnection()) {
            ApplicantDao dao = new ApplicantDAOImpl(conn);
            Applicant originalApplicant = dao.get(testId).orElseThrow();
            String updatedName = faker.name().firstName() + "_TEST";
            String[] updateParams = {updatedName};
            dao.update(originalApplicant, updateParams);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
