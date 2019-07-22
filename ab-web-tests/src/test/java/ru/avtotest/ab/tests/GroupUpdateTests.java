package ru.avtotest.ab.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.avtotest.ab.model.GroupData;

import java.util.Set;

public class GroupUpdateTests extends TestBase{

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().groupPage();
    if (app.group().all().size() == 0) {
      app.group().create(new GroupData().whithName("Группа рас"));
    }
  }

  @Test
  public void testGroupUpdate() {
    Set<GroupData> before = app.group().all();
    GroupData modifiedGroup = before.iterator().next();
    GroupData group = new GroupData()
            .whithId(modifiedGroup.getId()).whithName("Август").whithHeader("Раш").whithFooter("Хаш");
    app.group().modify(group);
    Set<GroupData> after = app.group().all();
    Assert.assertEquals(before.size(), after.size());


    before.remove(modifiedGroup);
    before.add(group);
    Assert.assertEquals(before, after);

  }

}
