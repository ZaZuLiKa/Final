package Utils;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import static Data.Constants.BASE_URL;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class BaseTest {

    @BeforeSuite
    public void Cfg(){
        Configuration.browser = "chrome";
        // Configuration.headless = true;
        Configuration.baseUrl = BASE_URL;
        Configuration.timeout = 1000;
        Configuration.pageLoadTimeout = 15000;
    }
   // @BeforeClass  // ან@BeforeClass
    static void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");  // browser notifications
        options.addArguments("--disable-popup-blocking"); // browser popups
        Configuration.browserCapabilities = options;
        Configuration.browser = "chrome";
        //Configuration.timeout = 10000; // Selenide wait

    }
    //@AfterClass
    public void tearDown() {
        // sleep(450000);
        open(BASE_URL + "inventory.html");
        $("#react-burger-menu-btn").click();
        $("#logout_sidebar_link").click();
        $("#login-button").shouldBe(visible);
        Selenide.closeWebDriver();
       // sleep(450000);
    }

}
