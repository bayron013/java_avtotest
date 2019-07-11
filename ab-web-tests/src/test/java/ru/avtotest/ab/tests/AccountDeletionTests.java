package ru.avtotest.ab.tests;

import org.testng.annotations.Test;
import ru.avtotest.ab.model.AccountFields;

public class AccountDeletionTests extends TestBase{

  @Test
  public void testAccountDeletion(){
    if (! app.getAccountHelper().isThareAAccount()) {
      app.getAccountHelper().createAccount(new AccountFields("Michael", "Johnson", "Alexandrovich",
              "Gorilla777", "Title Area", "Volkswagen",
              "Russia, Moscow, Central St., house 5", "Sweet Home", "89997774422",
              "Work Hard", "none", "E-mail #1", "E-mail #2",
              "E-mail #3", "facebook.com", null), false);
    }
    app.getAccountHelper().editAccount();
    app.getAccountHelper().deletAccount();
    app.getNavigationHelper().returntohomepage();
    app.getSessionHelper().logout();
  }
}