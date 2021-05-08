package mocks.TC3.configuration;

import lombok.Builder;

import java.util.Arrays;
import java.util.List;

@Builder
public class Experiment {

    public String id;
    public Boolean isRunning;
    public String endState;

    public static List<Experiment> getDefaultExperiments() {
        return Arrays.asList(
            Experiment.builder()
                .id("OnboardingScreenVariants")
                .isRunning(false)
                .endState("3_onboarding_screens")
                .build());
    }
}
