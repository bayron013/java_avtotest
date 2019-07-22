package ru.avtotest.ab.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.avtotest.ab.model.AccountFields;

import java.util.Comparator;
import java.util.List;

public class AccountUpdateTests extends TestBase{

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.account().list().size() == 0) {
      app.account().create(new AccountFields()
              .whithFirstname("Michael").whithLastname("Alexandrovich").whithNickname("Gorilla777")
              .whithCompany("Volkswagen").whithAddress("Russia").whithHome("Sweet Home"), false);
    }
  }

  @Test
  public void testAccountUpdate() throws Exception{

    List<AccountFields> before = app.account().list();
    int index = before.size() - 1;
    AccountFields account = new AccountFields()
            .whithId(before.get(index).getId()).whithFirstname("Виктор").whithLastname("Саныч")
            .whithNickname("Goblin").whithTitlearea("title").whithCompany("Volkswagen").whithAddress("Russia")
            .whithHome("Sweet Home").whithMobilenumber("81117775511").whithAboutworkfield("Work Hard")
            .whithFax("none").whithFirstEmail("none").whithSecondEmail("@gmail.com").whithThirdEmail("@rabler.loh")
            .whithHomepage("vk.ru");
    app.account().modify(index, account);
    app.goTo().homePage();
    List<AccountFields> after = app.account().list();
    Assert.assertEquals(after.size(), before.size());

    before.remove(index);
    before.add(account);

    Comparator<? super AccountFields> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);

  }

}
