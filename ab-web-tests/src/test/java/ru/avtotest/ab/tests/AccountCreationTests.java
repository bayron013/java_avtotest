package ru.avtotest.ab.tests;

import org.testng.annotations.Test;
import ru.avtotest.ab.model.AccountFields;
import ru.avtotest.ab.model.Accounts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AccountCreationTests extends TestBase {

  @Test
  public void testAccountCreation() throws Exception {
    Accounts before = app.account().all();
    AccountFields account = new AccountFields()
            .whithFirstname("Владик").whithLastname("Аладик").whithMiddlename("Аладушек")
            .whithNickname("Goblin").whithTitlearea("title").whithCompany("Volkswagen")
            .whithAddress("Russia").whithHome("Sweet Home").whithMobilenumber("81117775511")
            .whithAboutworkfield("Work Hard").whithFax("none").whithFirstEmail("none")
            .whithSecondEmail("@gmail.com").whithThirdEmail("@rabler.loh").whithHomepage("vk.ru");
    app.account().create(account, true);
    Accounts after = app.account().all();
    assertThat(after.size(), equalTo(before.size() + 1));
    assertThat(after, equalTo(before.withAc(account.whithId(
            after.stream().mapToInt((a) -> a.getId()).max().getAsInt()))));
  }
}