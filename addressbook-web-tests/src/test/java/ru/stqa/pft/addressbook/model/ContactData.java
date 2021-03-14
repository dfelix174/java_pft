package ru.stqa.pft.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import java.io.File;
import java.util.Objects;

@XStreamAlias("contact")
public class ContactData {
  @XStreamOmitField
  private int id = Integer.MAX_VALUE;
  @Expose
  private String firstname;
  @Expose
  private String lastname;
  @Expose
  private String address;
  @Expose
  private String telhome;
  @Expose
  private String telmobile;
  @Expose
  private String telwork;
  @Expose
  private String telfax;
  @Expose
  private String emailfirst;
  @Expose
  private String emailsecond;
  @Expose
  private String emailthird;
  @Expose
  private String bday;
  @Expose
  private String bmonth;
  @Expose
  private String byear;
  @Expose
  private String group;
  @Expose
  private String allPhones;
  @Expose
  private String allMails;
  @Expose
  private File photo;


  public File getPhoto() {return photo;  }

  public int getId() { return id; }

  public String getAllMails() {return allMails;  }

  public String getAllPhones() {return allPhones;  }

  public String getFirstname() {
    return firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public String getAddress() {
    return address;
  }

  public String getTelhome() {
    return telhome;
  }

  public String getTelmobile() {
    return telmobile;
  }

  public String getTelwork() {
    return telwork;
  }

  public String getTelfax() {
    return telfax;
  }

  public String getEmailfirst() {
    return emailfirst;
  }

  public String getEmailsecond() {
    return emailsecond;
  }

  public String getEmailthird() {
    return emailthird;
  }

  public String getBday() {
    return bday;
  }

  public String getBmonth() {
    return bmonth;
  }

  public String getByear() {
    return byear;
  }

  public String getGroup() {
    return group;
  }

  public ContactData withId(int id) {
    this.id = id;
    return this;
  }


  public ContactData withPhoto(File photo) {
    this.photo = photo;
    return this;
  }

  public ContactData withAllMails(String allMails) {
    this.allMails = allMails;
    return this;
  }

  public ContactData withAllPhones(String allPhones) {
    this.allPhones = allPhones;
    return this;
  }

  public ContactData withFirstname(String firstname) {
    this.firstname = firstname;
    return this;
  }

  public ContactData withLastname(String lastname) {
    this.lastname = lastname;
    return this;
  }

  public ContactData withAddress(String address) {
    this.address = address;
    return this;
  }

  public ContactData withTelhome(String telhome) {
    this.telhome = telhome;
    return this;
  }

  public ContactData withTelmobile(String telmobile) {
    this.telmobile = telmobile;
    return this;
  }

  public ContactData withTelwork(String telwork) {
    this.telwork = telwork;
    return this;
  }

  public ContactData withTelfax(String telfax) {
    this.telfax = telfax;
    return this;
  }

  public ContactData withEmailfirst(String emailfirst) {
    this.emailfirst = emailfirst;
    return this;
  }

  public ContactData withEmailsecond(String emailsecond) {
    this.emailsecond = emailsecond;
    return this;
  }

  public ContactData withEmailthird(String emailthird) {
    this.emailthird = emailthird;
    return this;
  }

  public ContactData withBday(String bday) {
    this.bday = bday;
    return this;
  }

  public ContactData withBmonth(String bmonth) {
    this.bmonth = bmonth;
    return this;
  }

  public ContactData withByear(String byear) {
    this.byear = byear;
    return this;
  }

  public ContactData withGroup(String group) {
    this.group = group;
    return this;
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "id=" + id +
            ", firstname='" + firstname + '\'' +
            ", lastname='" + lastname + '\'' +
            ", address='" + address + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return id == that.id &&
            Objects.equals(firstname, that.firstname) &&
            Objects.equals(lastname, that.lastname) &&
            Objects.equals(address, that.address);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, firstname, lastname, address);
  }

}
