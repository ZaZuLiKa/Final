package Steps;

import Pages.LoginPage;
import com.codeborne.selenide.Condition;

public class LoginSteps {
    LoginPage loginPage=new LoginPage();
    public LoginSteps login(String userName, String passWord){
        loginPage.getUserInput().shouldBe(Condition.visible).shouldBe(Condition.enabled).setValue(userName);
        loginPage.getPasswordInput().shouldBe(Condition.visible).shouldBe(Condition.enabled).setValue(passWord);
        loginPage.getLoginButton().shouldBe(Condition.visible).shouldBe(Condition.clickable).click();
        return this;
    }
}
