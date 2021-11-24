package utilities;

import org.testng.*;
import org.testng.internal.TestResult;

public class TestListener implements ITestListener, IInvokedMethodListener {

    public void onTestFailure(ITestResult result) {
        Config[] testConfigs = BaseTest.threadLocalConfig.get();
        for (Config testConfig : testConfigs) {
            if (testConfig != null) {
                testConfig.logComment("***************EXECUTION OF TESTCASE ENDS HERE***************");
                Browser.takeScreenshot(testConfig);
            }
        }
    }

    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        // Method to check if testcase failed with soft asserts (Log.Fail) i.e.
        // status as success, to do assertAll, and mark the test case as fail
        if (method.isTestMethod() && testResult.getStatus() == TestResult.SUCCESS) {
            String errorMessage = "";
            Config[] testConfigs = BaseTest.threadLocalConfig.get();
            for (Config testConfig : testConfigs) {
                if (testConfig != null) {
                    try {
                        testConfig.softAssert.assertAll();
                    } catch (AssertionError e) {
                        errorMessage = errorMessage + e.getMessage();
                        testResult.setStatus(TestResult.FAILURE);
                        testResult.setThrowable(new AssertionError(errorMessage));
                        Log.failure(testConfig, errorMessage);
                    }
                }
            }
        }
    }

    public void onTestStart(ITestResult result) {

    }

    public void onTestSuccess(ITestResult result) {

    }

    public void onTestSkipped(ITestResult result) {

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    public void onStart(ITestContext context) {

    }

    public void onFinish(ITestContext context) {

    }

    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {

    }
}
