package ru.stqa.pft.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;
import java.util.Objects;

@XStreamAlias("contact")
@Entity
@Table(name = "addressbook")
public class ContactData {

  @XStreamOmitField
  @Id
  @Column(name = "id")
  private int id = Integer.MAX_VALUE;

  @Expose
  @Column(name = "firstname")
  private String firstname;

  @Expose
  @Column(name = "lastname")
  private String lastname;

  @Expose
  @Column(name = "address")
  @Type(type = "text")
  private String address;

  @Expose
  @Column(name = "home")
  @Type(type = "text")
  private String telhome;

  @Expose
  @Column(name = "mobile")
  @Type(type = "text")
  private String telmobile;

  @Expose
  @Column(name = "work")
  @Type(type = "text")
  private String telwork;

  @Expose
  @Column(name = "fax")
  @Type(type = "text")
  private String telfax;

  @Expose
  @Column(name = "email")
  @Type(type = "text")
  private String emailfirst;

  @Expose
  @Column(name = "email2")
  @Type(type = "text")
  private String emailsecond;

  @Expose
  @Column(name = "email3")
  @Type(type = "text")
  private String emailthird;

  @Expose
  @Column(name = "bday",columnDefinition = "TINYINT")
  private String bday;

  @Expose
  @Column(name = "bmonth")
  private String bmonth;

  @Expose
  @Column(name = "byear")
  private String byear;

  @Expose
  @Transient
  private String group;

  @Expose
  @Transient
  private String allPhones;

  @Expose
  @Transient
  private String allMails;

  @Expose
  @Column(name = "photo")
  @Type(type = "text")
  private String photo;


  public File getPhoto() {return new File(photo);  }

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
    this.photo = photo.getPath();
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
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return id == that.id &&
            Objects.equals(firstname, that.firstname) &&
            Objects.equals(lastname, that.lastname) &&
            Objects.equals(address, that.address) &&
            Objects.equals(telhome, that.telhome) &&
            Objects.equals(telmobile, that.telmobile) &&
            Objects.equals(telwork, that.telwork) &&
            Objects.equals(telfax, that.telfax) &&
            Objects.equals(emailfirst, that.emailfirst) &&
            Objects.equals(emailsecond, that.emailsecond) &&
            Objects.equals(emailthird, that.emailthird) &&
            Objects.equals(byear, that.byear);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, firstname, lastname, address, telhome, telmobile, telwork,
            telfax, emailfirst, emailsecond, emailthird, byear);
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "id=" + id +
            ", firstname='" + firstname + '\'' +
            ", lastname='" + lastname + '\'' +
            ", address='" + address + '\'' +
            ", telhome='" + telhome + '\'' +
            ", telmobile='" + telmobile + '\'' +
            ", telwork='" + telwork + '\'' +
            ", telfax='" + telfax + '\'' +
            ", emailfirst='" + emailfirst + '\'' +
            ", emailsecond='" + emailsecond + '\'' +
            ", emailthird='" + emailthird + '\'' +
            ", bmonth='" + bmonth + '\'' +
            ", byear='" + byear + '\'' +
            ", group='" + group + '\'' +
            '}';
  }

}
