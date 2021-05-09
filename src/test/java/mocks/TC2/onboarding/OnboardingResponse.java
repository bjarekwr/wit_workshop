package mocks.TC2.onboarding;

import lombok.Builder;

import java.util.List;

@Builder
public class OnboardingResponse {

    public Boolean isCompleted;
    public List<Step> steps;

    public static OnboardingResponse getResponseForStep(OnBoardingStep onBoardingStep) {
        return OnboardingResponse.builder()
            .isCompleted(onBoardingStep.getStep() > 2)
            .steps(Step.getCurrentStep(onBoardingStep))
            .build();
    }
}
