package com.myapp.pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


//Example Page Object Model class - Delete me or update me with real page object
public class WelcomeScreen{
    AppiumDriver driver;

    public WelcomeScreen(AppiumDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @AndroidFindBy(id="primary-button_common-welcome-continue")
    @iOSXCUITFindBy(accessibility = "primary-button_common-welcome-continue")
    private WebElement signInButton;

    @AndroidFindBy(id="secondary-button_common-welcome-try-demo")
    @iOSXCUITFindBy(accessibility = "secondary-button_common-welcome-try-demo")
    private WebElement tryDemoModeButton;

    public void clickOnSignInButton() throws InterruptedException {
        signInButton.click();
    }

    public void launchDemoMode(){
        tryDemoModeButton.click();
    }
}
