package ru.avtotest.ab.tests;

import org.testng.annotations.Test;

public class AccountDeletionTests extends TestBase{

  @Test
  public void testAccountDeletion(){
    app.getAccountHelper().editAccount();
    app.getAccountHelper().deletAccount();
    app.getNavigationHelper().returntohomepage();
    app.getSessionHelper().logout();
  }
}
