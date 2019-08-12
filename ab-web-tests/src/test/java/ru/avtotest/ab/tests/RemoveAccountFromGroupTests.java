package ru.avtotest.ab.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.avtotest.ab.model.AccountFields;
import ru.avtotest.ab.model.Accounts;
import ru.avtotest.ab.model.GroupData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class RemoveAccountFromGroupTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().accounts().size() == 0) {
      app.account().create(new AccountFields()
              .whithFirstname("Михаил").whithLastname("Александрович")
              .whithMiddlename("Крузенштерн").whithNickname("Gorilla777")
              .whithCompany("Volkswagen").whithAddress("Russia").whithHome("Sweet Home")
              .whithSecondEmail("- mail(  )@E-mail/"), false);
      app.goTo().homePage();
    }
    if (app.db().groups().size() == 0) {
      app.goTo().groupPage();
      app.group().create(new GroupData().withName("Запасной вариант")
              .withHeader("Запасная голова").withFooter("Запасные ноги"));
      app.goTo().homePage();
    }
  }

  @Test
  public void testRemoveAccountFromGroup() {
    Accounts before = app.db().accounts();
    AccountFields findAccount = before.iterator().next();
    AccountFields accountAdded = new AccountFields().whithId(findAccount.getId()).whithFirstname("Account Name")
            .whithLastname("Account Lastname").whithMiddlename("Account Middlename");
    app.account().addToGroup(accountAdded);

    app.account().removedFromGroup(accountAdded);

    assertThat(app.account().count(), equalTo(before.size()));
  }

}
