package framework.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public final class ExtentReportManager {
    private static final ExtentReports EXTENT_REPORTS = createInstance();

    private ExtentReportManager() {
    }

    private static ExtentReports createInstance() {
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("test-output/extent-report.html");
        sparkReporter.config().setReportName("UI Automation Report");
        sparkReporter.config().setDocumentTitle("Selenium Test Execution");

        ExtentReports extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
        extent.setSystemInfo("Framework", "Selenium + TestNG");
        extent.setSystemInfo("Author", "AI Agent");
        return extent;
    }

    public static ExtentReports getReporter() {
        return EXTENT_REPORTS;
    }
}
