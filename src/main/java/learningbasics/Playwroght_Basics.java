package learningbasics;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Playwroght_Basics {

    public static void main(String[] args) {
        Browser browser;

//new BrowserType.LaunchOptions().setHeadless(false)

        BrowserType.LaunchOptions lp = new BrowserType.LaunchOptions();
        lp.setChannel("chrome");
        lp.setHeadless(false);
        try (Playwright playwright = Playwright.create()) {
            browser = playwright.chromium().launch(lp);

            Page page = browser.newPage();
            page.navigate("https://www.google.com");
            System.out.println(page.title());
            System.out.println(page.url());
            browser.close();

        }
    }

}
