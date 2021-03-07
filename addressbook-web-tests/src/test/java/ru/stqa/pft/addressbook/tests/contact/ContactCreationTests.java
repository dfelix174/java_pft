package ru.stqa.pft.addressbook.tests.contact;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.tests.TestBase;

import java.util.HashSet;
import java.util.List;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {
    app.goTo().homePage();
    List<ContactData> before = app.contact().getContactList();
    ContactData contact = new ContactData ("Dmytro", "Rudenko", "Ukraine Kiev", "38044", "38063",
                    "38066", "38097", "fel_1@gmail.com", "fel_2@gmail.com",
                    "fel_3@gmail.com", "6", "September", "1989", "test1");
    app.contact().create(contact, true);
    app.goTo().homePage();
    List<ContactData> after  = app.contact().getContactList();
    Assert.assertEquals(after.size(), before.size() + 1);

    contact.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
    before.add(contact);
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
  }
}
