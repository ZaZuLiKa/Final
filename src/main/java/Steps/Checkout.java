package Steps;

import Pages.CheckOut;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class Checkout {
    CheckOut checkOut=new CheckOut();
    public Checkout clickChekc(){
        checkOut.getCheckBut().click();
        return this;
    }
    public Checkout fillData(){
        checkOut.getFirstName().setValue("John");
        checkOut.getLastName().setValue("Doe");
        checkOut.getZip().setValue("12345");
        return this;
    }
    public Checkout clickContinue(){
        checkOut.getButContinue().click();
        return this;
    }

    public Checkout getCheckBut() {
        checkOut.getCheckBut().click();
        return this;
    }
    public Checkout verifyTitle(){
        checkOut.getTitleA().shouldHave(text("Checkout: Overview"));
        return this;
    }

    public CheckOut getCheckOut() {
        return checkOut;
    }

    public Checkout verifyDetails(){
        checkOut.getSumInf().shouldBe(visible);
        checkOut.getSubTotal().shouldHave(text("Item total"));
        checkOut.getTaxLab().shouldHave(text("Tax"));
        checkOut.getTotal().shouldHave(text("Total"));
        checkOut.getFinish().click();
        checkOut.getTitle().shouldHave(text("Checkout: Complete!"));
        checkOut.getHeader().shouldHave(text("Thank you for your order!"));
        checkOut.getCompletetext().shouldBe(visible);
        checkOut.getProducts().shouldBe(visible);

        return this;
    }
}
