package org.senla.eu.dto;

import org.senla.eu.property.PropertyFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.SQLException;
public class JdbcConnection {
    public static final String URL = PropertyFile.getProperty("DB_URL");
    public static final String USERNAME = PropertyFile.getProperty("DB_USERNAME");
    public static final String PASSWORD = PropertyFile.getProperty("DB_PASSWORD");
    private static final Logger LOG = LoggerFactory.getLogger(JdbcConnection.class);

    private static Connection con = null;
    private static PreparedStatement pstmt = null;
    private static ResultSet rs = null;



    public static Connection connectToDB() {
        LOG.info("Connect to DB " + URL + USERNAME);
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            LOG.info("Connection to DB successful!");
        } catch (SQLException e) {
            LOG.error("Connection to DB failed!" + e.getMessage());
        } catch (ClassNotFoundException e) {
            LOG.error(e.getMessage());
        }

        return con;
    }

    public static Integer checkAdminRequestById(Integer staffId) throws SQLException {
        Integer staffIdFromDB;

        String selectQuery = "SELECT * FROM reg_office.staff WHERE staffid = ?";
        pstmt = connectToDB().prepareStatement(selectQuery, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        pstmt.setInt(1, staffId);

        LOG.info("Send request to DB: " + pstmt.toString());
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

        LOG.info("Send request to DB: " + pstmt.toString());
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
