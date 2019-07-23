package ru.avtotest.ab.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.avtotest.ab.model.GroupData;
import ru.avtotest.ab.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class GroupUpdateTests extends TestBase{

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().groupPage();
    if (app.group().all().size() == 0) {
      app.group().create(new GroupData().whithName("Группа рас"));
    }
  }

  @Test(enabled = false)
  public void testGroupUpdate() {
    Groups before = app.group().all();
    GroupData modifiedGroup = before.iterator().next();
    GroupData group = new GroupData()
            .whithId(modifiedGroup.getId()).whithName("Август").whithHeader("Раш").whithFooter("Хаш");
    app.group().modify(group);
    Groups after = app.group().all();
    assertEquals(before.size(), after.size());
    assertThat(after, equalTo(before.without(modifiedGroup).withAdded(group)));
  }

}
