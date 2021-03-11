package ru.stqa.pft.addressbook.tests.contact;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.tests.TestBase;

import java.util.Comparator;
import java.util.List;

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
    List<ContactData> before = app.contact().getContactList();
    int index = before.size() - 1;
    ContactData contact = new ContactData().withId (before.get(index).getId())
            .withFirstname ("Dmytro3").withLastname("Rudenko2").withAddress("Ukraine Kiev")
            .withTelhome("38044").withTelmobile("38063").withTelwork("38066").withTelfax("38097")
            .withEmailfirst("fel_1@gmail.com").withEmailsecond("fel_2@gmail.com").withEmailthird("fel_3@gmail.com")
            .withBday("6").withBmonth("September").withByear("1989");
    app.contact().modify(before, contact);
    app.goTo().homePage();
    List<ContactData> after = app.contact().getContactList();
    Assert.assertEquals(after.size(), before.size());
    before.remove(index);
    before.add(contact);

    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId()) ;
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }

}
