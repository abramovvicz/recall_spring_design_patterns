package com.abramovvicz.springSandbox.healthCheck;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthContributor;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import java.net.Socket;

@Component
@Slf4j
public class UrlShortenerServiceHealthIndicator  implements HealthIndicator, HealthContributor {
    private static final String URL
                = "https://localhost:8083/api/v1/shorten";

    @Override
    public Health health() {
        // check if url shortener service url is reachable
        try (Socket socket =
                     new Socket(new java.net.URL(URL).getHost(),8083)) {
        } catch (Exception e) {
            log.warn("Failed to connect to: {}",URL);
            return Health.down()
                    .withDetail("error", e.getMessage())
                    .build();
        }
        return Health.up().build();
    }
}
