package com.myapp.test.tester;

import com.myapp.pageObjects.LoginScreen;
import com.myapp.pageObjects.WelcomeScreen;
import com.myapp.test.utils.TestBase;
import com.myapp.utils.CommonUtils;
import com.myapp.test.utils.TestDataUtils;
import io.appium.java_client.AppiumDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class LoginScreenTest extends TestBase {
    public AppiumDriver driver;
    WelcomeScreen welcomeScreen;
    LoginScreen loginScreen;
    TestDataUtils testDataUtils;

    @BeforeTest
    public void setUpTest() throws MalformedURLException, InterruptedException {
        this.driver = setUpAppium();
        welcomeScreen = new WelcomeScreen(driver);
        loginScreen = new LoginScreen(driver);
        testDataUtils = new TestDataUtils();
        CommonUtils.implicitWait(driver);
    }

    //Example test - Update me or delete me
    @Test(description = "Login to the app as a customer")
    public void loginAsCustomer() throws InterruptedException {
        welcomeScreen.clickOnSignInButton();
        loginScreen.enterEmailAddress(System.getProperty("emailAddress"));
        loginScreen.enterPassword(System.getProperty("password"));
        loginScreen.clickOnLoginScreenSignInButton();
    }

    @AfterTest
    public void tearDownTest() {
        if(driver != null) driver.quit();
    }
}
