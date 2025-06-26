package org.senla.eu.dto;

import org.senla.eu.property.PropertyFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class JdbcConnection {
    public static final String URL = PropertyFile.getProperty("DB_URL");
    public static final String USERNAME = PropertyFile.getProperty("DB_USERNAME");
    public static final String PASSWORD = PropertyFile.getProperty("DB_PASSWORD");
    private static final Logger LOG = LoggerFactory.getLogger(JdbcConnection.class);

    private static Connection con = null;

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

}
