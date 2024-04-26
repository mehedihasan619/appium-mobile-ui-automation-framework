package com.myapp.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

//Add common utils here
public class CommonUtils {
    public static void hideKeyboard(AppiumDriver driver) {
        if (driver instanceof AndroidDriver) {
            ((AndroidDriver) driver).hideKeyboard();
        } else if (driver instanceof IOSDriver) {
            //TODO
        } else {
            System.out.println("Unknown Driver Instance sent");
        }
    }

    public static void implicitWait(AppiumDriver driver) {
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
    }

    public static String takeScreenshot(AppiumDriver driver, String screenShotFileName) throws IOException {
        String screenshotPath = System.getProperty("user.dir") + File.separator + "reports" + File.separator + "screenshots"
                + File.separator + screenShotFileName + ".png";
        File fileSource = driver.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(fileSource, new File(screenshotPath));
        return screenshotPath;
    }
}
