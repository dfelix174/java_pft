package ru.stqa.pft.addressbook.tests.contact;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.tests.TestBase;

import java.util.List;

public class ContactDeletionTests extends TestBase {


  @BeforeMethod
  public void ensurePreconditions (){
    app.getNavigationHelper().gotoHomePage();
    if(! app.getContactHelper().isThereAContact()){
      app.getContactHelper().createContact(new ContactData
              ("Dmytro", null, "Ukraine Kiev", "38044", "38063",
                      "38066", "38097", "fel_1@gmail.com", "fel_2@gmail.com",
                      "fel_3@gmail.com", "6", "September", "1989", "test1"), true);
    }
    app.getNavigationHelper().gotoHomePage();
  }


  @Test
  public void testContactDeletion() {
    List<ContactData> before = app.getContactHelper().getContactList();
    int index = before.size() - 1;
    app.getContactHelper().deleteContact(index);
    app.getNavigationHelper().gotoHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), index);

    before.remove(index);
    Assert.assertEquals(before, after);
  }
}
