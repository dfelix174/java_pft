package ru.stqa.pft.addressbook.tests.contact;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.tests.TestBase;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactEmailTests extends TestBase {


  @BeforeMethod
  public void ensurePreconditions (){
    app.goTo().homePage();
    if(app.contact().all().size() == 0){
      app.contact().create( new ContactData().withLastname ("Rudenko").withFirstname ("Dmytro").withAddress("Ukraine Kiev")
              .withTelhome("38044").withTelmobile("38063").withTelwork("38066").withTelfax("38097")
              .withEmailfirst("fel_1@gmail.com").withEmailsecond("fel_2@gmail.com").withEmailthird("fel_3@gmail.com")
              .withBday("6").withBmonth("September").withByear("1989").withGroup("test 0"),true);
    }
    app.goTo().homePage();
  }


  @Test
  public void testContactEmails() {
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
    assertThat(contact.getAllMails(), equalTo(mergeEmails(contactInfoFromEditForm)));
  }


  private String mergeEmails(ContactData contact) {
    return Arrays.asList(contact.getEmailfirst(), contact.getEmailsecond(), contact.getEmailthird())
            .stream().filter((s) -> ! s.equals(""))
            .map(ContactEmailTests::cleaned)
            .collect(Collectors.joining("\n"));
  }


  public static String cleaned (String phone){
    return phone.replaceAll("\\s", "").replaceAll("[-()]","");
  }

}
