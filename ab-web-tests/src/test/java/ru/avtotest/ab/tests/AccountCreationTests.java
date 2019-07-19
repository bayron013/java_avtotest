package ru.avtotest.ab.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.avtotest.ab.model.AccountFields;

public class AccountCreationTests extends TestBase {

  @Test
  public void testAccountCreation() throws Exception {
    int before = app.getAccountHelper().getAccountCount();
    app.getAccountHelper().createAccount(new AccountFields("Алексей",
            "Власов", "Алексеевич",
            "Gorilla777", "Title Area", "Volkswagen",
            "Russia", "Sweet Home", "89997774422",
            "Work Hard", "none", "E-mail #1", "E-mail #2",
            "E-mail #3", "facebook.com", "Group 1"), true);
    int after = app.getAccountHelper().getAccountCount();
    Assert.assertEquals(after, before + 1);
    app.getSessionHelper().logout();
  }
}