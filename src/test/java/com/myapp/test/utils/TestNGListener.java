package com.myapp.test.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.myapp.utils.CommonUtils;
import io.appium.java_client.AppiumDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGListener implements ITestListener {
    AppiumDriver driver;
    ExtentTest test;
    ExtentReports extentReports = ExtentReporter.getExtentReporterObject();

    public void onTestStart(ITestResult result) {
        test = extentReports.createTest(result.getMethod().getMethodName());
    }

    public void onTestSuccess(ITestResult result) {
        test.log(Status.PASS, "Passed");
    }

    public void onTestFailure(ITestResult result) {
        test.fail(result.getThrowable());
        try {
            driver = (AppiumDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        try {
            test.addScreenCaptureFromPath(CommonUtils.takeScreenshot(driver, result.getMethod().getMethodName()), result.getMethod().getMethodName());
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void onTestSkipped(ITestResult result) {
        // not implemented
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // not implemented

    }

    public void onTestFailedWithTimeout(ITestResult result) {
        onTestFailure(result);
    }

    public void onStart(ITestContext context) {
        // not implemented
    }

    public void onFinish(ITestContext context) {
        extentReports.flush();
    }

}
