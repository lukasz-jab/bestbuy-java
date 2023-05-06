package appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class HelperBase {

    WebDriver wd;

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }

    public boolean isElementPresent(By locator) {
        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        try {
            wd.findElement(locator);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        } finally {
            wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        }
    }

    public void deleteSurveyInvite() {
        if (isElementPresent(By.cssSelector("div#survey_window button#survey_invite_no"))) {
            wd.findElement(By.cssSelector("div#survey_window button#survey_invite_no")).click();
        }
    }
}
