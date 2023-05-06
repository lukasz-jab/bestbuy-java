package model;

import java.math.BigDecimal;
import java.util.Objects;

public class Item {

    private String name;
    private String model;
    private BigDecimal price;
    private String link;

    public Item() {
    }

    public String getName() {
        return name;
    }

    public Item withName(String name) {
        this.name = name;
        return this;
    }

    public String getModel() {
        return model;
    }

    public Item withModel(String describtion) {
        this.model = describtion;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Item withPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public String getLink() {
        return link;
    }

    public Item withLink(String link) {
        this.link = link;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(name, item.name) && Objects.equals(model, item.model) && Objects.equals(price, item.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, model, price);
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", model='" + model + '\'' +
                ", price=" + price +
                ", link=" + link +
                '}';
    }
}
