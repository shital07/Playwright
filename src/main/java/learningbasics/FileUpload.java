package learningbasics;

import com.microsoft.playwright.*;

import java.awt.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUpload {

    public static void main(String[] args) throws InterruptedException {
        Browser browser;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) screenSize.getWidth();
        int height = (int) screenSize.getHeight();

        try (Playwright playwright = Playwright.create()) {

            BrowserType.LaunchOptions options = new BrowserType.LaunchOptions();
            options.setChannel("chrome");
            options.setHeadless(false);

            browser = playwright.chromium().launch(options);

            BrowserContext context = browser.newContext(new Browser.NewContextOptions().setViewportSize(width, height));
            Page page = context.newPage();

            page.navigate("https://davidwalsh.name/demo/multiple-file-upload.php");

            Thread.sleep(9000);
            // page.setInputFiles("#filesToUpload", Paths.get("applogin.json"));

            page.setInputFiles("#filesToUpload", new Path[]{
                    Paths.get("applogin.json"),
                    Paths.get("pom.xml")
            });

            Thread.sleep(9000);
           /* Download download1 = page.waitForDownload(() -> {
                page.click("");
            });

            download1.saveAs(Paths.get(""));*/


            page.close();
            context.close();
        }
    }
}
