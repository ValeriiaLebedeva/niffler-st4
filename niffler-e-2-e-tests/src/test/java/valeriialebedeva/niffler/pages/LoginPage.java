package valeriialebedeva.niffler.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {


    // selectors
    private SelenideElement name = $("input[name='username']"),
                            password = $("input[name='password']"),
                            signInBtn = $("button[type='submit']");


    // actions

    public LoginPage setNameValue(String value) {
        name.setValue(value);
        return this;
    }

    public LoginPage setPassValue(String value) {
        password.setValue(value);
        return this;
    }

    public LoginPage clickOnTheSubmitBtn() {
        signInBtn.click();
        return this;
    }

}
