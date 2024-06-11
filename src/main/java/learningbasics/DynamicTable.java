package learningbasics;

import com.microsoft.playwright.*;

public class DynamicTable {

    public static void main(String[] args) {
        Browser browser;
        try (Playwright playwright = Playwright.create()) {
            BrowserType.LaunchOptions options = new BrowserType.LaunchOptions();
            options.setChannel("chrome");
            options.setHeadless(false);

            browser = playwright.chromium().launch(options);

            BrowserContext context = browser.newContext();
            Page page = context.newPage();
            page.navigate("https://datatables.net/extensions/select/examples/checkbox/checkbox.html");


            page.locator("table#example tr").locator(":scope",
                            new Locator.LocatorOptions().setHasText("Ashton Cox"))
                    .locator(".dt-select-checkbox").click();

            page.pause();
        }

    }
}
