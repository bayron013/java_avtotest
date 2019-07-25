package ru.avtotest.ab.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.avtotest.ab.model.AccountFields;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AccountAddressTests extends TestBase{

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.account().all().size() == 0) {
      app.account().create(new AccountFields()
              .whithFirstname("Michael").whithLastname("Alexandrovich").whithNickname("Gorilla777")
              .whithCompany("Volkswagen").whithAddress("Russia").whithHome("Sweet Home"), false);
    }
  }

  @Test
  public void testAccountEmail() {
    app.goTo().homePage();
    AccountFields account = app.account().all().iterator().next();
    AccountFields accountAddressForm = app.account().infoFromEditForm(account);

    assertThat(account.getAddress(), equalTo(accountAddressForm.getAddress()));
  }

/*  public String cleaned(String email) {
    return email.replaceAll("\\s", "").replaceAll("[-()]", "");
  } */

}
