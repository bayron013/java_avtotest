package ru.avtotest.ab.tests;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.thoughtworks.xstream.XStream;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.avtotest.ab.model.AccountFields;
import ru.avtotest.ab.model.Accounts;
import ru.avtotest.ab.model.GroupData;
import ru.avtotest.ab.model.Groups;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AccountCreationTests extends TestBase {

  @DataProvider
  public Iterator<Object[]> validAccountsFromXml() throws IOException {
    try (BufferedReader reader = new BufferedReader(new FileReader
            (new File("src/test/resources/accounts.xml")))) {
      String xml = "";
      String line = reader.readLine();
      while (line != null) {
        xml += line;
        line = reader.readLine();
      }
      XStream xstream = new XStream();
      xstream.processAnnotations(AccountFields.class);
      List<AccountFields> accounts = (List<AccountFields>) xstream.fromXML(xml);
      return accounts.stream().map((g) -> new Object[] {g}).collect(Collectors.toList()).iterator();
    }
  }

  @DataProvider
  public Iterator<Object[]> validAccountsFromJson() throws IOException {
    try (BufferedReader reader = new BufferedReader(new FileReader
            (new File("src/test/resources/accounts.json")))) {
      String json = "";
      String line = reader.readLine();
      while (line != null) {
        json += line;
        line = reader.readLine();
      }
      Gson gson = new Gson();
      List<AccountFields> accounts = gson.fromJson(json, new TypeToken<List<AccountFields>>(){}.getType());   //List<AccountFields>.class
      return accounts.stream().map((g) -> new Object[] {g}).collect(Collectors.toList()).iterator();
    }
  }

  @Test(dataProvider = "validAccountsFromJson")
  public void testAccountCreation(AccountFields account) {
    if (app.db().groups().size() == 0) {
      app.goTo().groupPage();
      app.group().create(new GroupData().withName("Запасная группа"));
      app.goTo().homePage();
    }
    Groups groups = app.db().groups();
    Accounts before = app.db().accounts();
    File photo = new File("src/test/resources/грек.jpg");
    app.account().create(account.inGroup(groups.iterator().next()), true);
    assertThat(app.account().count(), equalTo(before.size() + 1));
    Accounts after = app.db().accounts();
    assertThat(after, equalTo(before.withAddedAc(account
            .whithId(after.stream().mapToInt((a) -> a.getId()).max().getAsInt()))));
    verifyAccountListInUi();
  }

  @Test(enabled = false)
  public void testCurrentDir() {
    File currentDir = new File(".");
    System.out.println((currentDir.getAbsolutePath()));
    File photo = new File("src/test/resources/грек.jpg");
    System.out.println(photo.getAbsolutePath());
    System.out.println(photo.exists());
  }
}