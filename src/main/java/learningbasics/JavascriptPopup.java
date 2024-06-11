package learningbasics;

import com.microsoft.playwright.*;

public class JavascriptPopup {


    public static void main(String[] args) throws InterruptedException {
        Browser browser;
        try (Playwright playwright = Playwright.create()) {
            BrowserType.LaunchOptions options = new BrowserType.LaunchOptions();
            options.setChannel("chrome");
            options.setHeadless(false);

            browser = playwright.chromium().launch(options);

            BrowserContext context = browser.newContext();
            Page page = context.newPage();
            page.onDialog(dialog -> {
                System.out.println(dialog.message());
                dialog.accept("hello");
            });


            page.navigate("https://the-internet.herokuapp.com/javascript_alerts");
            page.click("text=Click for JS Alert");
            Thread.sleep(5000);
            page.click("text=Click for JS Confirm");
            Thread.sleep(5000);
            page.click("text=Click for JS Prompt");
            Thread.sleep(5000);


            context.close();
            page.close();
        }
    }
}
