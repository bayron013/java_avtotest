package ru.avtotest.ab.tests;

import org.testng.annotations.Test;
import ru.avtotest.ab.model.GroupData;

public class GroupDeletionTests extends TestBase {

  @Test
  public void testGroupDeletion() throws Exception {
    app.getNavigationHelper().gotoGroupPage();
    if (! app.getGroupHelper().isThareAGroup()) {
      app.getGroupHelper().createGroup(new GroupData("Group 1", "Group header", "Group footer"));
    }
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().deleteSelecteGroups();
    app.getGroupHelper().returnToGroupPage();
  }
}
