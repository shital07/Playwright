package framework.listener;

import com.aventstack.extentreports.Status;
import framework.reports.ExtendReport;
import framework.reports.ExtendReportManager;
import org.testng.*;

public class FrameworkListener implements ITestListener, ISuiteListener {
    @Override
    public void onStart(ISuite suite) {
        ExtendReport.initReport();

    }

    @Override
    public void onFinish(ISuite suite) {

        ExtendReport.flushReport();
    }

    @Override
    public void onTestStart(ITestResult result) {

        ExtendReport.createTest(result.getMethod().getMethodName());
        ExtendReportManager.getTest().log(Status.INFO,"Started Tcs---");

    }

    @Override
    public void onTestSuccess(ITestResult result) {

    }

    @Override
    public void onTestFailure(ITestResult result) {

    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ITestListener.super.onTestFailedWithTimeout(result);
    }

    @Override
    public void onStart(ITestContext context) {
        ITestListener.super.onStart(context);
    }

    @Override
    public void onFinish(ITestContext context) {
        ITestListener.super.onFinish(context);
    }
}
