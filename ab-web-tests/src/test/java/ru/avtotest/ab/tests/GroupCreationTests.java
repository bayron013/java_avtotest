package ru.avtotest.ab.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.avtotest.ab.model.GroupData;
import ru.avtotest.ab.model.Groups;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreationTests extends TestBase {

  @DataProvider
  public Iterator<Object[]> validGroups() {
    List<Object[]> list = new ArrayList<Object[]>();
    list.add(new Object[] {
            (new GroupData().withName("Test 1").withHeader("Header 1").withFooter("Footer 1")) });
    list.add(new Object[] {
            (new GroupData().withName("Test 2").withHeader("Header 2").withFooter("Footer 2")) });
    list.add(new Object[] {
            (new GroupData().withName("Test 3").withHeader("Header 3").withFooter("Footer 3")) });
    return list.iterator();
  }

  @Test(dataProvider = "validGroups")
  public void testGroupCreation(GroupData group) {
    app.goTo().groupPage();
    Groups before = app.group().all();
    app.group().create(group);
    assertThat(app.group().count(), equalTo(before.size() + 1));
    Groups after = app.group().all();
    assertThat(after, equalTo(before.withAdded(
            group.whithId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
  }
}
