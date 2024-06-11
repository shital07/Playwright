package learningbasics;

import com.microsoft.playwright.*;

import java.util.List;

public class ElementLocator {

    public static void main(String[] args) {
        Browser browser;
        try (Playwright playwright = Playwright.create()) {
            BrowserType.LaunchOptions options = new BrowserType.LaunchOptions();
            options.setChannel("chrome");
            options.setHeadless(false);

            browser = playwright.chromium().launch(options);

            BrowserContext context = browser.newContext();
            Page page = context.newPage();
            page.navigate("https://www.orangehrm.com/en/");

           // Locator locator = page.locator("//div[@class='d-flex web-menu-btn']//button[text()='Contact Sales']");

            Locator locator = page.locator("text=Contact Sales >> visible=true");

            List<String> list = locator.allTextContents();
            list.forEach((s -> System.out.println(s)));


            locator.click();
            page.pause();

          //  page.frameLocator("iframe[title='reCAPTCHA']").locator("span#recaptcha-anchor").click();
//select.dropdown:has(option[value='Albania'])
//a.nav-link-hed:has-text('Solutions'),a.nav-link-hed:has-text('Company') --- css
            //a.nav-link-hed:has-text('Solutions')  | a.nav-link-hed:has-text('Company') -- xpath



            page.close();
            context.close();

        }

    }
}
