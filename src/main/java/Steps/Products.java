package Steps;

import Pages.ProductDetails;
import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Condition.text;

public class Products {
    ProductDetails productDetails=new ProductDetails();
    public Products verifyName(){
        productDetails.getName().shouldBe(Condition.visible);
        return this;
    }
    public Products verifyPrice(){
        productDetails.getPrice().shouldBe(Condition.visible);
        return this;
    }
    public Products verifyDesc(){
        productDetails.getDesc().shouldBe(Condition.visible);
        return this;
    }
    public Products verifyBackToProducts(){
        productDetails.getBackToProducts().shouldBe(Condition.visible);
        return this;
    }
    public Products verifyButton(){
        productDetails.getButton().shouldBe(Condition.visible);
        return this;
    }
    public Products clickToBack(){
        productDetails.getBackToProducts().click();
        return this;
    }
    public Products verifySection(){
        productDetails.getTitle().shouldHave(text("Products"));
        return this;
    }
}
