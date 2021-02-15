package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactHelper extends HelperBase{

  public ContactHelper(WebDriver wd) {
    super(wd);
  }


  public void initContactCreation() {
    click(By.linkText("add new"));
  }

  public void fillContactForms(ContactData contactData) {
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
  }

  public void submitContactCreation() {
    click(By.xpath("(//input[@name='submit'])[2]"));
  }

  public void selectContact() {
    click(By.name("selected[]"));
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
}
