package ru.avtotest.ab.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.avtotest.ab.model.AccountFields;

public class AccountHelper extends HelperBase{

  public AccountHelper(WebDriver wd) {
    super(wd);
  }

  public void submitAccount() {
    click(By.name("submit"));
  }

  public void updateAccount() {
    click(By.name("update"));
  }


  public void setBDaydata(String birthDay, String dirthMonth, String birthYear) {
    wd.findElement(By.name("bday")).click();
    new Select(wd.findElement(By.name("bday"))).selectByVisibleText(birthDay);
    wd.findElement(By.name("bday")).click();
    wd.findElement(By.name("bmonth")).click();
    new Select(wd.findElement(By.name("bmonth"))).selectByVisibleText(dirthMonth);
    wd.findElement(By.name("bmonth")).click();
    addfield(By.name("byear"), birthYear);
  }

  public void fillAccountForm(AccountFields accountFields, boolean creation) {
    addfield(By.name("firstname"), accountFields.getFirstname());
    addfield(By.name("middlename"), accountFields.getMiddlename());
    addfield(By.name("lastname"), accountFields.getLastname());
    addfield(By.name("nickname"), accountFields.getNickname());
    addfield(By.name("title"), accountFields.getTitlearea());
    addfield(By.name("company"), accountFields.getCompany());
    addfield(By.name("address"), accountFields.getAddress());
    addfield(By.name("home"), accountFields.getHome());
    addfield(By.name("mobile"), accountFields.getMobilenumber());
    addfield(By.name("work"), accountFields.getAboutworkfield());
    addfield(By.name("fax"), accountFields.getFax());
    addfield(By.name("email"), accountFields.getFirstEmail());
    addfield(By.name("email2"), accountFields.getSecondEmail());
    addfield(By.name("email3"), accountFields.getThirdEmail());
    addfield(By.name("homepage"), accountFields.getHomepage());
    if (creation){
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText("Group 1");

    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }

  private void addfield(By locator, String text) {
    wd.findElement(locator).click();
    wd.findElement(locator).clear();
    wd.findElement(locator).sendKeys(text);
  }

  public void initAccountCreation() {
    click(By.linkText("add new"));
  }

  public void editAccount() {
    click(By.xpath("//img[@alt='Edit']"));
  }

  public void deletAccount() {
    click(By.name("update"));
  }

  public void tohomepage() {
    if (isElementPresent(By.id("maintable"))) {
      return;
    }
    click(By.linkText("home page"));
  }

  public void createAccount(AccountFields account, boolean b) {
    initAccountCreation();
    fillAccountForm(account, true);
    setBDaydata("6", "October", "1989");
    submitAccount();
    tohomepage();
  }

  public boolean isThareAAccount() {
    return isElementPresent(By.xpath("//img[@alt='Edit']"));
  }
}
