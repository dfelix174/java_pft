package ru.stqa.pft.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thoughtworks.xstream.XStream;
import ru.stqa.pft.addressbook.model.ContactData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ContactDataGenerator {

  @Parameter (names = "-c", description = "Contact count")
  public int count;

  @Parameter (names = "-f", description = "Target file")
  public String file;

  @Parameter(names = "-d", description = "Data Format")
  public String format;

  public static void main(String[] args) throws IOException {
    ContactDataGenerator generator = new ContactDataGenerator();
    JCommander jCommander = new JCommander(generator);
    try{
      jCommander.parse(args);
    } catch (ParameterException ex){
      jCommander.usage();
      return;
    }
    generator.run();
  }

  private void run() throws IOException {
    List<ContactData> contacts  = generateContacts(count);
    if (format.equals("csv")){
      saveAsCsv(contacts, new File(file));
    } else if (format.equals("xml")){
      saveAsXml(contacts, new File(file));
    } else if (format.equals("json")){
      saveAsJson(contacts, new File(file));
    } else {
      System.out.println("Unrecognized format " + format);
    }
  }

  private void saveAsJson(List<ContactData> contacts, File file) throws IOException {
    Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
    String json = gson.toJson(contacts);
    try (Writer writer = new FileWriter(file)){
      writer.write(json);
    }
  }

  private void saveAsXml(List<ContactData> contacts, File file) throws IOException {
    XStream xstream = new XStream();
    xstream.processAnnotations(ContactData.class);
    String xml = xstream.toXML(contacts);
    try (Writer writer = new FileWriter(file)) {
      writer.write(xml);
    }
  }

  private void saveAsCsv(List<ContactData> contacts, File file) throws IOException {
    try (Writer writer = new FileWriter(file)){
      for (ContactData contact : contacts){
        writer.write(String.format("%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s\n"
                , contact.getFirstname()
                , contact.getLastname()
                , contact.getAddress()
                , contact.getTelhome()
                , contact.getTelmobile()
                , contact.getTelwork()
                , contact.getTelfax()
                , contact.getEmailfirst()
                , contact.getEmailsecond()
                , contact.getEmailthird()
                , contact.getBday()
                , contact.getBmonth()
                , contact.getByear()));
      }
    }
  }


  private List<ContactData> generateContacts(int count) {
    List<ContactData> contacts = new ArrayList<ContactData>();
    for (int i = 0; i < count; i++){
      contacts.add(new ContactData().withFirstname(String.format("Dmytro %s", i))
              .withLastname(String.format("Rudenko %s", i))
              .withAddress(String.format("Ukraine Kiev %s", i))
              .withTelhome(String.format("38044%s", i))
              .withTelmobile(String.format("38063%s", i))
              .withTelwork(String.format("38066%s", i))
              .withTelfax(String.format("38097%s", i))
              .withEmailfirst(String.format("fel_%s@gmail.com", i))
              .withEmailsecond(String.format("zoom_%s@gmail.com", i))
              .withEmailthird(String.format("admin_%s@gmail.com", i))
              .withBday(String.format("%s", (1+i)))
              .withBmonth(("September"))
              .withByear(String.format("198%s", i)));
    }
    return contacts;
  }
}