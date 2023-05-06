package appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavigationHelper {
    private final WebDriver wd;
    private final WebDriverWait wait;

    public NavigationHelper(WebDriver wd, WebDriverWait wait) {
        this.wd = wd;
        this.wait = wait;
    }

    public void mainPage() {
        wd.get("https://www.bestbuy.com");
    }

    public void chooseCountry(String country) throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='content']//div[@class='country-selection']//img[@alt='" + country + "']")));
        Thread.sleep(2000);
        wd.findElement(By.xpath("//div[@class='content']//div[@class='country-selection']//img[@alt='" + country + "']")).click();
    }
}
