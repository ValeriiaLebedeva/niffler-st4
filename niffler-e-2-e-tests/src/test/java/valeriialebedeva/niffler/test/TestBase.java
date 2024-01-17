package valeriialebedeva.niffler.test;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import valeriialebedeva.niffler.pages.LoginPage;
import valeriialebedeva.niffler.pages.MainPage;
import valeriialebedeva.niffler.pages.WelcomePage;

public class TestBase {

    WelcomePage welcomePage = new WelcomePage();
    LoginPage loginPage = new LoginPage();
    MainPage mainPage = new MainPage();

    static {
        Configuration.browserSize = "1980x1024";
    }

    @BeforeEach
    void doLogin() {
        welcomePage.openPage()
                .clickOnTheLoginBtn();

        loginPage.setNameValue("lera")
                .setPassValue("12345")
                .clickOnTheSubmitBtn();
    }
}
