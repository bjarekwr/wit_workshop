package mocks.TC2.onboarding;

import lombok.Builder;

import java.util.Arrays;
import java.util.List;

@Builder
public class Step {

    public String id;
    public String status;
    public Content content;

    public static List<Step> getCurrentStep(OnBoardingStep onBoardingStep) {
        return Arrays.asList(
            getActivationStep(onBoardingStep),
            getPhoneNumberVerificationStep(onBoardingStep),
            getDocumentVerificationStep(onBoardingStep)
        );
    }

    private static Step getDocumentVerificationStep(final OnBoardingStep onBoardingStep) {
        return Step.builder()
            .id("DocumentVerification")
            .status(onBoardingStep.getStep() > 2 ? "Completed" : "NotCompleted")
            .content(Content.builder()
                         .titleCompleted("You have uploaded your ID")
                         .titleNotCompleted("Upload your ID")
                         .subtitle("This helps us verify your account information and protect you from identity theft.")
                         .buttonText("Upload my ID")
                         .build())
            .build();
    }

    private static Step getPhoneNumberVerificationStep(final OnBoardingStep onBoardingStep) {
        return Step.builder()
            .id("PhoneNumberVerification")
            .status(onBoardingStep.getStep() > 1 ? "Completed" : "NotCompleted")
            .content(Content.builder()
                         .titleCompleted("Your mobile number is verified")
                         .titleNotCompleted("Verify your mobile number")
                         .subtitle("We will send you an SMS with a verification code that you enter into the app.")
                         .buttonText("Verify my mobile number")
                         .build())
            .build();
    }

    private static Step getActivationStep(final OnBoardingStep onBoardingStep) {
        return Step.builder()
            .id("Activation")
            .status(onBoardingStep.getStep() > 0 ? "Completed" : "NotCompleted")
            .content(Content.builder()
                         .titleCompleted("Your profile is complete")
                         .titleNotCompleted("Complete your profile")
                         .subtitle("Add a few contact details to your profile, it only takes about 2 minutes.")
                         .buttonText("Complete my profile")
                         .build())
            .build();
    }
}
