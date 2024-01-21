package valeriialebedeva.niffler.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$$;

public class MainPage {

    // selectors

    private SelenideElement spendingsTableBody = $(".spendings-table tbody"),
    deleteSpendingBtn = $(byText("Delete selected"));


    // actions

    public MainPage findSpendingByDescription(String description) {
                spendingsTableBody
                        .$$("tr")
                        .findBy(text(description))
                        .$$("td")
                        .first().
                        scrollTo()
                        .click();
        return this;
    }



    public MainPage deleteSpending() {
        deleteSpendingBtn.click();
        return this;
    }


    public MainPage checkTableHasNoSpending() {
        spendingsTableBody
                .$$("tr")
                .shouldHave(size(0));
        return this;
    }


}
