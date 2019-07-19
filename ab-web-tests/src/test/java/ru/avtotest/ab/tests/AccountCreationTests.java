package ru.avtotest.ab.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.avtotest.ab.model.AccountFields;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class AccountCreationTests extends TestBase {

  @Test
  public void testAccountCreation() throws Exception {
    List<AccountFields> before = app.getAccountHelper().getAccountList();
    AccountFields account = new AccountFields("Алексей",
            "Власов", "Алексеевич",
            "Gorilla777", "Title Area", "Volkswagen",
            "Russia", "Sweet Home", "89997774422",
            "Work Hard", "none", "E-mail #1", "E-mail #2",
            "E-mail #3", "facebook.com", "Group 1");
    app.getAccountHelper().createAccount(account, true);
    List<AccountFields> after = app.getAccountHelper().getAccountList();
    Assert.assertEquals(after.size(), before.size() + 1);

    account.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
    before.add(account);

    Comparator<? super AccountFields> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);

    app.getSessionHelper().logout();
  }
}