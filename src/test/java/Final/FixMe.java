package Final;

import Pages.CheckOut;
import Steps.*;
import Utils.BaseTest;
import com.codeborne.selenide.*;
import org.apache.poi.ss.formula.functions.DProduct;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static Data.Constants.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class FixMe extends BaseTest {
    InventorySteps inventorySteps=new InventorySteps();
    LoginSteps steps=new LoginSteps();
    Cart cart=new Cart();
    Products products=new Products();
    Checkout checkout=new Checkout();
    @BeforeMethod
    public void setUp() {
        open(BASE_URL);
        steps.login(USERNAME,PASSWORD);
        //$(".inventory").shouldBe(visible);
        inventorySteps.verifyInventory(prod);
        //$("span.title").shouldHave(text("პროდუქტები"));
    }
    @AfterClass
    public void tearDown() {
       // sleep(450000);
        open(BASE_URL + "inventory.html");
//        $("#react-burger-menu-btn").click();
//        $("#logout_sidebar_link").click();
//        $("#login-button").shouldBe(visible);
        inventorySteps.logOut();
        Selenide.closeWebDriver();
        //sleep(450000);
    }

    private void resetCart() {
        open(BASE_URL + "cart.html");
        //$$(".cart_item [data^='remove']").forEach(SelenideElement::click);
      //  $$("#remove-sauce-labs-backpack").forEach(SelenideElement::click);
        cart.removeItems();
    }

    @Test(description = "Verify all 6 products are displayed and Z-A sort works correctly", priority = 1)
    public void testProductListingAndSorting() {
        open(BASE_URL + "inventory.html");
        //$$(".inventory_item").shouldHave(CollectionCondition.size(6));
        inventorySteps.verifyItems();
        //$(".product_sort_container").selectOption("Name (Z to A)");
        inventorySteps.chooseSorting();
        //$$(".inventory_item_name").first().shouldNotHave(text("Test.allTheThings()"));
        inventorySteps.verifyFirstItem(firstItem);
       // $$(".inventory_item_name").get(2).shouldHave(text("Sauce Labs Backpack"));
        inventorySteps.verifyLast(lastItem);
    }

    @Test(description = "Add Sauce Labs Backpack to cart and verify cart page", priority = 2)
    public void testAddToCart() {
        resetCart();
        open(BASE_URL + "inventory.html");
        //$("[data-test='add-to-cart-sauce-labs-backpack']").click();
        inventorySteps.addItem();
        //$(".shopping_cart_badge").shouldHave(text("17"));
        inventorySteps.verifyCartIsNotEmpty();
        //$("#shopping_cart_container").click();
        inventorySteps.clickOnCart();
        //$("span.title").shouldHave(text("Your Cart"));
        cart.verifyYourCart();
//        $(".cart_item .inventory_item_name")
//                .shouldBe(enabled)
//                .shouldHave(text("Sauce Labs Backpack"));
    }

    @Test(description = "Verify product detail page elements and back-to-products navigation", priority = 3)
    public void testNavigationAndUI() {
        resetCart();
        open(BASE_URL + "inventory.html");
        //$("span.title").shouldHave(text("Products"));
        inventorySteps.verifyInventory(prod);
        //$(".shopping_cart_link").shouldBe(visible);
        cart.verifyCartText();
        //$$(".inventory_item_name").first().click();
        cart.clickFirstItem();
        $(".inventory_details_name").shouldBe(visible);
        products.verifyName();
        $(".inventory_details_price").shouldBe(visible);
        products.verifyPrice();
        $(".inventory_details_desc").shouldBe(visible);
        products.verifyDesc();
        $("[data-test='add-to-cart']").shouldBe(visible);
        products.verifyButton();
        //$("[data-test='back-to-products']").click();
        products.clickToBack();
        $("span.title").shouldHave(text("Products"));
        products.verifySection();
        //$$(".inventory_item").shouldHave(CollectionCondition.size(6));
        inventorySteps.verifyItems();
    }

    @Test(description = "Verify price low-to-high sort produces correctly ordered prices", priority = 4)
    public void testPriceSortingLowToHigh() {
        open(BASE_URL + "inventory.html");
        //$(".product_sort_container").selectOption("Price (low to high)");
        inventorySteps.selectSortDesc();
        //ElementsCollection priceElements = $$(".inventory_item_price");
        inventorySteps.getData();
        //priceElements.shouldHave(CollectionCondition.size(6));
        inventorySteps.verifyColSize();
//        List<Double> actualPrices = new ArrayList<>();
//        for (int i = 0; i < priceElements.size(); i++) {
//            String raw = priceElements.get(i).getText().replace("$", "").trim();
//            actualPrices.add(Double.parseDouble(raw));
//        }
        inventorySteps.getData();
//        List<Double> expectedPrices = new ArrayList<>(actualPrices);
//        Collections.sort(expectedPrices);

//        assert actualPrices.equals(expectedPrices)
//                : "Prices are not sorted low to high. Actual: " + actualPrices;
//
//        $$(".inventory_item_price").first().shouldHave(text("7.99"));
//        $$(".inventory_item_price").last().shouldHave(text("49.99"));
        inventorySteps.verifyPrices();
    }

    @Test(description = "Add two products, remove one, complete full checkout and verify confirmation", priority = 5)
    public void testFullCheckoutFlow() {
        resetCart();
        open(BASE_URL + "inventory.html");
       // $("[data-test=add-to-cart-sauce-labs-backpack]").click();
        inventorySteps.addBackPack();
       //$("[data-test=add-to-cart-sauce-labs-bike-light]").click();
        inventorySteps.addBike();
        //".shopping_cart_badge").shouldHave(text("2"));
        inventorySteps.verifyCartT();
       // $(".shopping_cart_link").click();
        inventorySteps.clickOnCart();
       //$("span.title").shouldHave(text("Your Cart"));
        cart.verifyYourCart();
        //$$(".cart_item").shouldHave(CollectionCondition.sizeLessThanOrEqual(7));
        cart.verifyCartSize();
        //$("[data-test=remove-sauce-labs-bike-light]").click();
        cart.removeItemBike();

       // $$(".cart_item").shouldHave(CollectionCondition.size(1));
        cart.verifyCartItem();
        //$(".cart_item .inventory_item_name").shouldBe(text("Sauce Labs Backpack"));
        cart.verifyBackpack();
       // $("#checkout").click();
        checkout.getCheckBut();
        $("span.title").shouldHave(text("Checkout: Your Information"));

//        $("[data-test='firstName']").setValue("John");
//        $("[data-test='lastName']").setValue("Doe");
//        $("[data-test='postalCode']").setValue("12345");
        checkout.fillData();
       // $("#continue").click();
        checkout.clickContinue();
        $("span.title").shouldHave(text("Checkout: Overview"));

        $(".summary_info").shouldBe(visible);
        $(".summary_subtotal_label").shouldHave(text("Item total"));
        $(".summary_tax_label").shouldHave(text("Tax"));
        $(".summary_total_label").shouldHave(text("Total"));
        $("#finish").click();
        $("span.title").shouldHave(text("Checkout: Complete!"));
        $(".complete-header").shouldHave(text("Thank you for your order!"));
        $(".complete-text").shouldBe(visible);
        $("[data-test='back-to-products']").shouldBe(visible);
    }
}