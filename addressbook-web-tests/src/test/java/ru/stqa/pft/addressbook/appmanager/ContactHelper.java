package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }


  public void initContactCreation() {
    click(By.linkText("add new"));
  }

  public void fillContactForms(ContactData contactData, boolean creation) {
    type(By.name("firstname"), contactData.getFirstname());
    type(By.name("lastname"), contactData.getLastname());
    type(By.name("address"), contactData.getAddress());
    type(By.name("home"), contactData.getTelhome());
    type(By.name("mobile"), contactData.getTelmobile());
    type(By.name("work"), contactData.getTelwork());
    type(By.name("fax"), contactData.getTelfax());
    type(By.name("email"), contactData.getEmailfirst());
    type(By.name("email2"), contactData.getEmailsecond());
    type(By.name("email3"), contactData.getEmailthird());
    typedropdown("bday", contactData.getBday(), "//option[@value='6']");
    typedropdown("bmonth", contactData.getBmonth(), "//option[@value='September']");
    type(By.name("byear"), contactData.getByear());

    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }

  public void submitContactCreation() {
    click(By.xpath("(//input[@name='submit'])[2]"));
  }

  public void selectContact(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
  }

  public void initContacDeletion() {
    click(By.xpath("//input[@value='Delete']"));
    wd.switchTo().alert().accept();
  }

  public void initContacModification() {
    click(By.xpath("//img[@alt='Edit']"));
  }

  public void submitContacModification() {
    click(By.xpath("(//input[@name='update'])[2]"));
  }

  public void createContact(ContactData contact, boolean b) {
    initContactCreation();
    fillContactForms(contact, b);
    submitContactCreation();
  }

  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public int getContactCount() {
  return wd.findElements(By.name("selected[]")).size();
  }

  public List<ContactData> getContactList() {
    List<ContactData> contacts = new ArrayList<ContactData>();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for (WebElement element : elements) {
      String firstname = element.getText();
      ContactData contact = new ContactData(firstname, null, null, null, null, null, null, null, null, null, null, null, null, null);
      contacts.add(contact);
    }
    return contacts;
  }



}