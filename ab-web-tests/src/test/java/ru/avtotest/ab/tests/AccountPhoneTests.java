package ru.avtotest.ab.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.avtotest.ab.model.AccountFields;

import java.util.Arrays;
import java.util.stream.Collectors;

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

    assertThat(account.getAllPhones(), equalTo(mergePhones(accountInfoPhoneEditForm)));
  }

  private String mergePhones(AccountFields account) {
    return Arrays.asList(account.getHome(), account.getMobile(), account.getWork())
            .stream().filter((a) -> ! a.equals(""))
            .map(AccountPhoneTests::cleaned).collect(Collectors.joining("\n"));
  }

  public static String cleaned(String phone) {
    return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
  }
}
