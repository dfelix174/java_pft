package ru.stqa.pft.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
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
    save(contacts, new File(file));
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
              .withByear(String.format("198%s", i))
              .withGroup(("test7")));
    }
    return contacts;
  }

  private void save(List<ContactData> contacts, File file) throws IOException {
    Writer writer = new FileWriter(file);
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
              , contact.getByear()
              , contact.getGroup()));
    }
    writer.close();
  }
}