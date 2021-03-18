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
    attach(By.name("photo"), contactData.getPhoto());

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
      String allMails = row.findElement(By.cssSelector("td:nth-child(5)")).getText();
      String allPhones = row.findElement(By.cssSelector("td:nth-child(6)")).getText();
      ContactData contact = new ContactData().withId(id).withFirstname(firstname).withLastname(lastname)
              .withAddress(address).withAllPhones(allPhones).withAllMails(allMails);
      contactCache.add(contact);

      //String[] phones = row.findElement(By.cssSelector("td:nth-child(6)")).getText().split("\n");
    }
    return new Contacts(contactCache);
  }

  public ContactData infoFromEditForm(ContactData contact) {
    initContacModificationById(contact.getId());
    String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
    String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
    String home = wd.findElement(By.name("home")).getAttribute("value");
    String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
    String work = wd.findElement(By.name("work")).getAttribute("value");
    String address = wd.findElement(By.name("address")).getAttribute("value");
    String email = wd.findElement(By.name("email")).getAttribute("value");
    String email2 = wd.findElement(By.name("email2")).getAttribute("value");
    String email3 = wd.findElement(By.name("email3")).getAttribute("value");
    wd.navigate().back();
    return new ContactData().withId(contact.getId()).withFirstname(firstname)
            .withLastname(lastname).withTelhome(home).withTelmobile(mobile).withTelwork(work).withAddress(address)
            .withEmailfirst(email).withEmailsecond(email2).withEmailthird(email3);
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

}
