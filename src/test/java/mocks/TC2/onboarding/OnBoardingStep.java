package mocks.TC2.onboarding;

import lombok.Getter;

@Getter
public enum OnBoardingStep {

    ACTIVATION(0),
    PHONE_NUMBER_VERIFICATION(1),
    DOCUMENT_VERIFICATION(2),
    ON_BOARDING_COMPLETE(3);

    private Integer step;

    OnBoardingStep(Integer code) {
        this.step = code;
    }
}
