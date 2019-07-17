package ru.avtotest.ab.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.avtotest.ab.model.GroupData;

import java.util.List;

public class GroupUpdateTests extends TestBase{

  @Test
  public void testGroupUpdate() {
    app.getNavigationHelper().gotoGroupPage();
    if (! app.getGroupHelper().isThareAGroup()) {
      app.getGroupHelper().createGroup(new GroupData("Group 1", "Group header", "Group footer"));
    }
    List<GroupData> before = app.getGroupHelper().getGroupList();
    app.getGroupHelper().selectGroup(before.size() - 2);
    app.getGroupHelper().editGroup();
    app.getGroupHelper().fillGroupForm(new GroupData("Group 8", "Група крови", "На рукаве"));
    app.getGroupHelper().updateGroup();
    app.getGroupHelper().returnToGroupPage();
    List<GroupData> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(before.size(), after.size());
    app.getSessionHelper().logout();
  }
}
