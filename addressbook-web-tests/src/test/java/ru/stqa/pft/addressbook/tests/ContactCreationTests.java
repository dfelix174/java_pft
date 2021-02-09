package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase{

  @Test
  public void testContactCreation(){
    app.getNavigationHelper().gotoHomePage();
    app.getContactHelper().initContactCreation();
    app.getContactHelper().fillContactForms(new ContactData("Dmytro", "Rudenko", "Ukraine Kiev", "38044", "38063", "38066", "38097", "fel_1@gmail.com", "fel_2@gmail.com", "fel_3@gmail.com", "6", "September", "1989"));
    app.getContactHelper().submitContactCreation();
    app.getNavigationHelper().gotoHomePage();
  }
}
