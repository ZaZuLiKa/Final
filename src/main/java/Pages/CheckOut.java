package Pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CheckOut {
    SelenideElement checkBut=$("#checkout");
    SelenideElement firstName=$("[data-test='firstName']");
    SelenideElement lastName=$("[data-test='lastName']");
    SelenideElement zip=$("[data-test='postalCode']");
    SelenideElement butContinue=$("#continue");
    SelenideElement title=$("span.title");
    SelenideElement sumInf=$(".summary_info");
    SelenideElement subTotal=$(".summary_subtotal_label");
    SelenideElement taxLab=$(".summary_tax_label");
    SelenideElement total= $(".summary_total_label");
    SelenideElement titleA=$("span.title");
    SelenideElement header= $(".complete-header");

    public SelenideElement getHeader() {
        return header;
    }

    public SelenideElement getCompletetext() {
        return completetext;
    }

    public SelenideElement getProducts() {
        return products;
    }

    SelenideElement completetext=$(".complete-text");
    SelenideElement products=$("[data-test='back-to-products']");
    public SelenideElement getFinish() {
        return finish;
    }

    SelenideElement finish=$("#finish");
    public SelenideElement getTitleA() {
        return titleA;
    }

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
