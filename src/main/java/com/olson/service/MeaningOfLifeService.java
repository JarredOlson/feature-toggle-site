package com.olson.service;

import com.olson.toggles.FeatureToggleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MeaningOfLifeService {

    @Autowired
    FeatureToggleService featureToggleService;

    public String whatIsTheMeaningOfLife() {
        String meaningOfLife;
        if(featureToggleService.isFeatureEnabled("feature.toggle.1")) {
            meaningOfLife = "The meaning of life as we perceive it is derived from our philosophical and religious contemplation of, and scientific inquiries about existence, social ties, consciousness, and happiness.";
        } else {
            meaningOfLife = "42";
        }
        return meaningOfLife;
    }
}
