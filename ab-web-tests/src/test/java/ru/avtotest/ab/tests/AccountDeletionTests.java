package ru.avtotest.ab.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.avtotest.ab.model.AccountFields;

import java.util.Set;

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
    Set<AccountFields> before = app.account().all();
    AccountFields deletedAccount = before.iterator().next();
    app.account().delete(deletedAccount);
    Set<AccountFields> after = app.account().all();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(deletedAccount);
    Assert.assertEquals(before, after);

  }
}
