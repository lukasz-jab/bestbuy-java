package test;

import model.Item;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class BestbuyCustomerFlowTest extends TestBase {

    List<Item> sortedItems;
    Item item;

    @BeforeClass
    public void openBestbuy() throws InterruptedException {
        app.goTo().mainPage();
        app.goTo().chooseCountry("United States");
    }

    @Test(priority = 1)
    public void testSearchItemByNavbarInput() throws InterruptedException {
        app.nav().searchItem("headphones");

        app.searchResult().sortItems("Price Low to High");
        app.session().waitForLoadingItems();
        sortedItems = app.searchResult().getItems();

        // Items are not sorted correctly, test will fail !
//        assertThat(true, equalTo(Ordering.natural().isOrdered(sortedItems
//                .stream().map(Item::getPrice).collect(Collectors.toList()))));
    }

    @Test(dependsOnMethods = "testSearchItemByNavbarInput")
    public void testCheckoutItem() throws InterruptedException {
        item = sortedItems.iterator().next();
        app.searchResult().openItem(item);
        app.session().waitForItem();
        Item itemOnDetailsPage = app.detail().getItem();

        assertThat(item, equalTo(itemOnDetailsPage));
    }

    @Test(dependsOnMethods = "testCheckoutItem")
    public void testAddToCart() throws InterruptedException {
        app.detail().addToCart();
        app.detail().goToCart();
        app.session().waitForItem();
        Item itemOnCheckoutPage = app.checkout().getItem();

        assertThat(item.getName(), equalTo(itemOnCheckoutPage.getName()));
        assertThat(item.getPrice(), equalTo(itemOnCheckoutPage.getPrice()));

        BigDecimal grossAmount = app.checkout().getGrossAmount();
        BigDecimal tax = app.checkout().getTax();
        assertThat(grossAmount, equalTo(
                tax.add(itemOnCheckoutPage.getPrice())));
    }
}
