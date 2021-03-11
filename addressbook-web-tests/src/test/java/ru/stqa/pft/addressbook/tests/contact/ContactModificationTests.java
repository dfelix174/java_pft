package ru.stqa.pft.addressbook.tests.contact;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.tests.TestBase;

import java.util.Set;

public class ContactModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions (){
    app.goTo().homePage();
    if(app.contact().all().size() == 0){
      app.contact().create( new ContactData().withFirstname ("Dmytro").withAddress("Ukraine Kiev")
              .withTelhome("38044").withTelmobile("38063").withTelwork("38066").withTelfax("38097")
              .withEmailfirst("fel_1@gmail.com").withEmailsecond("fel_2@gmail.com").withEmailthird("fel_3@gmail.com")
              .withBday("6").withBmonth("September").withByear("1989").withGroup("test1"),true);
    }
    app.goTo().homePage();
  }

  @Test
  public void testContactModification() {
    Set<ContactData> before = app.contact().all();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData().withId (modifiedContact.getId())
            .withFirstname ("Dmytro3").withLastname("Rudenko2").withAddress("Ukraine Kiev")
            .withTelhome("38044").withTelmobile("38063").withTelwork("38066").withTelfax("38097")
            .withEmailfirst("fel_1@gmail.com").withEmailsecond("fel_2@gmail.com").withEmailthird("fel_3@gmail.com")
            .withBday("6").withBmonth("September").withByear("1989");
    app.contact().modify(contact);
    app.goTo().homePage();
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size());
    before.remove(modifiedContact);
    before.add(contact);
    Assert.assertEquals(before, after);
  }

}
