package com.myapp.test.utils;

import java.util.HashMap;
import com.myapp.utils.ConfigUtils;
import org.openqa.selenium.MutableCapabilities;

public class CapabilityProfiles {

    public static HashMap<String, Object> getCapabilityMapping(String profile) {
        HashMap<String, Object> caps = new HashMap<String, Object>();

        switch (profile) {
            case "android_local":
                caps.put("deviceName", new ConfigUtils().getStringProperty("android_device_name"));
                caps.put("app", new ConfigUtils().getStringProperty("android_app_path"));
                caps.put("disableIdLocatorAutocompletion", true);
                caps.put("automationName", "uiautomator2");
                caps.put("appPackage", "update-me"); //// Update it with app package name
                caps.put("appActivity", ".MainActivity");
                caps.put("no-reset", true);
                caps.put("full-reset", false);
                break;
            case "ios_local":
                caps.put("deviceName", new ConfigUtils().getStringProperty("ios_device_name"));
                caps.put("app", new ConfigUtils().getStringProperty("ios_app_path"));
                caps.put("disableIdLocatorAutocompletion", true);
                caps.put("automationName", "XCUITest");
                caps.put("bundleId", "update-me"); // Update it with app package name
                caps.put("platformName", "iOS");
                caps.put("xcodeOrgId", "update-me");// Update the org id with your organization id
                caps.put("xcodeSigningId", "Apple Development");
                caps.put("updatedWDABundleId", "update-me"); // Update it with your WDABundle id you created
                caps.put("udid", new ConfigUtils().getStringProperty("ios_device_udid"));
                caps.put("appium:settings[snapshotMaxDepth]", "70");
                caps.put("no-reset", false);
                caps.put("full-reset", true);
                break;
            case "sauce_android":
                caps.put("platformName", "Android");
                caps.put("appium:deviceName", new ConfigUtils().getStringProperty("sauce_android_device_name"));
                caps.put("appium:app", new ConfigUtils().getStringProperty("sauce_android_app_path"));
                caps.put("appium:platformVersion", new ConfigUtils().getStringProperty("sauce_android_platform_version"));
                caps.put("appium:disableIdLocatorAutocompletion", true);
                caps.put("appium:automationName", "UiAutomator2");
                caps.put("appium:appPackage", "update-me"); // Update it with app package name
                // caps.put("appium:appActivity", ".MainActivity");
                HashMap<String, Object> sauceAndroidCaps = new HashMap<String, Object>() {{
                    put("username", "<sauce user name>");
                    put("accessKey", "<sauce access key>");
                    put("build", "<sauce app build number>");
                    put("name", "<sauce test name>");
                    put("deviceOrientation", "PORTRAIT");
                    put("appiumVersion", "latest");
                }};
                caps.put("sauce:options", new MutableCapabilities(sauceAndroidCaps));
                break;
            case "sauce_ios":
                caps.put("platformName", "iOS");
                caps.put("appium:deviceName", new ConfigUtils().getStringProperty("sauce_ios_device_name"));
                caps.put("appium:app", new ConfigUtils().getStringProperty("sauce_ios_app_path"));
                caps.put("appium:platformVersion", new ConfigUtils().getStringProperty("sauce_ios_platform_version"));
                caps.put("appium:disableIdLocatorAutocompletion", true);
                caps.put("appium:automationName", "XCUITest");
                caps.put("appium:settings[snapshotMaxDepth]", "70");
                caps.put("appium:appPackage", "update-me"); // Update it with app package name
                caps.put("appium:appActivity", ".MainActivity");
                HashMap<String, Object> sauceIOSCaps = new HashMap<String, Object>() {{
                    put("username", "<sauce user name>");
                    put("accessKey", "<sauce access key>");
                    put("build", "<sauce app build number>");
                    put("name", "<sauce test name>");
                    put("deviceOrientation", "PORTRAIT");
                    put("appiumVersion", "latest");
                }};
                caps.put("sauce:options", new MutableCapabilities(sauceIOSCaps));
                System.out.println("Unsupported profile.Please check whether you've set the correct profile");
        }
        return caps;
    }
}
