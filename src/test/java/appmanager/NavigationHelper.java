package appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Properties;

public class NavigationHelper {
    private final WebDriver wd;
    private final WebDriverWait wait;
    private Properties properties;

    public NavigationHelper(WebDriver wd, WebDriverWait wait, Properties properties) {
        this.wd = wd;
        this.wait = wait;
        this.properties = properties;
    }

    public void mainPage() {
        wd.get(properties.getProperty("baseUrl"));
    }

    public void chooseCountry(String country) throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='content']//div[@class='country-selection']//img[@alt='" + country + "']")));
        Thread.sleep(2000);
        wd.findElement(By.xpath("//div[@class='content']//div[@class='country-selection']//img[@alt='" + country + "']")).click();
    }
}
