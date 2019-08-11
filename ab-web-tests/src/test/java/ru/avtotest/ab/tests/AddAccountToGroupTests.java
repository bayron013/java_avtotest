package ru.avtotest.ab.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.avtotest.ab.model.AccountFields;

public class AddAccountToGroupTests extends TestBase{

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
  public void testAddAccountToGroup() {

    app.account().editAccForAddToGroup();
    app.account().editGropForAddAcc();
    app.account().goToEditGroupPage();

  }


}
