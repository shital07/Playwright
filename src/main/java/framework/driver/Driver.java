package framework.driver;

import com.aventstack.extentreports.Status;
import com.microsoft.playwright.*;
import framework.configurations.ConfigFactory;
import framework.reports.ExtendReportManager;

import java.util.Objects;

public final class Driver {

    private Driver() {

    }

    public static Browser initBrowser(String browserName) {
        Browser browser = null;
        Playwright playwright = Playwright.create();

        if (Objects.isNull(DriverManager.getBrowser())) {


            switch (browserName) {

                case "chrome": {

                 //   browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
                    browser = playwright.chromium().launch();
                    break;

                }
                case "firefox": {

                    browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
                    break;
                }
                case "webkit": {

                    browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
                    break;
                }
                default: {
                    throw new RuntimeException("Not a valid browsername");

                }


            }

            DriverManager.setBrowser(browser);

        }

        return DriverManager.getBrowser();
    }

    public static BrowserContext getBrowserContext() {
        if (Objects.isNull(DriverManager.getBrowserContext())) {
            DriverManager.setBrowserContext(DriverManager.getBrowser().newContext());
        }
        return DriverManager.getBrowserContext();
    }

    public static Page getPage() {

        if (Objects.isNull(DriverManager.getPage())) {
            DriverManager.setPage(DriverManager.getBrowserContext().newPage());
        }
        return DriverManager.getPage();

    }

    public static void loadUrl() {
        String url = ConfigFactory.getConfig().url();
        DriverManager.getPage().navigate("https://naveenautomationlabs.com/opencart/");
        ExtendReportManager.getTest().log(Status.INFO,"URL is loaded");
        //getPage().navigate("https://www.amazon.com");
    }

    public static void closeBrowserContext() {
        if (Objects.nonNull(DriverManager.getBrowserContext())) {
            DriverManager.getPage().close();
            DriverManager.getBrowserContext().close();
            DriverManager.getBrowser().close();
            DriverManager.unload();
        }

    }
}
