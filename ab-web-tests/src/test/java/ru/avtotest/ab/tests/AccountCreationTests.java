package ru.avtotest.ab.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.avtotest.ab.model.AccountFields;

import java.util.Set;

public class AccountCreationTests extends TestBase {

  @Test
  public void testAccountCreation() throws Exception {
    Set<AccountFields> before = app.account().all();
    AccountFields account = new AccountFields()
            .whithFirstname("Виктор").whithLastname("Саныч").whithMiddlename("Приходько")
            .whithNickname("Goblin").whithTitlearea("title").whithCompany("Volkswagen")
            .whithAddress("Russia").whithHome("Sweet Home").whithMobilenumber("81117775511")
            .whithAboutworkfield("Work Hard").whithFax("none").whithFirstEmail("none")
            .whithSecondEmail("@gmail.com").whithThirdEmail("@rabler.loh").whithHomepage("vk.ru");
    app.account().create(account, true);
    Set<AccountFields> after = app.account().all();
    Assert.assertEquals(after.size(), before.size() + 1);

    account.whithId(after.stream().mapToInt((a) -> a.getId()).max().getAsInt());
    before.add(account);
    Assert.assertEquals(before, after);

  }
}