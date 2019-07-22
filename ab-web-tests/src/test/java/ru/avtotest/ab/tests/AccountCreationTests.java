package ru.avtotest.ab.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.avtotest.ab.model.AccountFields;

import java.util.Comparator;
import java.util.List;

public class AccountCreationTests extends TestBase {

  @Test
  public void testAccountCreation() throws Exception {
    List<AccountFields> before = app.account().list();
    AccountFields account = new AccountFields()
            .whithFirstname("Виктор").whithLastname("Саныч").whithMiddlename("Приходько")
            .whithNickname("Goblin").whithTitlearea("title").whithCompany("Volkswagen")
            .whithAddress("Russia").whithHome("Sweet Home").whithMobilenumber("81117775511")
            .whithAboutworkfield("Work Hard").whithFax("none").whithFirstEmail("none")
            .whithSecondEmail("@gmail.com").whithThirdEmail("@rabler.loh").whithHomepage("vk.ru");
    app.account().create(account, true);
    List<AccountFields> after = app.account().list();
    Assert.assertEquals(after.size(), before.size() + 1);

    before.add(account);
    Comparator<? super AccountFields> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);

  }
}