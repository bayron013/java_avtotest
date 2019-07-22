package ru.avtotest.ab.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.avtotest.ab.model.AccountFields;

import java.util.Set;

public class AccountUpdateTests extends TestBase{

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.account().all().size() == 0) {
      app.account().create(new AccountFields()
              .whithFirstname("Michael").whithLastname("Alexandrovich").whithNickname("Gorilla777")
              .whithCompany("Volkswagen").whithAddress("Russia").whithHome("Sweet Home"), false);
    }
  }

  @Test
  public void testAccountUpdate() throws Exception{

    Set<AccountFields> before = app.account().all();
    AccountFields modifiedAccount = before.iterator().next();
    AccountFields account = new AccountFields()
            .whithId(modifiedAccount.getId()).whithFirstname("Виктор").whithLastname("Саныч")
            .whithNickname("Goblin").whithTitlearea("title").whithCompany("Volkswagen").whithAddress("Russia")
            .whithHome("Sweet Home").whithMobilenumber("81117775511").whithAboutworkfield("Work Hard")
            .whithFax("none").whithFirstEmail("none").whithSecondEmail("@gmail.com").whithThirdEmail("@rabler.loh")
            .whithHomepage("vk.ru");
    app.account().modify(account);
// придумать способ для выбора модифицируемого аккаунта при помощи id
    app.goTo().homePage();
    Set<AccountFields> after = app.account().all();
    Assert.assertEquals(after.size(), before.size());

    before.remove(modifiedAccount);
    before.add(account);
    Assert.assertEquals(before, after);

  }

}
