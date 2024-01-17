package valeriialebedeva.niffler.test;

import org.junit.jupiter.api.Test;
import valeriialebedeva.niffler.jupiter.GenerateCategory;
import valeriialebedeva.niffler.jupiter.GenerateSpend;
import valeriialebedeva.niffler.model.CurrencyValues;
import valeriialebedeva.niffler.model.SpendJson;

import static com.codeborne.selenide.Selenide.sleep;


public class SpendingTest extends TestBase{

  @GenerateCategory(
          username = "lera",
          category = "Путешествия123"
  )

  @GenerateSpend(
      username = "lera",
      description = "QA.GURU Advanced 4",
      amount = 72500.00,
      category = "Путешествия123",
      currency = CurrencyValues.RUB
  )

  @Test
  void spendingShouldBeDeletedByButtonDeleteSpending(SpendJson spend) {

    mainPage.findSpendingByDescription(spend.description())
                    .deleteSpending()
            .checkTableHasNoSpending();
    sleep(10000);
  }
}
