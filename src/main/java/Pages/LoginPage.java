package Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private SelenideElement userInput=$("#user-name"),
    passwordInput=$("#password"),
    loginButton= $("#login-button");

    public SelenideElement getUserInput() {
        return userInput;
    }

    public SelenideElement getPasswordInput() {
        return passwordInput;
    }

    public SelenideElement getLoginButton() {
        return loginButton;
    }
}
