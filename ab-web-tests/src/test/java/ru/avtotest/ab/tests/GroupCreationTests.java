package ru.avtotest.ab.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import ru.avtotest.ab.model.GroupData;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() throws Exception {
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().createGroup(new GroupData("Group 1", "Group header", "Group footer"));
    app.getSessionHelper().logout();
  }
}
