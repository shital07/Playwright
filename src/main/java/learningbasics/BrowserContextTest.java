package learningbasics;

import com.microsoft.playwright.*;

public class BrowserContextTest {


    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
        BrowserType.LaunchOptions options = new BrowserType.LaunchOptions();
        options.setChannel("chrome");
        options.setHeadless(false);
        Browser browser = playwright.chromium().launch(options);
        BrowserContext browserContext1 = browser.newContext();

        Page page = browserContext1.newPage();
        page.navigate("https://demo.playwright.dev/todomvc/");
        page.getByPlaceholder("What needs to be done?").click();
        page.getByPlaceholder("What needs to be done?").fill("learn automation");
        page.getByPlaceholder("What needs to be done?").press("Enter");
        page.getByPlaceholder("What needs to be done?").fill("clear interview");
        page.getByPlaceholder("What needs to be done?").press("Enter");
        page.getByPlaceholder("What needs to be done?").fill("high paying job ");

        BrowserContext browserContext2 = browser.newContext();
        Page page1 = browserContext2.newPage();
        page1.navigate("https://www.google.com");
        System.out.println(page1.title());
        System.out.println(page1.url());


        page.close();
        browserContext1.close();

        page1.close();
        browserContext2.close();

    }
}
