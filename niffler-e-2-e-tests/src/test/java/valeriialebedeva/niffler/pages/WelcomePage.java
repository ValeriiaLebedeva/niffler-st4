package valeriialebedeva.niffler.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class WelcomePage {

    // selectors
    private SelenideElement loginBtn = $("a[href*='redirect']");


    // actions

    public WelcomePage openPage() {
        Selenide.open("http://127.0.0.1:3000/main");
        return this;
    }

    public WelcomePage clickOnTheLoginBtn() {
        loginBtn.click();
        return this;
    }
}
