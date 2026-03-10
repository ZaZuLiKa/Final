package Pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class Cart {
    SelenideElement
    cartText=$(".shopping_cart_badge"),
    cart=$("#shopping_cart_container"),
    yourCart=$("span.title"),
    shoppingCart=$(".shopping_cart_link"),
    inventoryIte=$(".cart_item .inventory_item_name"),
    bike=$("[data-test=remove-sauce-labs-bike-light]");
    ElementsCollection itemsinCart=$$x("//button[contains(text(),'Remove')]"),
    cartItems= $$(".inventory_item_name"),
    cartItem=$$(".cart_item");

    public SelenideElement getInventoryIte() {
        return inventoryIte;
    }

    public SelenideElement getBike() {
        return bike;
    }

    public ElementsCollection getCartItem() {

        return cartItem;
    }

    public ElementsCollection getCartItems() {
        return cartItems;
    }
    public SelenideElement getYourCart() {
        return yourCart;
    }

    public SelenideElement getShoppingCart() {
        return shoppingCart;
    }

    public SelenideElement getCart() {
        return cart;
    }

    public SelenideElement getCartText() {
        return cartText;
    }

    public ElementsCollection getItemsinCart() {
        return itemsinCart;
    }
}
