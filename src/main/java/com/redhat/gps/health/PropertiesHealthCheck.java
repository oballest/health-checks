package com.redhat.gps.health;

import javax.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Liveness;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Liveness
@ApplicationScoped
public class PropertiesHealthCheck implements HealthCheck {

    Logger logger = LoggerFactory.getLogger(PropertiesHealthCheck.class);

    @Override
    public HealthCheckResponse call() {
        logger.info("Executing health check");
        if("up".equals(System.getProperty("liveness", "up"))){
            logger.info("Prueba exitosa");
            return HealthCheckResponse.up("up");
        }
        logger.info("Prueba Erronea");
        return HealthCheckResponse.down("down");
    }
    
}
