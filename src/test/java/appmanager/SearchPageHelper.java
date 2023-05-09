package appmanager;

import model.Item;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class SearchPageHelper extends HelperBase {

    private final WebDriverWait wait;

    public SearchPageHelper(WebDriver wd, WebDriverWait wait) {
        super(wd);
        this.wait = wait;
    }

    public List<Item> getItems() {
        List<Item> items = new ArrayList<>();
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("div#main-results div.shop-sku-list-item")));
        List<WebElement> itemsWE = wd.findElements(By.cssSelector("div#main-results div.shop-sku-list-item"));
        for (WebElement item : itemsWE) {
            String name = item.findElement(By.cssSelector("div.column-middle h4 a")).getText();
            String link = item.findElement(By.cssSelector("div.column-middle h4 a")).getAttribute("href");
            String model = item.findElement(By.cssSelector("div.column-middle div.variation-info div.sku-attribute-title")).getText()
                    .replaceAll("Model:", "").replaceAll(" ", "");
            BigDecimal price = new BigDecimal(item.findElement(By.cssSelector("div.column-right div.sku-list-item-price div.priceView-customer-price span[aria-hidden='true']"))
                    .getText().replaceAll("\\$", "").replaceAll(",", ""));
            items.add(new Item().withName(name).withModel(model).withPrice(price).withLink(link));
        }
        return items;
    }

    public void sortItems(String select) throws InterruptedException {
        deleteSurveyInvite();
        Select sortSelect = new Select(wd.findElement(By.cssSelector("label.sort-by-label select#sort-by-select")));
        sortSelect.selectByVisibleText(select);
        Thread.sleep(5000);
    }

    public void openItem(Item item) {
        wd.get(item.getLink());
    }
}
