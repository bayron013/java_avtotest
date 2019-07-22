package ru.avtotest.ab.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.avtotest.ab.model.AccountFields;

import java.util.List;

public class AccountDeletionTests extends TestBase{

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.account().list().size() == 0) {
      app.account().create(new AccountFields()
              .whithFirstname("Michael").whithLastname("Alexandrovich").whithNickname("Gorilla777")
              .whithCompany("Volkswagen").whithAddress("Russia").whithHome("Sweet Home"), false);
    }
  }

  @Test
  public void testAccountDeletion(){
    List<AccountFields> before = app.account().list();
    int index = before.size() - 1;
    app.account().edit(index);
    app.account().delete();
    app.goTo().homePage();
    List<AccountFields> after = app.account().list();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(index);
    Assert.assertEquals(before, after);

  }
}
