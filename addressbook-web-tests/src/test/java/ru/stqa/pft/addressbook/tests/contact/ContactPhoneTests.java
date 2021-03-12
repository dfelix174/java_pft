package ru.stqa.pft.addressbook.tests.contact;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.tests.TestBase;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class ContactPhoneTests extends TestBase {


  @Test
  public void testContactPhones() {
    app.goTo().homePage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

 assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromEditForm)));
//    assertThat(contact.getTelhome(), equalTo(cleaned(contactInfoFromEditForm.getTelhome())));
//    assertThat(contact.getTelmobile(), equalTo(cleaned(contactInfoFromEditForm.getTelmobile())));
//    assertThat(contact.getTelwork(), equalTo(cleaned(contactInfoFromEditForm.getTelwork())));
  }

  private String mergePhones(ContactData contact) {
    return Arrays.asList(contact.getTelhome(), contact.getTelmobile(), contact.getTelwork())
            .stream().filter((s) -> ! s.equals(""))
            .map(ContactPhoneTests::cleaned)
            .collect(Collectors.joining("\n"));
  }


  public static String cleaned (String phone){
    return phone.replaceAll("\\s", "").replaceAll("[-()]","");
  }
}
