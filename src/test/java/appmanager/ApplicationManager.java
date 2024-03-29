package appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class ApplicationManager {

    private final String browser;
    private WebDriver wd;
    private WebDriverWait wait;
    private NavigationHelper navigationHelper;
    private NavbarHelper navbarHelper;
    private SearchPageHelper searchPageHelper;
    private DetailPageHelper detailPageHelper;
    private CheckoutHelper checkoutHelper;
    private SessionHelper sessionHelper;
    private Properties properties;

    public ApplicationManager(String browser) {
        this.browser = browser;
        properties = new Properties();
    }

    public void init() throws IOException {
        if (browser.equals("chrome")) {
            wd = new ChromeDriver();
        } else if (browser.equals("firefox")) {
            wd = new FirefoxDriver();
        }
        properties.load(new FileReader(new File("src/test/resources/selenium.properties")));
        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
        wd.manage().window().maximize();
        wait = new WebDriverWait(wd, Duration.ofSeconds(5));
        navigationHelper = new NavigationHelper(wd, wait, properties);
        navbarHelper = new NavbarHelper(wd, wait);
        searchPageHelper = new SearchPageHelper(wd, wait);
        detailPageHelper = new DetailPageHelper(wd, wait);
        checkoutHelper = new CheckoutHelper(wd, wait);
        sessionHelper = new SessionHelper(wd, wait);
    }

    public void stop() {
        wd.quit();
        wd = null;
    }

    public NavigationHelper goTo() {
        return navigationHelper;
    }

    public NavbarHelper nav() {
        return navbarHelper;
    }

    public SearchPageHelper searchResult() {
        return searchPageHelper;
    }

    public DetailPageHelper detail() {
        return detailPageHelper;
    }

    public CheckoutHelper checkout() {
        return checkoutHelper;
    }

    public SessionHelper session() {
        return sessionHelper;
    }
}
