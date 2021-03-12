package ru.stqa.pft.addressbook.tests.group;

import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;
import ru.stqa.pft.addressbook.tests.TestBase;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreationTests extends TestBase {

  @DataProvider
  public Iterator<Object[]> validGroups(){
    List<Object[]> list = new ArrayList<Object[]>();
    list.add(new Object[]{new GroupData().withName("test1").withHeader("test1").withFooter("test1")});
    list.add(new Object[]{new GroupData().withName("test2").withHeader("test2").withFooter("test3")});
    list.add(new Object[]{new GroupData().withName("test3").withHeader("test3").withFooter("test3")});
    return list.iterator();
  }


  @Test(dataProvider = "validGroups")
  public void testGroupCreation(GroupData group) {
    app.goTo().groupPage();
    Groups before = app.group().all();
    app.group().create(group);
    assertThat(app.group().count(), equalTo(before.size() + 1));
    Groups after = app.group().all();
    assertThat(after, equalTo(
            before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
  }


  @Test(enabled = false)
  public void testBadGroupCreation() {
    app.goTo().groupPage();
    Groups before = app.group().all();
    GroupData group = new GroupData().withName("test1'").withHeader("test2").withFooter("null");
    app.group().create(group);
    assertThat(app.group().count(), equalTo(before.size()));
    Groups after = app.group().all();
    assertThat(after, equalTo(before));
  }


}
