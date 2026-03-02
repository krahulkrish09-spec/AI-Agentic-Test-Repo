package framework.listeners;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import framework.reports.ExtentReportManager;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
    private static final ThreadLocal<ExtentTest> TEST_NODE = new ThreadLocal<>();

    @Override
    public void onStart(ITestContext context) {
        ExtentReportManager.getReporter();
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest test = ExtentReportManager.getReporter().createTest(result.getMethod().getMethodName());
        TEST_NODE.set(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        TEST_NODE.get().log(Status.PASS, "Test passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        TEST_NODE.get().log(Status.FAIL, result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        TEST_NODE.get().log(Status.SKIP, "Test skipped");
    }

    @Override
    public void onFinish(ITestContext context) {
        ExtentReportManager.getReporter().flush();
        TEST_NODE.remove();
    }
}
