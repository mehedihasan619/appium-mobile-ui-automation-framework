package com.myapp.pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

//Example Page Object Model class - Delete me or update me with real page object
public class LoginScreen {
    AppiumDriver driver;

    public LoginScreen(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "input-commissioning-Email address")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Email address\"])[2]")
    private WebElement emailAddressField;

    @AndroidFindBy(id = "input-commissioning-Password")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Password\"])[2]")
    private WebElement passwordField;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Password\"]/android.view.ViewGroup/android.view.ViewGroup[2]/com.horcrux.svg.SvgView/com.horcrux.svg.l/com.horcrux.svg.u")
    private WebElement revealPasswordIcon;

    @AndroidFindBy(id = "link-login-forgot-password")
    @iOSXCUITFindBy(accessibility = "link-login-forgot-password")
    private WebElement forgotPasswordLink;

    @AndroidFindBy(id = "primary-button_common-auth-submit")
    @iOSXCUITFindBy (accessibility = "primary-button_common-auth-submit")
    private WebElement loginScreenSignInButton;

    public void enterEmailAddress(String emailAddress) {
        emailAddressField.sendKeys(emailAddress);
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void clickOnLoginScreenSignInButton() {
        loginScreenSignInButton.click();
    }

    public void hideOrRevealPassword() {
        revealPasswordIcon.click();
    }

    public void clickOnForgotPasswordLink() {
        forgotPasswordLink.click();
    }
}
