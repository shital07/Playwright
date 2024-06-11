package learningbasics;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

import java.nio.file.Paths;

public class TestAutomaticLogin {
    public static void main(String[] args) {

        Browser browser;
        try (Playwright playwright = Playwright.create()) {
            BrowserType.LaunchOptions options = new BrowserType.LaunchOptions();
            options.setChannel("chrome");
            options.setHeadless(false);

            browser = playwright.chromium().launch(options);
            BrowserContext context = browser.newContext(new Browser.NewContextOptions().setStorageStatePath(Paths.get("applogin.json")));
            Page page = context.newPage();
            page.navigate("https://amazon.com");
page.pause();
           /* page.getByPlaceholder("Type characters").click();
            page.getByPlaceholder("Type characters").fill("KBHMLM");
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Continue shopping")).click();*/


        }
    }
}
