package ru.stqa.pft.addressbook.tests.contact;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.tests.TestBase;

import java.util.List;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {
    app.getNavigationHelper().gotoHomePage();
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().createContact(new ContactData
            ("Dmytro", "Rudenko", "Ukraine Kiev", "38044", "38063",
                    "38066", "38097", "fel_1@gmail.com", "fel_2@gmail.com",
                    "fel_3@gmail.com", "6", "September", "1989", "test1"), true);
    app.getNavigationHelper().gotoHomePage();
    List<ContactData> after  = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() + 1);


  }
}
