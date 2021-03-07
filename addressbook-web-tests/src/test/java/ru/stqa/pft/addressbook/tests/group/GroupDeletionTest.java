package ru.stqa.pft.addressbook.tests.group;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.tests.TestBase;

import java.util.HashSet;
import java.util.List;

public class GroupDeletionTest extends TestBase {


  @BeforeMethod
  public void ensurePreconditions (){
    app.getNavigationHelper().gotoGroupPage();
    if (! app.getGroupHelper().isThereAGroup()){
      app.getGroupHelper().createGroup(new GroupData("test1", "test2", "null"));
    }
  }

  @Test
  public void testGroupDeletion() {
    app.getNavigationHelper().gotoGroupPage();
    List<GroupData> before = app.getGroupHelper().getGroupList();
    int index = before.size() - 1;
    app.getGroupHelper().deleteGroup(index);
    List<GroupData> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(), index);

    before.remove(index);
    Assert.assertEquals(before, after);
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
  }
}
