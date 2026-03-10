package Steps;

import Pages.Cart;
import Pages.InventoryPage;
import Pages.LoginPage;
import Utils.Calculations;
import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$$;

public class InventorySteps {
    InventoryPage page=new InventoryPage();
    LoginPage loginPage=new LoginPage();
    Cart cart=new Cart();
    Calculations calculations=new Calculations();
    public InventorySteps verifyInventory(String text){
        page.getInventory().shouldBe(Condition.visible);
        page.getTitle().shouldHave(text(text));
        return this;
    }
    public InventorySteps logOut() {
        page.getMenu().click();
        page.getLogout().click();
        loginPage.getLoginButton().shouldBe(Condition.visible);
        return this;
    }
    public InventorySteps verifySort(){
        page.getSort().shouldBe(Condition.visible);
        return this;
    }
    public InventorySteps chooseSorting(){
        page.getSort().selectOption("Name (Z to A)");
        return this;
    }
    public InventorySteps verifyFirstItem(String name){
        page.getItem().first().shouldHave(text(name));
        return this;
    }
    public InventorySteps verifyLast(String name){
        page.getItem().last().shouldHave(text(name));
        return this;
    }
    public InventorySteps verifyItems(){
        page.getItem().shouldHave(CollectionCondition.size(6));
        return this;
    }
    public InventorySteps addItem(){
        page.getAddBackPack().click();
        return this;
    }
    public InventorySteps verifyCartIsNotEmpty(){
        cart.getCartText().shouldNotHave(Condition.text("0"));
        return this;
    }
    public InventorySteps verifyCartT(){
        cart.getCartText().shouldHave(text("2"));
        return this;
    }
    public InventorySteps clickOnCart(){
        cart.getCart().click();
        return this;
    }
    public InventorySteps selectSortDesc(){
        page.getSort().selectOption("Price (low to high)");
        return this;
    }
    public InventorySteps getData(){
        calculations.getData(page.getItPrice());
        return this;
    }
    public InventorySteps verifyColSize(){
        page.getItPrice().shouldHave(CollectionCondition.size(6));
        return this;
    }
    public InventorySteps verifyPrices(){
        var x=calculations.getData(page.getItPrice());
        var y=calculations.sort(x);
        assert x.equals(y)
                : "Prices are not sorted low to high. Actual: " + x;
        $$(".inventory_item_price").first().shouldHave(text("7.99"));
        $$(".inventory_item_price").last().shouldHave(text("49.99"));
        return this;
    }
    public InventorySteps addBike(){
        page.getAddBike().click();
        return this;
    }
    public InventorySteps addBackPack(){
        page.getAddBackPack().click();
        return this;
    }
}
