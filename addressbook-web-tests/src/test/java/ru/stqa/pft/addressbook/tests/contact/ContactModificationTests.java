package ru.stqa.pft.addressbook.tests.contact;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.tests.TestBase;

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
    int before = app.getContactHelper().getContactCount();
    app.getContactHelper().selectContact(before - 1);
    app.getContactHelper().initContacModification();
    app.getContactHelper().fillContactForms(new ContactData
            ("Dmytro3", "Rudenko2", "Ukraine Kiev", "38044",
                    "38063", "38066", "38097", "fel_1@gmail.com",
                    "fel_2@gmail.com", "fel_3@gmail.com", "6", "September",
                    "1989", null), false);
    app.getContactHelper().submitContacModification();
    app.getNavigationHelper().gotoHomePage();
    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after, before);
  }


}
