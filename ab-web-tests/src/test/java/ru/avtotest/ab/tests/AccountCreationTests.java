package ru.avtotest.ab.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import ru.avtotest.ab.model.AccountFields;

public class AccountCreationTests extends TestBase {

  @Test
  public void testAccountCreation() throws Exception {
    app.getAccountHelper().createAccount(new AccountFields("Michael", "Johnson", "Alexandrovich",
            "Gorilla777", "Title Area", "Volkswagen",
            "Russia, Moscow, Central St., house 5", "Sweet Home", "89997774422",
            "Work Hard", "none", "E-mail #1", "E-mail #2",
            "E-mail #3", "facebook.com", "Group 1"), true);
    app.getSessionHelper().logout();
  }
}