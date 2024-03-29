package ru.avtotest.ab.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.avtotest.ab.model.AccountFields;
import ru.avtotest.ab.model.Accounts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AccountUpdateTests extends TestBase{

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().accounts().size() == 0) {
      app.account().create(new AccountFields()
              .whithFirstname("Michael").whithLastname("Alexandrovich").whithNickname("Gorilla777")
              .whithCompany("Volkswagen").whithAddress("Russia").whithHome("Sweet Home")
              .whithSecondEmail("- mail(  )@E-mail/"), false);
    }
  }

  @Test
  public void testAccountUpdate() throws Exception{
    Accounts before = app.db().accounts();
    AccountFields modifiedAccount = before.iterator().next();
    AccountFields account = new AccountFields()
            .whithId(modifiedAccount.getId()).whithFirstname("Геннадий").whithLastname("Геннадьевич")
            .whithMiddlename("Геннадьев").whithNickname("Goblin").whithTitlearea("title").whithCompany("Volkswagen")
            .whithAddress("Russia").whithHome("Sweet Home").whithMobile("81117775511")
            .whithWork("Work Hard").whithFax("none").whithFirstEmail("none")
            .whithSecondEmail("@gmail.com").whithThirdEmail("- mail(  )@E-mail/")
            .whithHomepage("vk.ru");
    app.account().modify(account);
    assertThat(app.account().count(), equalTo(before.size()));
    Accounts after = app.db().accounts();
    assertThat(after, equalTo(before.withoutAc(modifiedAccount).withAddedAc(account)));
    verifyAccountListInUi();
  }

}
