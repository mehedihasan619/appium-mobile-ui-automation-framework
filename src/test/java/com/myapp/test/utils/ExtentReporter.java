package com.myapp.test.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.File;

public class ExtentReporter {
    static ExtentReports extentReports;
    public static ExtentReports getExtentReporterObject(){
        ExtentSparkReporter reporter = new ExtentSparkReporter(System.getProperty("user.dir")
                + File.separator + "reports" + File.separator + "test_results.html");
        reporter.config().setReportName("App Test Results");
        reporter.config().setDocumentTitle("App Test Results");
        extentReports = new ExtentReports();
        extentReports.attachReporter(reporter);
        extentReports.setSystemInfo("Device Name: ", "");
        extentReports.setSystemInfo("OS Version: ", "");
        return extentReports;
    }
}
