package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

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

  public void selectContactById(int id) {
    wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
  }

  public void initContacDeletion() {
    click(By.xpath("//input[@value='Delete']"));
    wd.switchTo().alert().accept();
  }


  public void initContacModificationById(int id) {
    wd.findElement(By.cssSelector(String.format("a[href='edit.php?id=%s']", id))).click();
  }


  public void submitContacModification() {
    click(By.xpath("(//input[@name='update'])[2]"));
  }

  public void create(ContactData contact, boolean b) {
    initContactCreation();
    fillContactForms(contact, b);
    submitContactCreation();
    contactCache = null;
  }

  public void modify(ContactData contact) {
    initContacModificationById(contact.getId());
    fillContactForms(contact, false);
    submitContacModification();
    contactCache = null;
  }

  public void delete(ContactData contact) {
    selectContactById(contact.getId());
    initContacDeletion();
    contactCache = null;
  }

  public int count() {
    return wd.findElements(By.name("selected[]")).size();
  }


  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }


//  public List<ContactData> getContactList() {
//    List<ContactData> contacts = new ArrayList<ContactData>();
//    List<WebElement> rows = wd.findElements(By.cssSelector("tr[name='entry']"));
//
//    for (WebElement row : rows) {
//      List<WebElement> cells =  row.findElements(By.tagName("td"));
//      String id = cells.get(0).getAttribute("value");
//      String lastname = cells.get(1).getText();
//      String firstname = cells.get(2).getText();
//      String address = cells.get(3).getText();
//      ContactData contact = new ContactData(id, firstname, lastname, address, null, null, null, null, null, null, null, null, null, null, null);
//      contacts.add(contact);
//    }
//    return contacts;
//  }

  private Contacts contactCache = null;

  public Contacts all() {
    if (contactCache != null){
      return new Contacts(contactCache);
    }

    contactCache = new Contacts();
    List<WebElement> rows = wd.findElements(By.cssSelector("tr[name='entry']"));
    for (WebElement row : rows) {
      int id = Integer.parseInt(row.findElement(By.cssSelector("td:nth-child(1) input")).getAttribute("value"));
      String lastname = row.findElement(By.cssSelector("td:nth-child(2)")).getText();
      String firstname = row.findElement(By.cssSelector("td:nth-child(3)")).getText();
      String address = row.findElement(By.cssSelector("td:nth-child(4)")).getText();
      ContactData contact = new ContactData ().withId(id).withFirstname(firstname).withLastname(lastname).withAddress(address);
      contactCache.add(contact);
    }
    return new Contacts(contactCache);
  }

}
