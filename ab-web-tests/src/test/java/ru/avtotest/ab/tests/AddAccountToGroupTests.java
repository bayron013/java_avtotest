package ru.avtotest.ab.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.avtotest.ab.model.AccountFields;
import ru.avtotest.ab.model.Accounts;
import ru.avtotest.ab.model.GroupData;
import ru.avtotest.ab.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AddAccountToGroupTests extends TestBase{

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().accounts().size() == 0) {
      if (app.db().groups().size() == 0) {
        app.goTo().groupPage();
        app.group().create(new GroupData().withName("Запасной вариант")
                .withHeader("Запасная голова").withFooter("Запасные ноги"));
        app.goTo().homePage();
      }
      app.account().create(new AccountFields()
              .whithFirstname("Михаил").whithLastname("Александрович")
              .whithMiddlename("Крузенштерн").whithNickname("Gorilla777")
              .whithCompany("Volkswagen").whithAddress("Russia").whithHome("Sweet Home")
              .whithSecondEmail("- mail(  )@E-mail/"), false);
      app.goTo().homePage();
    }
  }

  @Test
  public void testAddAccountToGroup() {
  Accounts accounts = app.db().accounts();
  Groups groups = app.db().groups();
  for (AccountFields account : accounts) {
    if (account.getGroups().size() != groups.size()) {
      Groups groupsBefore = account.getGroups();
      app.account().addToGroup(account);
      Accounts updatedAccounts = app.db().accounts();
      for (AccountFields updatedAccount : updatedAccounts) {
        if (updatedAccount.getId() == account.getId()) {
          Groups groupsAfter = updatedAccount.getGroups();
          assertThat(groupsAfter.size(), equalTo(groupsBefore.size() + 1));
          Groups groupsWithAdded = new Groups(groupsAfter);
          groupsWithAdded.removeAll(groupsBefore);
          assertThat(groupsAfter, equalTo(groupsBefore.withAddedGr(groupsWithAdded.iterator().next())));
        }
      }
      app.goTo().homePage();
      app.account().showAllGroups();
    }
  }



  }

  /*
  @Test   (это предыдущий вариант)
  public void testAddAccountToGroup() {

    Accounts before = app.db().accounts();
    AccountFields findAccount = before.iterator().next();
    AccountFields accountAdded = new AccountFields().whithId(findAccount.getId()).whithFirstname("Account Name")
            .whithLastname("Account Lastname").whithMiddlename("Account Middlename");
    app.account().addToGroup(accountAdded);
    app.account().toHomePage();

    assertThat(app.account().count(), equalTo(before.size()));
  }
  */
}
