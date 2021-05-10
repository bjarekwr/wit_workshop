package tests;

import models.Sender;
import org.junit.jupiter.api.Test;
import screens.GettingStarted;
import screens.SignUp;

public class WRAndroidTests extends BaseTest {


    private GettingStarted gettingStarted;

    @Test
    public void singUpTest(){
        setStubsForSignUpTest();
        gettingStarted = new GettingStarted();
        gettingStarted.clickGetStarted();
        SignUp signUp = new SignUp();
        signUp.fillForm(Sender.builder().build());
        signUp.clickSignUpButton();
    }

    //TODO
    // Create following testcases:
    // #1
    // 1. Open App
    // 2. Navigate to Login screen
    // 3. Check if login screen is visible by checking presence of any screen element

    //TODO
    // #2
    // 1. Open App
    // 2. Navigate to Login screen
    // 3. Click Sing-in button
    // 4. Check error message next to email field
    //    Message should be: Please enter an email address

    //TODO
    // #3
    // 1. Open App
    // 2. Navigate to Login screen
    // 3. Fill password
    // 4. Click on eye icon to show password
    // 5. Verify if password matches

}