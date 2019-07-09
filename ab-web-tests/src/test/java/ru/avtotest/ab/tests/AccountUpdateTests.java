package ru.avtotest.ab.tests;

import org.testng.annotations.Test;
import ru.avtotest.ab.model.AccountFields;

public class AccountUpdateTests extends TestBase{

  @Test
  public void testAccountUpdate() throws Exception{
    app.getAccountHelper().editAccount();
    app.getAccountHelper().fillAccountForm(new AccountFields("Michael", "Johnson", "Alexandrovich",
            "Gorilla777", "Title Area", "Volkswagen",
            "Russia, Moscow, Central St., house 5", "Sweet Home", "89997774422",
            "Work Hard", "none", "E-mail #1", "E-mail #2",
            "E-mail #3", "facebook.com", null), false);
    app.getAccountHelper().setBDaydata("6", "October", "1989");
    app.getAccountHelper().updateAccount();
    app.getNavigationHelper().returntohomepage();
    app.getSessionHelper().logout();
  }
}
