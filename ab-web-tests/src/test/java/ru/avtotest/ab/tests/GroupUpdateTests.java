package ru.avtotest.ab.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.avtotest.ab.model.GroupData;

import java.util.Comparator;
import java.util.List;

public class GroupUpdateTests extends TestBase{

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().groupPage();
    if (app.group().list().size() == 0) {
      app.group().create(new GroupData().whithName("Группа рас"));
    }
  }

  @Test
  public void testGroupUpdate() {
    List<GroupData> before = app.group().list();
    int index = before.size() - 1;
    GroupData group = new GroupData()
            .whithId(before.get(index).getId()).whithName("Август").whithHeader("Раш").whithFooter("Хаш");
    app.group().modify(index, group);
    List<GroupData> after = app.group().list();
    Assert.assertEquals(before.size(), after.size());


    before.remove(index);
    before.add(group);
    Comparator<? super GroupData> byId = ((o1, o2) -> Integer.compare(o1.getId(), o2.getId()));
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);

  }

}
