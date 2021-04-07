package ru.stqa.pft.mantis.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.SkipException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ru.stqa.pft.mantis.appmanager.ApplicationManager;
import ru.stqa.pft.mantis.model.Issue;

import javax.xml.rpc.ServiceException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.RemoteException;

public class TestBase {

  protected static final ApplicationManager app
          = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));

  @BeforeSuite(alwaysRun = true)
  protected void setUp() throws Exception {
    app.init();
//    app.ftp().upload(new File("src/test/resources/config_inc.php"), "config_inc.php", "config_inc.bak");
  }

  @AfterSuite(alwaysRun = true)
  public void tearDown() throws IOException {
//    app.ftp().restore("config_inc.bak", "config_inc.php");
    app.stop();
  }

  public void skipIfNotFixed(int issueId) throws RemoteException, ServiceException, MalformedURLException {
    if (isIssueOpen(issueId)) {
      System.out.println("Ignored because of issue " + issueId);
      throw new SkipException("Ignored because of issue " + issueId);
    }
  }

  boolean isIssueOpen(int issueId) throws RemoteException, ServiceException, MalformedURLException {
    Issue issue = app.soap().getIssueById(issueId);
    if ((issue.getStatus().equals("resolved")) || (issue.getStatus().equals("closed")) ||
            (issue.getResolution().equals("fixed"))) {
      System.out.println("fixed");
      return false;
    } else {
      System.out.println("Not fixed");
      return true;
    }
  }
}