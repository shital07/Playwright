package learningbasics;

import com.microsoft.playwright.*;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.options.AriaRole;

import java.nio.file.Paths;

public class Example {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setHeadless(false));
            BrowserContext context = browser.newContext();
            // Start tracing before creating / navigating a page.
            context.tracing().start(new Tracing.StartOptions()
                    .setScreenshots(true)
                    .setSnapshots(true)
                    .setSources(true));


            Page page = context.newPage();
            page.navigate("https://demo.playwright.dev/todomvc/");
            page.getByPlaceholder("What needs to be done?").click();
            page.getByPlaceholder("What needs to be done?").fill("learn automation");
            page.getByPlaceholder("What needs to be done?").press("Enter");
            page.getByPlaceholder("What needs to be done?").fill("clear interview");
            page.getByPlaceholder("What needs to be done?").press("Enter");
            page.getByPlaceholder("What needs to be done?").fill("high paying job ");
            page.getByPlaceholder("What needs to be done?").press("ArrowLeft");
            page.getByPlaceholder("What needs to be done?").press("ArrowLeft");
            page.getByPlaceholder("What needs to be done?").press("ArrowLeft");
            page.getByPlaceholder("What needs to be done?").press("ArrowLeft");
            page.getByPlaceholder("What needs to be done?").press("ArrowLeft");
            page.getByPlaceholder("What needs to be done?").press("ArrowLeft");
            page.getByPlaceholder("What needs to be done?").press("ArrowLeft");
            page.getByPlaceholder("What needs to be done?").press("ArrowLeft");
            page.getByPlaceholder("What needs to be done?").press("ArrowLeft");
            page.getByPlaceholder("What needs to be done?").press("ArrowLeft");
            page.getByPlaceholder("What needs to be done?").press("ArrowLeft");
            page.getByPlaceholder("What needs to be done?").press("ArrowLeft");
            page.getByPlaceholder("What needs to be done?").press("ArrowLeft");
            page.getByPlaceholder("What needs to be done?").press("ArrowLeft");
            page.getByPlaceholder("What needs to be done?").press("ArrowLeft");
            page.getByPlaceholder("What needs to be done?").press("ArrowLeft");
            page.getByPlaceholder("What needs to be done?").press("ArrowLeft");
            page.getByPlaceholder("What needs to be done?").press("ArrowLeft");
            page.getByPlaceholder("What needs to be done?").fill("get high paying job ");
            page.getByPlaceholder("What needs to be done?").press("Enter");
            page.locator("li").filter(new Locator.FilterOptions().setHasText("learn automation")).getByLabel("Toggle Todo").check();
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Completed")).click();
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("All")).click();
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Completed")).click();
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Active")).click();

            // Stop tracing and export it into a zip archive.
            context.tracing().stop(new Tracing.StopOptions()
                    .setPath(Paths.get("trace.zip")));
        }
    }
}
