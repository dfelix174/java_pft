package ru.stqa.pft.addressbook.tests.contact;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.tests.TestBase;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {
    app.getNavigationHelper().gotoHomePage();
    if(! app.getContactHelper().isThereAContact()){
      app.getContactHelper().createContact(new ContactData
              ("Dmytro", null, "Ukraine Kiev", "38044", "38063",
                      "38066", "38097", "fel_1@gmail.com", "fel_2@gmail.com",
                      "fel_3@gmail.com", "6", "September", "1989", "test1"), true);
    }
    app.getNavigationHelper().gotoHomePage();
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().selectContact(before.size() - 1);
    app.getContactHelper().initContacModification();
    ContactData contact = new ContactData (before.get(before.size() - 1).getId(),"Dmytro3", "Rudenko2", "Ukraine Kiev", "38044",
                    "38063", "38066", "38097", "fel_1@gmail.com",
                    "fel_2@gmail.com", "fel_3@gmail.com", "6", "September",
                    "1989", null);
    app.getContactHelper().fillContactForms(contact, false);
    app.getContactHelper().submitContacModification();
    app.getNavigationHelper().gotoHomePage();

//    before.remove(before.size() - 1);
//    before.add(contact);

    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());


    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId()) ;
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }


}
