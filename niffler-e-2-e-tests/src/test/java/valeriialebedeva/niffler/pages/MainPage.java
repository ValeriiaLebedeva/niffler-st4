package valeriialebedeva.niffler.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.text;

public class MainPage {

    // actions

    public MainPage findSpendingByDescription(String description) {
        $(".spendings-table tbody")
                .$$("tr")
                .find(text(description))
                .$$("td")
                .first()
                .scrollTo()
                .click();
        return this;
    }



    public MainPage deleteSpending() {
        $(byText("Delete selected")).click();
        return this;
    }


    public MainPage checkTableHasNoSpending() {
        $(".spendings-table tbody")
                .$$("tr")
                .shouldHave(size(0));
        return this;
    }


}
