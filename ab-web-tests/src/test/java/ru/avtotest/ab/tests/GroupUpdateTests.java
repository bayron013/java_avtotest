package ru.avtotest.ab.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.avtotest.ab.model.GroupData;

import java.util.Comparator;
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
    GroupData group = new GroupData(before.get(before.size() - 1).getId(), "Группочка", "Група крови", "На рукаве");
    app.getGroupHelper().fillGroupForm(group);
    app.getGroupHelper().updateGroup();
    app.getGroupHelper().returnToGroupPage();
    List<GroupData> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(before.size(), after.size());


    before.remove(before.size() - 1);
    before.add(group);
    Comparator<? super GroupData> byId = ((o1, o2) -> Integer.compare(o1.getId(), o2.getId()));
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);

    app.getSessionHelper().logout();

  }
}
