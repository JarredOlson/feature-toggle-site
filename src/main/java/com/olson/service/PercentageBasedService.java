package com.olson.service;

import com.olson.toggles.FeatureTogglePercentageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PercentageBasedService {

    @Autowired
    FeatureTogglePercentageService featureTogglePercentageService;

    public String amILucky() {
        if(featureTogglePercentageService.isFeatureEnabled("feature.toggle.2")) {
            return "Yes";
        }
        return "No";
    }
}
