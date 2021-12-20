package com.redhat.gps.health;

import javax.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Readiness;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Readiness
@ApplicationScoped
public class ReadyPropertiesHealthCheck implements HealthCheck {

    Logger logger = LoggerFactory.getLogger(ReadyPropertiesHealthCheck.class);

    @Override
    public HealthCheckResponse call() {
        logger.info("Executing  Ready health check");
        if("up".equals(System.getProperty("readiness", "up"))){
            logger.info("Prueba exitosa");
            return HealthCheckResponse.up("up");
        }
        logger.info("Prueba Erronea");
        return HealthCheckResponse.down("down");
    }
    
}
