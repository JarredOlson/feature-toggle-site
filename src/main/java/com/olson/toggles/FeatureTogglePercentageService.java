package com.olson.toggles;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.*;

@Component
public class FeatureTogglePercentageService {

    @Autowired
    Environment environment;

    private static final Logger log = LoggerFactory.getLogger(FeatureToggleService.class);

    public boolean isFeatureEnabled(String name) {
        double percentage = getPropertyFromPropertyFile(name);
        return new Random().nextDouble() <= percentage;
    }

    private double getPropertyFromPropertyFile(String name) {
        Properties properties = new Properties();
        String propertyValue = null;
        InputStream input = null;
        double responseValue = 0.0d;
        try {
            String springConfigLocation = environment.getProperty("spring.config.location");
            input = new FileInputStream(new File(springConfigLocation));
            properties.load(input);
            propertyValue = properties.getProperty(name);
            responseValue = Double.parseDouble(propertyValue);
        } catch (Exception ex) {
            log.error("Could not read property (" + name + ") from property file", ex);
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    log.error("Exception when attempting to close property file input stream", e);
                }
            }
        }
        return responseValue;
    }
}
