package ru.stqa.pft.addressbook.tests;

import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase{

  @Test
  public void testContactCreation() throws Exception {
    app.initContactCreation();
    app.fillContactForms(new ContactData("Dmytro", "Rudenko", "Ukraine Kiev", "38044", "38063", "38066", "38097", "fel_1@gmail.com", "fel_2@gmail.com", "fel_3@gmail.com", "6", "September", "1989"));
    app.submitContactCreation();
    app.gotoHomePage();
  }
}
