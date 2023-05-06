package appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SessionHelper {

    private final WebDriver wd;
    private final WebDriverWait wait;

    public SessionHelper(WebDriver wd, WebDriverWait wait) {

        this.wd = wd;
        this.wait = wait;
    }

    public void waitForLoadingItems() throws InterruptedException {
        Thread.sleep(7000);
    }

    public void waitForItem() throws InterruptedException {
        Thread.sleep(4000);
    }
}
