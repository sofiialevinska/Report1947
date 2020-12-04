package com.opencart.tests;

import com.opencart.driver.DriverRepository;
import com.opencart.driver.RetryAnalyser;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.annotations.*;

public class BaseTest {

    @BeforeSuite (alwaysRun = true)
    public void setup (ITestContext context) {
        for (ITestNGMethod test: context.getAllTestMethods()) {
            test.setRetryAnalyzerClass (RetryAnalyser.class);
        }
        DriverRepository.downloadWebDriver();
    }

    @BeforeMethod
    public void createDriver () {
        DriverRepository.instanceWebBrowser();
    }

    @AfterMethod
    public void closeBrowser () {
        DriverRepository.closeBrowser ();
    }

}