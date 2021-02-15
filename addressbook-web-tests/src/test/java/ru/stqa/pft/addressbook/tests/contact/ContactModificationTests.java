package ru.stqa.pft.addressbook.tests.contact;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.tests.TestBase;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {
    app.getNavigationHelper().gotoHomePage();
    app.getContactHelper().selectContact();
    app.getContactHelper().initContacModification();
    app.getContactHelper().fillContactForms(new ContactData
            ("Dmytro3", "Rudenko2", "Ukraine Kiev", "38044",
                    "38063", "38066", "38097", "fel_1@gmail.com",
                    "fel_2@gmail.com", "fel_3@gmail.com", "6", "September",
                    "1989", null), false);
    app.getContactHelper().submitContacModification();
    app.getNavigationHelper().gotoHomePage();
  }


}
