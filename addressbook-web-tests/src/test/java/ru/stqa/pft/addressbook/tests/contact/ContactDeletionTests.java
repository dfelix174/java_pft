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
    app.goTo().homePage();
    if(app.contact().getContactList().size() == 0){
      app.contact().create( new ContactData().withFirstname ("Dmytro").withAddress("Ukraine Kiev")
              .withTelhome("38044").withTelmobile("38063").withTelwork("38066").withTelfax("38097")
              .withEmailfirst("fel_1@gmail.com").withEmailsecond("fel_2@gmail.com").withEmailthird("fel_3@gmail.com")
              .withBday("6").withBmonth("September").withByear("1989").withGroup("test1"),true);
    }
    app.goTo().homePage();
  }

  @Test
  public void testContactDeletion() {
    List<ContactData> before = app.contact().getContactList();
    int index = before.size() - 1;
    app.contact().deleteContact(index);
    app.goTo().homePage();
    List<ContactData> after = app.contact().getContactList();
    Assert.assertEquals(after.size(), index);

    before.remove(index);
    Assert.assertEquals(before, after);
  }
}
