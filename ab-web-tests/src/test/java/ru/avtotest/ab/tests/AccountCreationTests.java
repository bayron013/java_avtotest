package ru.avtotest.ab.tests;

import org.testng.annotations.Test;
import ru.avtotest.ab.model.AccountFields;
import ru.avtotest.ab.model.Accounts;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AccountCreationTests extends TestBase {

  @Test
  public void testAccountCreation() throws Exception {
    Accounts before = app.account().all();
    File photo = new File("src/test/resources/грек.jpg");
    AccountFields account = new AccountFields()
            .whithFirstname("Владик").whithLastname("Аладик").whithMiddlename("Аладушек")
            .whithNickname("Goblin").whithTitlearea("title").whithCompany("Volkswagen")
            .whithAddress("Russia").whithHome("Sweet Home").whithMobile("81117775511")
            .whithWork("Work Hard").whithFax("none").whithFirstEmail("- mail(  )@E-mail/")
            .whithSecondEmail("@gmail.com").whithThirdEmail("@rabler.loh").whithHomepage("vk.ru")
            .withPhoto(photo);
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