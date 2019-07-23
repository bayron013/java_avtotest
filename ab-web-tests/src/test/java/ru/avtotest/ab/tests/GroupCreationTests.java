package ru.avtotest.ab.tests;

import org.testng.annotations.Test;
import ru.avtotest.ab.model.GroupData;
import ru.avtotest.ab.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreationTests extends TestBase {

  @Test(enabled = false)
  public void testGroupCreation() throws Exception {
    app.goTo().groupPage();
    Groups before = app.group().all();
    GroupData group = new GroupData().whithName("Мама Люба").whithHeader("Давай").whithFooter("Давай");
    app.group().create(group);
    Groups after = app.group().all();
    assertThat(after.size(), equalTo(before.size() + 1));
    assertThat(after, equalTo(before.withAdded(
            group.whithId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
  }
}
