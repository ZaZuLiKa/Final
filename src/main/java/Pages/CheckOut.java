package Pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CheckOut {
    SelenideElement checkBut=$("#checkout"),
    firstName=$("[data-test='firstName']"),
    lastName=$("[data-test='lastName']"),
    zip=$("[data-test='postalCode']"),
    butContinue=$("#continue"),
    title=$("span.title"),
    sumInf=$(".summary_info"),
    subTotal=$(".summary_subtotal_label"),
    taxLab=$(".summary_tax_label"),
   total= $(".summary_total_label");

    public SelenideElement getTitle() {
        return title;
    }

    public SelenideElement getSumInf() {
        return sumInf;
    }

    public SelenideElement getSubTotal() {
        return subTotal;
    }

    public SelenideElement getTaxLab() {
        return taxLab;
    }

    public SelenideElement getTotal() {
        return total;
    }


    public SelenideElement getButContinue() {
        return butContinue;
    }

    public SelenideElement getFirstName() {
        return firstName;
    }

    public SelenideElement getZip() {
        return zip;
    }

    public SelenideElement getLastName() {
        return lastName;
    }

    public SelenideElement getCheckBut() {
        return checkBut;
    }
}
