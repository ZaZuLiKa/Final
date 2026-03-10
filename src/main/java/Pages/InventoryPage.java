package Pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class InventoryPage {
    private SelenideElement Inventory=$("[data-test=inventory-list]"),
    title=$("span.title"),
    menu=$("#react-burger-menu-btn"),
    logout=$("#logout_sidebar_link"),
    sort=$(".product_sort_container"),
    addBackPack=$x("//button[@data-test='add-to-cart-sauce-labs-backpack']"),
    addBike=$("[data-test=add-to-cart-sauce-labs-bike-light]");
    ElementsCollection items=$$(".inventory_item"),
    item=$$(".inventory_item_name"),
    itPrice=$$(".inventory_item_price");

    public SelenideElement getAddBike() {
        return addBike;
    }

    public ElementsCollection getItPrice() {
        return itPrice;
    }

    //$("[data-test=inventory-list]")
    public SelenideElement getAddBackPack() {
        return addBackPack;
    }

    public SelenideElement getSort() {
        return sort;
    }

    public ElementsCollection getItems() {
        return items;
    }

    public ElementsCollection getItem() {
        return item;
    }

    public SelenideElement getInventory() {
        return Inventory;
    }

    public SelenideElement getTitle() {
        return title;
    }

    public SelenideElement getMenu() {
        return menu;
    }

    public SelenideElement getLogout() {
        return logout;
    }
}
