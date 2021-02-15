package ru.stqa.pft.addressbook.tests.contact;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.tests.TestBase;

public class ContactDeletionTests extends TestBase {

  @Test
public void testContactDeletion(){
    app.getNavigationHelper().gotoHomePage();
    app.getContactHelper().selectContact();
    app.getContactHelper().initContacDeletion();
    app.getNavigationHelper().gotoHomePage();
  }

}
