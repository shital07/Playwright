package framework.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.util.Objects;

public class ExtendReport {
    static ExtentReports reports;
    static ExtentTest test;

    public static void initReport() {

        if (Objects.isNull(reports)) {
            System.out.println("hidfdfdf");
            reports = new ExtentReports();
            ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/extent-reports/");
            extentSparkReporter.config().setDocumentTitle("Automation Report");
            extentSparkReporter.config().setReportName("Test Extend Report");
            reports.setSystemInfo("Hostname", System.getProperty("user.name"));
            reports.setSystemInfo("Env", "dev");
            reports.setSystemInfo("Username", "Shital Malviya");
            reports.attachReporter(extentSparkReporter);

        }


    }

    public static void createTest(String testName) {
        System.out.println("hi");

        ExtendReportManager.setTest(reports.createTest(testName));


    }

    public static void flushReport() {
            if (Objects.nonNull(reports)) {
                reports.flush();
            }
        }

    }


