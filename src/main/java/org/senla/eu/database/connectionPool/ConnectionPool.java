package org.senla.eu.database.connectionPool;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.senla.eu.property.PropertyFile;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionPool {

    private static HikariDataSource dataSource;
    static final int POOL_SIZE = 10;
    static final int IDLE = 2;
    static final int IDLE_TIMEOUT = 30000;
    static final int MAX_LIFE_TIME = 1800000;

    static {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(PropertyFile.getProperty("DB_URL"));
        config.setUsername(PropertyFile.getProperty("DB_USERNAME"));
        config.setPassword(PropertyFile.getProperty("DB_PASSWORD"));
        config.setMaximumPoolSize(POOL_SIZE);
        config.setMinimumIdle(IDLE);
        config.setIdleTimeout(IDLE_TIMEOUT);
        config.setMaxLifetime(MAX_LIFE_TIME);

        dataSource = new HikariDataSource(config);
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}
