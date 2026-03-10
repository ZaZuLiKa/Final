package Steps;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$$;

public class Cart {
    Pages.Cart cart =new Pages.Cart();

    public Cart verifyYourCart(){
        cart.getYourCart().shouldHave(Condition.text("Your Cart"));
        return this;
    }
    public Cart verifyShoppingCart(){
        cart.getShoppingCart().shouldHave(Condition.text("Your Cart"));
        return this;
    }
    public Cart removeItems(){
        cart.getItemsinCart().forEach(SelenideElement::click);
        return this;
    }
    public Cart clickFirstItem(){
        cart.getCartItems().first().click();
        return this;
    }
    public Cart verifyCartText(){
        cart.getYourCart().shouldBe(Condition.visible);

        return this;
    }
    public Cart verifyCartSize(){
        cart.getCartItem().shouldHave(CollectionCondition.sizeLessThanOrEqual(7));
        return this;
    }
    public Cart removeItemBike(){
        cart.getBike().click();
        return this;
    }
    public Cart verifyCartItem(){
        cart.getCartItem().shouldHave(CollectionCondition.size(1));
        return this;
    }
    public Cart verifyBackpack(){
        cart.getInventoryIte().shouldHave(text("Sauce Labs Backpack"));
        return this;
    }
}
