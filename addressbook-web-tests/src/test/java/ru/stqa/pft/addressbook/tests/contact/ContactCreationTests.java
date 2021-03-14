package ru.stqa.pft.addressbook.tests.contact;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.tests.TestBase;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class ContactCreationTests extends TestBase {

  @DataProvider
  public Iterator<Object[]> validContactsFromCsv() throws IOException {
    File photo = new File("src/test/resources/image.jpg");
    List<Object[]> list = new ArrayList<Object[]>();

    try (BufferedReader reader = new BufferedReader (new FileReader(new File("src/test/resources/contacts.csv")))) {
      String line = reader.readLine();
      while (line != null){
        String[] split = line.split(";");
        list.add(new Object[]{new ContactData().withFirstname (split[0]).withLastname(split[1]).withAddress(split[2])
                .withTelhome(split[3]).withTelmobile(split[4]).withTelwork(split[5]).withTelfax(split[6])
                .withEmailfirst(split[7]).withEmailsecond(split[8]).withEmailthird(split[9])
                .withBday(split[10]).withBmonth(split[11]).withPhoto(photo).withByear(split[12]).withGroup(split[13])});
        line = reader.readLine();
      }
      return list.iterator();
    }
  }

  @DataProvider
  public Iterator<Object[]> validContactsFromJson() throws IOException {
    File photo = new File("src/test/resources/image.jpg");
    //List<Object[]> list = new ArrayList<Object[]>();
    try (BufferedReader reader = new BufferedReader (new FileReader(new File("src/test/resources/contacts.json")))) {
      String json = "";
      String line = reader.readLine();
      while (line != null){
        json += line;
        line = reader.readLine();
      }

      Gson gson = new Gson();
      List<ContactData> contacts = gson.fromJson(json, new TypeToken<List<ContactData>>(){}.getType());
      return contacts.stream().map((g) -> new Object[] {g}).collect(Collectors.toList()).iterator();
    }
  }

  @Test(dataProvider = "validContactsFromJson")
  public void testContactCreation(ContactData contact) {
    app.goTo().homePage();
    Contacts before = app.contact().all();
    app.contact().create(contact, true);
    app.goTo().homePage();
    assertThat(app.contact().count(), equalTo(before.size() + 1));
    Contacts after  = app.contact().all();
    assertThat(after, equalTo(before.withAdded(
            contact.withId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId()))));
  }


  @Test(enabled = false)
  public void testBadContactCreation() {
    app.goTo().homePage();
    Contacts before = app.contact().all();
    ContactData contact = new ContactData().withFirstname ("Dmytro'").withLastname("Rudenko").withAddress("Ukraine Kiev")
            .withTelhome("38044").withTelmobile("38063").withTelwork("38066").withTelfax("38097")
            .withEmailfirst("fel_1@gmail.com").withEmailsecond("fel_2@gmail.com").withEmailthird("fel_3@gmail.com")
            .withBday("6").withBmonth("September").withByear("1989").withGroup("test7");
    app.contact().create(contact, true);
    app.goTo().homePage();
    assertThat(app.contact().count(), equalTo(before.size()));
    Contacts after  = app.contact().all();
    assertThat(after, equalTo(before));
  }


//  @Test(enabled = false)
//  public void testCurrentDir(){
//    File currentDir = new File(".");
//    System.out.println(currentDir.getAbsolutePath());
//    File photo = new File("resourses/image.jpg");
//    System.out.println(photo.getAbsolutePath());
//    System.out.println(photo.exists());
//  }
}