package appmanager;

import model.Item;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.math.BigDecimal;

public class DetailPageHelper {

    private final WebDriver wd;
    private final WebDriverWait wait;

    public DetailPageHelper(WebDriver wd, WebDriverWait wait) {
        this.wd = wd;
        this.wait = wait;
    }

    public Item getItem() {
        String name = wd.findElement(By.cssSelector("div.shop-product-title div[itemprop='name'] h1")).getText();
        String model = wd.findElement(By.cssSelector("div.shop-product-title span.product-data-value.body-copy")).getText();
        BigDecimal price = new BigDecimal(wd.findElement(By.cssSelector("div.container-v3 div.priceView-layout-large div.priceView-customer-price span[aria-hidden='true']"))
                .getText().replaceAll("\\$", ""));
        return new Item().withName(name).withModel(model).withPrice(price);
    }

    public void addToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[id^='fulfillment-add-to-cart-button'] button[data-button-state='ADD_TO_CART']")));
        wd.findElement(By.cssSelector("div[id^='fulfillment-add-to-cart-button'] button[data-button-state='ADD_TO_CART']")).click();
    }

    public void goToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.c-modal-grid div.go-to-cart-button a")));
        wd.findElement(By.cssSelector("div.c-modal-grid div.go-to-cart-button a")).click();
    }
}
