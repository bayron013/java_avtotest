package ru.avtotest.ab.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.avtotest.ab.model.GroupData;

import java.util.Comparator;
import java.util.List;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() throws Exception {
    app.goTo().groupPage();
    List<GroupData> before = app.group().list();
    GroupData group = new GroupData().whithName("Мама Люба").whithHeader("Давай").whithFooter("Давай");
    app.group().create(group);
    List<GroupData> after = app.group().list();
    Assert.assertEquals(after.size(), before.size() + 1);


    before.add(group);
    Comparator<? super GroupData> byId = ((o1, o2) -> Integer.compare(o1.getId(), o2.getId()));
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);

  }
}
