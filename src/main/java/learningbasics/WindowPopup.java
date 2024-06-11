package learningbasics;

import com.microsoft.playwright.*;

public class WindowPopup {
    public static void main(String[] args) {
        Browser browser;
        try (Playwright playwright = Playwright.create()) {
            BrowserType.LaunchOptions options = new BrowserType.LaunchOptions();
            options.setChannel("chrome");
            options.setHeadless(false);

            browser = playwright.chromium().launch(options);

            BrowserContext context = browser.newContext();
            Page page = context.newPage();
            page.navigate("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");


            Page page1 = page.waitForPopup(() -> {
                page.click("//*[@class='oxd-icon orangehrm-sm-icon']/parent::a[contains(@href,'youtube')]");

            });

            System.out.println(page1.title());

            page1.pause();

            page1.close();

            System.out.println(page.title());

page.pause();
        }
    }
}


