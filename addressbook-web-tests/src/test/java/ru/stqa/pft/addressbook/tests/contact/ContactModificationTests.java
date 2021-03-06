package ru.stqa.pft.addressbook.tests.contact;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.Groups;
import ru.stqa.pft.addressbook.tests.TestBase;

import java.io.File;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class ContactModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions (){
    File photo = new File("src/test/resources/image.jpg");
    Groups groups = app.db().groups();
    if(app.db().contacts().size() == 0){
      app.goTo().homePage();
      app.contact().create( new ContactData().withLastname ("Rudenko").withFirstname ("Dmytro").withAddress("Ukraine Kiev")
              .withTelhome("38044").withTelmobile("38063").withTelwork("38066").withTelfax("38097")
              .withEmailfirst("fel_1@gmail.com").withEmailsecond("fel_2@gmail.com").withEmailthird("fel_3@gmail.com")
              .withBday("6").withBmonth("September").withByear("1989").inGroup(groups.iterator().next()).withPhoto(photo),true);
    }
  }

  @Test
  public void testContactModification() {
    File photo = new File("src/test/resources/image.jpg");
    Groups groups = app.db().groups();
    app.goTo().homePage();
    Contacts before = app.db().contacts();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData().withId (modifiedContact.getId())
            .withFirstname ("Dmytro3").withLastname("Rudenko2").withAddress("Ukraine Kiev")
            .withTelhome("38044").withTelmobile("38063").withTelwork("38066").withTelfax("38097")
            .withEmailfirst("fel_1@gmail.com").withEmailsecond("fel_2@gmail.com").withEmailthird("fel_3@gmail.com")
            .withBday("8").withBmonth("September").withByear("1989").withPhoto(photo).withPhoto(photo).inGroup(groups.iterator().next());
    app.contact().modify(contact);
    app.goTo().homePage();
    assertThat(app.contact().count(), equalTo(before.size()));
    Contacts after = app.db().contacts();
    assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
    verifyContactListInUI();
  }
}
