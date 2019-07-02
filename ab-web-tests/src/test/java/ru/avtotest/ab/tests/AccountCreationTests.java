package ru.avtotest.ab.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import ru.avtotest.ab.model.AccountFields;

public class AccountCreationTests extends TestBase {

  @Test
  public void testAccountCreation() throws Exception {
    app.initAccountCreation();
    app.fillAccountForm(new AccountFields("Michael", "Johnson", "Alexandrovich",
            "Gorilla777", "Title Area", "Volkswagen",
            "Russia, Moscow, Central St., house 5", "Sweet Home", "89997774422",
            "Work Hard", "none", "E-mail #1", "E-mail #2",
            "E-mail #3", "facebook.com"));
    app.setBDaydata("6", "October", "1989");
    app.setGroup();
    app.submitAccount();
    app.returntohomepage();
    app.wd.findElement(By.linkText("Logout")).click();
  }

}