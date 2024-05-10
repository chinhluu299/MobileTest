package core;

import com.aventstack.extentreports.Status;
import helper.CaptureScreenHelper;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Test;
import reports.ExtentReportManager;
import reports.ExtentTestManager;
import utils.Log;

public class TestListener implements ITestListener {

    public String getTestName(ITestResult result) {
        return result.getTestName() != null ? result.getTestName() : result.getMethod().getConstructorOrMethod().getName();
    }

    public String getTestDescription(ITestResult result) {
        return result.getMethod().getDescription() != null ? result.getMethod().getDescription() : getTestName(result);
    }

    @Override
    public void onFinish(ITestContext arg0) {
        Log.info("End testing " + arg0.getName());
        ExtentReportManager.getExtentReports().flush();

    }

    @Override
    public void onStart(ITestContext arg0) {
        // TODO Auto-generated method stub
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onTestFailure(ITestResult result) {
        Log.error("Test case " + result.getName() + " is failed.");
        //Screenshot khi fail
        CaptureScreenHelper.takeScreenshot("failure",result.getMethod().getMethodName());
        Log.error(result.getThrowable().toString());

        //Extent Report
        ExtentTestManager.addScreenShot(result.getName());
        ExtentTestManager.logMessage(Status.FAIL, result.getThrowable().toString());
        ExtentTestManager.logMessage(Status.FAIL, result.getName() + " is failed.");    }

    @Override
    public void onTestSkipped(ITestResult result) {
        CaptureScreenHelper.takeScreenshot("skipped",result.getMethod().getMethodName());
        Log.error("Test case " + result.getName() + " is skipped.");
        Log.error(result.getThrowable().toString());
        ExtentTestManager.logMessage(Status.SKIP, result.getThrowable().toString());
    }

    @Override
    public void onTestStart(ITestResult result) {
        Log.info("Running test case " + result.getName());
        ExtentTestManager.saveToReport(getTestName(result), getTestDescription(result));
    }

    @Override
    public void onTestSuccess(ITestResult arg0) {
        Log.info("Method " + arg0.getMethod().getMethodName() + " success");
        CaptureScreenHelper.takeScreenshot("success",arg0.getMethod().getMethodName());

    }
}