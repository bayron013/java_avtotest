package ru.avtotest.ab.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.avtotest.ab.model.AccountFields;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AccountPhoneTests extends TestBase {


  @BeforeMethod
  public void ensurePreconditions() {
    if (app.account().all().size() == 0) {
      app.account().create(new AccountFields()
              .whithFirstname("Michael").whithLastname("Alexandrovich").whithNickname("Gorilla777")
              .whithCompany("Volkswagen").whithAddress("Russia").whithHome("Sweet Home"), false);
    }
  }

  @Test
  public void testAccountPhones() {
    app.goTo().homePage();
    AccountFields account = app.account().all().iterator().next();
    AccountFields accountInfoPhoneEditForm = app.account().infoFromEditForm(account);

    assertThat(account.getHome(), equalTo(cleaned(accountInfoPhoneEditForm.getHome())));
    assertThat(account.getMobile(), equalTo(cleaned(accountInfoPhoneEditForm.getMobile())));
    assertThat(account.getWork(), equalTo(cleaned(accountInfoPhoneEditForm.getWork())));
  }

  public String cleaned(String phone) {
    return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
  }
}
