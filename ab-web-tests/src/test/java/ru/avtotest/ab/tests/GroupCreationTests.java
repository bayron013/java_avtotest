package ru.avtotest.ab.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import ru.avtotest.ab.model.GroupData;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() throws Exception {
    app.gotoGroupPage();
    app.initGroupCreation();
    app.fillGroupForm(new GroupData("Group 1", "Group header", "Group footer"));
    app.submitGroupCreation();
    app.returnToGroupPage();
    app.wd.findElement(By.linkText("Logout")).click();
  }
}
