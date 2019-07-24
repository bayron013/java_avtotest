package ru.avtotest.ab.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.avtotest.ab.model.AccountFields;
import ru.avtotest.ab.model.Accounts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AccountDeletionTests extends TestBase{

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.account().all().size() == 0) {
      app.account().create(new AccountFields()
              .whithFirstname("Michael").whithLastname("Alexandrovich").whithNickname("Gorilla777")
              .whithCompany("Volkswagen").whithAddress("Russia").whithHome("Sweet Home"), false);
    }
  }

  @Test
  public void testAccountDeletion(){
    Accounts before = app.account().all();
    AccountFields deletedAccount = before.iterator().next();
    app.account().delete(deletedAccount);
    assertThat(app.account().count(), equalTo(before.size() - 1));
    Accounts after = app.account().all();
    assertThat(after, equalTo(before.withoutAc(deletedAccount)));
  }
}
