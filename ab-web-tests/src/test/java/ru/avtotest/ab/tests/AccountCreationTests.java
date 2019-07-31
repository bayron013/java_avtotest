package ru.avtotest.ab.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.avtotest.ab.model.AccountFields;
import ru.avtotest.ab.model.Accounts;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AccountCreationTests extends TestBase {

  @DataProvider
  public Iterator<Object[]> validAccounts() throws IOException {
    List<Object[]> list = new ArrayList<Object[]>();
    BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/accounts.csv")));
    String line = reader.readLine();
    while (line != null) {
      String[] split = line.split(";");
      list.add(new Object[] {new AccountFields().whithFirstname(split[0]).whithMiddlename(split[1])
              .whithLastname(split[2]).whithNickname(split[3]).whithTitlearea(split[4])
              .whithCompany(split[5]).whithAddress(split[6]).whithHome(split[7])
              .whithMobile(split[8]).whithWork(split[9]).whithFax(split[10]).whithFirstEmail(split[11])
              .whithSecondEmail(split[12]).whithThirdEmail(split[13]).whithHomepage(split[14])});
      line = reader.readLine();
    }
    return list.iterator();
  }

  @Test(dataProvider = "validAccounts")
  public void testAccountCreation(AccountFields account) {
    Accounts before = app.account().all();
    File photo = new File("src/test/resources/грек.jpg");
    app.account().create(account, true);
    assertThat(app.account().count(), equalTo(before.size() + 1));
    Accounts after = app.account().all();
    assertThat(after, equalTo(before.withAc(account.whithId(
            after.stream().mapToInt((a) -> a.getId()).max().getAsInt()))));
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