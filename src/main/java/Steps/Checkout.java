package Steps;

import Pages.CheckOut;

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
}
