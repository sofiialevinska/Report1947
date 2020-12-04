package com.opencart.driver;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import java.util.concurrent.atomic.AtomicInteger;

public class RetryAnalyser implements IRetryAnalyzer {
    private static int retryLimit = 2;
    private AtomicInteger counter = new AtomicInteger(retryLimit);

    public boolean isRetryAvailable () {return counter.intValue()>0;}

    @Override
    public boolean retry(ITestResult iTestResult) {
        boolean retry = false;
        if (isRetryAvailable()) {
            retry = true;
            counter.decrementAndGet();
            return retry;
        }
        return retry;
    }
}
