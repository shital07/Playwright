package framework.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class ExtendReportManager {

    static ThreadLocal<ExtentTest> td_test = new ThreadLocal<>();


    public static ExtentTest getTest() {
        return td_test.get();
    }

    public static void setTest(ExtentTest test) {
        td_test.set(test);
    }

    public static void unload(){

        td_test.remove();
    }

}
