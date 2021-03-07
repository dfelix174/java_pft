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
    if(app.contact().getContactList().size() == 0){
      app.contact().create(new ContactData
              ("Dmytro", null, "Ukraine Kiev", "38044", "38063",
                      "38066", "38097", "fel_1@gmail.com", "fel_2@gmail.com",
                      "fel_3@gmail.com", "6", "September", "1989", "test1"), true);
    }
    app.goTo().homePage();
  }

  @Test
  public void testContactModification() {
    List<ContactData> before = app.contact().getContactList();
    int index = before.size() - 1;
    ContactData contact = new ContactData (before.get(index).getId(),"Dmytro3", "Rudenko2", "Ukraine Kiev", "38044",
                    "38063", "38066", "38097", "fel_1@gmail.com",
                    "fel_2@gmail.com", "fel_3@gmail.com", "6", "September",
                    "1989", null);
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
