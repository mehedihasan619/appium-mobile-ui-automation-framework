package com.myapp.test.utils;

import com.myapp.utils.ConfigUtils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.MutableCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class TestBase {
    public AppiumDriver setUpAppium() throws MalformedURLException {
        String profile = new ConfigUtils().getStringProperty("profile");

        if(isRuntimePropertiesInvalid()) System.exit(0);

        switch (profile) {
            case "ios_local":
                return new IOSDriver(new URL(new ConfigUtils().getStringProperty("appium_server_url")),
                        new MutableCapabilities(CapabilityProfiles.getCapabilityMapping(profile)));
            case "sauce_ios":
                return new IOSDriver(new URL(new ConfigUtils().getStringProperty("sauce_server_url")),
                        new MutableCapabilities(CapabilityProfiles.getCapabilityMapping(profile)));
            case "sauce_android":
                return new AndroidDriver(new URL(new ConfigUtils().getStringProperty("sauce_server_url")),
                        new MutableCapabilities(CapabilityProfiles.getCapabilityMapping(profile)));
            default: //android_local
                return new AndroidDriver(new URL(new ConfigUtils().getStringProperty("appium_server_url")),
                        new MutableCapabilities(CapabilityProfiles.getCapabilityMapping(profile)));
        }
    }

    private boolean isRuntimePropertiesInvalid() {
        if (System.getProperty("emailAddress") == null || System.getProperty("password") == null
                || System.getProperty("emailAddress").isEmpty() ||
                System.getProperty("password").isEmpty()) {

            System.err.printf("Existing JVM due to invalid login credentials \"emailAddress\": %s, \"password\":%s %n",
                    System.getProperty("emailAddress"), System.getProperty("password"));

            return true;
        }
        return false;
    }
}