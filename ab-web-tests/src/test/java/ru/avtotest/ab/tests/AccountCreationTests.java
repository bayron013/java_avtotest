package ru.avtotest.ab.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import ru.avtotest.ab.model.AccountFields;

public class AccountCreationTests extends TestBase {

  @Test
  public void testAccountCreation() throws Exception {
    app.getAccountHelper().initAccountCreation();
    app.getAccountHelper().fillAccountForm(new AccountFields("Michael", "Johnson", "Alexandrovich",
            "Gorilla777", "Title Area", "Volkswagen",
            "Russia, Moscow, Central St., house 5", "Sweet Home", "89997774422",
            "Work Hard", "none", "E-mail #1", "E-mail #2",
            "E-mail #3", "facebook.com"));
    app.getAccountHelper().setBDaydata("6", "October", "1989");
    app.getAccountHelper().setGroup();
    app.getAccountHelper().submitAccount();
    app.getNavigationHelper().returntohomepage();
    app.getSessionHelper().logout();
  }
}