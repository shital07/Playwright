package framework.driver;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;

public final class DriverManager {

    private DriverManager() {

    }

    static ThreadLocal<Browser> td_browser = new ThreadLocal<>();

    static ThreadLocal<BrowserContext> td_browserContext = new ThreadLocal<>();
    static ThreadLocal<Page> td_page = new ThreadLocal<>();

    public static Browser getBrowser() {
        return td_browser.get();
    }

    public static void setBrowser(Browser browser) {
        td_browser.set(browser);
    }

    public static BrowserContext getBrowserContext() {
        return td_browserContext.get();
    }

    public static void setBrowserContext(BrowserContext browserContext) {
        td_browserContext.set(browserContext);
    }

    public static Page getPage() {
        return td_page.get();
    }

    public static void setPage(Page page) {
        td_page.set(page);
    }

    public static void unload() {
        td_browser.remove();
        td_browserContext.remove();
        td_page.remove();

    }
}
