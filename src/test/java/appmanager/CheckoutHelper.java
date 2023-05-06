package appmanager;

import model.Item;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.math.BigDecimal;

public class CheckoutHelper {

    private final WebDriver wd;
    private final WebDriverWait wait;

    public CheckoutHelper(WebDriver wd, WebDriverWait wait) {

        this.wd = wd;
        this.wait = wait;
    }

    public Item getItem() {
        String name = wd.findElement(By.cssSelector("section.card h2.cart-item__title-heading")).getText();
        BigDecimal price = new BigDecimal(wd.findElement(By.cssSelector("section.card div.price-block__primary-price"))
                .getText().replaceAll("\\$", ""));
        return new Item().withName(name).withPrice(price);
    }

    public BigDecimal getGrossAmount() {
        return new BigDecimal(wd.findElement(By.xpath("//div[contains(@class, 'below-the-line-item')]//div[position()=2]"))
                .getText().replaceAll("\\$", ""));
    }

    public BigDecimal getTax() {
        return new BigDecimal(wd.findElement(By.xpath("//div[@class='price-summary-line']//a/..//span"))
                .getText().replaceAll("\\$", ""));
    }
}
