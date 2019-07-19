package ru.avtotest.ab.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.avtotest.ab.model.AccountFields;

import java.util.List;

public class AccountDeletionTests extends TestBase{

  @Test
  public void testAccountDeletion(){
    if (! app.getAccountHelper().isThareAAccount()) {
      app.getAccountHelper().createAccount(new AccountFields("Michael",
              "Johnson", "Alexandrovich","Gorilla777",
              "Title Area", "Volkswagen","Russia",
              "Sweet Home", "89997774422","Work Hard",
              "none", "E-mail #1", "E-mail #2",
              "E-mail #3", "facebook.com", null), false);
    }
    List<AccountFields> before = app.getAccountHelper().getAccountList();
    app.getAccountHelper().editAccount(before.size() - 1);
    app.getAccountHelper().deleteAccount();
    app.getNavigationHelper().returntohomepage();
    List<AccountFields> after = app.getAccountHelper().getAccountList();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(before.size() - 1);
    Assert.assertEquals(before, after);

    app.getSessionHelper().logout();
  }
}
