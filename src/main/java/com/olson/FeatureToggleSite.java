package com.olson;

import org.springframework.boot.Banner.Mode;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class FeatureToggleSite {

    public static void main(String[] args) throws Exception {
        new SpringApplicationBuilder(FeatureToggleSite.class).bannerMode(Mode.OFF).run(args);
    }
}
