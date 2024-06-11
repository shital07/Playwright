package learningbasics;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import java.nio.file.Paths;

public class AutomaticLogin {
    public static void main(String[] args) {


        try (Playwright playwright = Playwright.create()) {


            Browser browser = playwright.chromium().launch();
            BrowserContext context = browser.newContext();

            Page page = context.newPage();

            page.navigate("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

            page.fill("input[name='username']", "Admin");
            page.fill("input[name='password']", "admin123");
            page.click("button:has-text('Login')");


            context.storageState(new BrowserContext.StorageStateOptions().setPath(Paths.get("applogin.json")));
            page.close();
            context.close();
        }

    }
}
