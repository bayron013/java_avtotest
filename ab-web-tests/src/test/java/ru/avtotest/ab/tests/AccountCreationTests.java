package ru.avtotest.ab.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.avtotest.ab.model.AccountFields;

import java.util.List;

public class AccountCreationTests extends TestBase {

  @Test
  public void testAccountCreation() throws Exception {
    List<AccountFields> before = app.getAccountHelper().getAccountList();
    app.getAccountHelper().createAccount(new AccountFields("Алексей",
            "Власов", "Алексеевич",
            "Gorilla777", "Title Area", "Volkswagen",
            "Russia", "Sweet Home", "89997774422",
            "Work Hard", "none", "E-mail #1", "E-mail #2",
            "E-mail #3", "facebook.com", "Group 1"), true);
    List<AccountFields> after = app.getAccountHelper().getAccountList();
    Assert.assertEquals(after.size(), before.size() + 1);
    app.getSessionHelper().logout();
  }
}