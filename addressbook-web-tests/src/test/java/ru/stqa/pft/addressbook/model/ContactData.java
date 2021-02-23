package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class ContactData {
  private final String firstname;
  private final String lastname;
  private final String address;
  private final String telhome;
  private final String telmobile;
  private final String telwork;
  private final String telfax;
  private final String emailfirst;
  private final String emailsecond;
  private final String emailthird;
  private final String bday;
  private final String bmonth;
  private final String byear;
  private final String group;

  public ContactData(String firstname, String lastname, String address, String telhome, String telmobile, String telwork, String telfax, String emailfirst, String emailsecond, String emailthird, String bday, String bmonth, String byear, String group) {
    this.firstname = firstname;
    this.lastname = lastname;
    this.address = address;
    this.telhome = telhome;
    this.telmobile = telmobile;
    this.telwork = telwork;
    this.telfax = telfax;
    this.emailfirst = emailfirst;
    this.emailsecond = emailsecond;
    this.emailthird = emailthird;
    this.bday = bday;
    this.bmonth = bmonth;
    this.byear = byear;
    this.group = group;
  }


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

  @Override
  public String toString() {
    return "ContactData{" +
            "firstname='" + firstname + '\'' +
            ", lastname='" + lastname + '\'' +
            ", address='" + address + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return Objects.equals(firstname, that.firstname) &&
            Objects.equals(lastname, that.lastname) &&
            Objects.equals(address, that.address);
  }

  @Override
  public int hashCode() {
    return Objects.hash(firstname, lastname, address);
  }
}
