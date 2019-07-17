package ru.avtotest.ab.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.avtotest.ab.model.GroupData;

import java.util.HashSet;
import java.util.List;

public class GroupUpdateTests extends TestBase{

  @Test
  public void testGroupUpdate() {
    app.getNavigationHelper().gotoGroupPage();
    if (! app.getGroupHelper().isThareAGroup()) {
      app.getGroupHelper().createGroup(new GroupData("Group 1", "Group header", "Group footer"));
    }
    List<GroupData> before = app.getGroupHelper().getGroupList();
    app.getGroupHelper().selectGroup(before.size() - 1);
    app.getGroupHelper().editGroup();
    GroupData group = new GroupData(before.get(before.size() - 1).getId(), "Group 8", "Група крови", "На рукаве");
    app.getGroupHelper().fillGroupForm(group);
    app.getGroupHelper().updateGroup();
    app.getGroupHelper().returnToGroupPage();
    List<GroupData> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(before.size(), after.size());


    before.remove(before.size() - 1);
    before.add(group);
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));

    app.getSessionHelper().logout();

  }
}
