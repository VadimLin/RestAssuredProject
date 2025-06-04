package org.senla.eu.client;

import org.senla.eu.property.PropertyFile;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import java.sql.*;

public class JdbcConnection {

    public static final String URL = PropertyFile.getProperty("DB_URL");
    public static final String USERNAME = PropertyFile.getProperty("BD_USERNAME");
    public static final String PASSWORD = PropertyFile.getProperty("BD_PASSWORD");

    private static final Logger log = LoggerFactory.getLogger(JdbcConnection.class);

    private static Connection con;
    private static Statement stmt;
    private static PreparedStatement pstmt;
    private static ResultSet rs;

    public static Connection connectToDB() {
        log.info("Connect to DB " + URL + USERNAME);
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            log.info("Connection to DB successful!");
        } catch (SQLException e) {
            log.error("Connection to DB failed!" + e.getMessage());
        } catch (ClassNotFoundException e) {
            log.error(e.getMessage());
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    log.error("Error closing connection: " + e.getMessage());
                }
            }
        }
        return con;
    }
}
