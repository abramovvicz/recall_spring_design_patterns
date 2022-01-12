package com.abramovvicz.springSandbox.healthCheck;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthContributor;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@Component
public class DatabaseHealthContributor implements HealthContributor, HealthIndicator {

    @Autowired
    private DataSource dataSource;


    @Override
    public Health health() {

        try {
            Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            statement.execute("SELECT * FIRST_NAME, MIDDLE_INITIAL, LAST_NAME, EMAIL_ADDRESS FROM PRESIDENT");
        } catch (SQLException e) {
            return Health.outOfService().withException(e).build();
        }
        return Health.up().build();
    }
}
