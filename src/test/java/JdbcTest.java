import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.senla.eu.dto.JdbcConnection.connectToDB;

public class JdbcTest {

    private static Connection con = null;
    private static PreparedStatement pstmt = null;
    private static ResultSet rs = null;
    public static Integer checkAdminRequestById(Integer staffId) throws SQLException {
        Integer staffIdFromDB;

        String selectQuery = "SELECT * FROM reg_office.staff WHERE staffid = ?";
        pstmt = connectToDB().prepareStatement(selectQuery, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        pstmt.setInt(1, staffId);

        rs = pstmt.executeQuery();
        if (rs.next()) {
            System.out.println(
                    "Staff ID: " + rs.getInt("staffid")
                            + ", Surname: "
                            + rs.getString("surname")
                            + ", Passport: "
                            + rs.getString("passportnumber"));
            staffIdFromDB = rs.getInt("staffId");

        } else {
            staffIdFromDB = null;
        }
        return staffIdFromDB;
    }

    public static Integer checkStatus(int applid) throws SQLException {

        String selectQuery = "SELECT applicationid, citizenid, applicantid, staffid, dateofapplication "
                + "kindofapplication, statusofapplication, channel FROM reg_office.applications WHERE applicationid = ?";
        Integer applIdFromDB;
        pstmt = connectToDB().prepareStatement(selectQuery, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        pstmt.setInt(1, applid);
        rs = pstmt.executeQuery();
        if (rs.next()) {
            System.out.println(
                    "Status from DB: " + rs.getString("statusofapplication")
                            + ", Staff ID: "
                            + rs.getInt("staffid")
                            + ", Application ID: "
                            + rs.getInt("applicationid"));
            applIdFromDB = rs.getInt("applicationid");
        } else {
            applIdFromDB = null;
        }
        return applIdFromDB;
    }
}
