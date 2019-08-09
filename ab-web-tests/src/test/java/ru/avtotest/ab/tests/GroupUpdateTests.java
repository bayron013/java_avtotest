package ru.avtotest.ab.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.avtotest.ab.model.GroupData;
import ru.avtotest.ab.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupUpdateTests extends TestBase{

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().groups().size() == 0) {
      app.goTo().groupPage();
      app.group().create(new GroupData().withName("Группа рас"));
    }
  }

  @Test
  public void testGroupUpdate() {
    Groups before = app.db().groups();
    GroupData modifiedGroup = before.iterator().next();
    GroupData group = new GroupData()
            .withId(modifiedGroup.getId()).withName("Август").withHeader("Раш").withFooter("Хаш");
    app.goTo().groupPage();
    app.group().modify(group);
    assertThat(app.group().count(), equalTo(before.size()));
    Groups after = app.db().groups();
    assertThat(after, equalTo(before.withoutGr(modifiedGroup).withAddedGr(group)));
  }

}
