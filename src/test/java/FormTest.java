import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class FormTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.browserVersion = "125.0";
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
    }

    @Test
    void chromeTest() {
        Configuration.browser = "chrome";

        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        $("#uploadPicture").uploadFromClasspath("img/1.png");
    }

    @Test
    void firefoxTest() {
        Configuration.browser = "firefox";

        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        $("#uploadPicture").uploadFromClasspath("img/1.png");
    }

}
