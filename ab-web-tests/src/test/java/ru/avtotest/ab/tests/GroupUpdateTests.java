package ru.avtotest.ab.tests;

import org.testng.annotations.Test;
import ru.avtotest.ab.model.GroupData;

public class GroupUpdateTests extends TestBase{

  @Test
  public void testGroupUpdate() {
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().editGroup();
    app.getGroupHelper().fillGroupForm(new GroupData("Group 1", "Group header", "Group footer"));
    app.getGroupHelper().updateGroup();
    app.getGroupHelper().returnToGroupPage();
    app.getSessionHelper().logout();
  }
}
