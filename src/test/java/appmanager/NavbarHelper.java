package appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavbarHelper extends HelperBase {

    private final WebDriverWait wait;

    public NavbarHelper(WebDriver wd, WebDriverWait wait) {
        super(wd);
        this.wait = wait;
    }

    public void searchItem(String item) throws InterruptedException {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("div.top-nav input#gh-search-input")));
        Thread.sleep(1000);
        wd.findElement(By.cssSelector("div.top-nav input#gh-search-input")).sendKeys(item);
        submitSearchBtn();
    }

    public void submitSearchBtn() {
        deleteSurveyInvite();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.top-nav button.header-search-button[type='submit']")));
        wd.findElement(By.cssSelector("div.top-nav button.header-search-button[type='submit']")).click();
    }
}
