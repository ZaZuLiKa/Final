package Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class ProductDetails {
    SelenideElement name=$(".inventory_details_name"),
    price=$(".inventory_details_price"),
    desc=$(".inventory_details_desc"),
    button=$("[data-test='add-to-cart']"),
    backToProducts=$("[data-test='back-to-products']"),
    title=$("span.title");

    public SelenideElement getTitle() {
        return title;
    }

    public SelenideElement getName() {
        return name;
    }

    public SelenideElement getPrice() {
        return price;
    }

    public SelenideElement getDesc() {
        return desc;
    }

    public SelenideElement getButton() {
        return button;
    }

    public SelenideElement getBackToProducts() {
        return backToProducts;
    }
}
