package ru.avtotest.ab.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.avtotest.ab.model.AccountFields;

import java.util.Comparator;
import java.util.List;

public class AccountUpdateTests extends TestBase{

  @Test
  public void testAccountUpdate() throws Exception{
    if (! app.getAccountHelper().isThareAAccount()) {
      app.getAccountHelper().createAccount(new AccountFields("Michael", "Johnson", "Alexandrovich",
              "Gorilla777", "Title Area", "Volkswagen",
              "Russia", "Sweet Home", "89997774422",
              "Work Hard", "none", "E-mail #1", "E-mail #2",
              "E-mail #3", "facebook.com", null), false);
    }
    List<AccountFields> before = app.getAccountHelper().getAccountList();
    app.getAccountHelper().editAccount(before.size() - 1);
    AccountFields account = new AccountFields(before.get(before.size() - 1).getId(),"Michael", "Johnson", "Alexandrovich",
            "Gorilla777", "Title Area", "Volkswagen",
            "Russia", "Sweet Home", "89997774422",
            "Work Hard", "none", "E-mail #1", "E-mail #2",
            "E-mail #3", "facebook.com", null);
    app.getAccountHelper().fillAccountForm(account, false);
    app.getAccountHelper().setBDaydata("6", "October", "1989");
    app.getAccountHelper().updateAccount();
    app.getNavigationHelper().returntohomepage();
    List<AccountFields> after = app.getAccountHelper().getAccountList();
    Assert.assertEquals(after.size(), before.size());

    before.remove((before.size() - 1));
    before.add(account);

    Comparator<? super AccountFields> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);

    app.getSessionHelper().logout();
  }
}
