package ru.avtotest.ab.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import ru.avtotest.ab.model.AccountFields;

public class AccountHelper {
  private WebDriver wd;

  public AccountHelper(WebDriver wd) {
    this.wd = wd;
  }

  public void submitAccount() {
    wd.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Notes:'])[1]/following::input[1]")).click();
  }

  public void setGroup() {
    wd.findElement(By.name("new_group")).click();
    new Select(wd.findElement(By.name("new_group"))).selectByVisibleText("Group 1");
    wd.findElement(By.name("new_group")).click();
  }

  public void setBDaydata(String birthDay, String dirthMonth, String birthYear) {
    wd.findElement(By.name("bday")).click();
    new Select(wd.findElement(By.name("bday"))).selectByVisibleText(birthDay);
    wd.findElement(By.name("bday")).click();
    wd.findElement(By.name("bmonth")).click();
    new Select(wd.findElement(By.name("bmonth"))).selectByVisibleText(dirthMonth);
    wd.findElement(By.name("bmonth")).click();
    wd.findElement(By.name("byear")).click();
    wd.findElement(By.name("byear")).clear();
    wd.findElement(By.name("byear")).sendKeys(birthYear);
  }

  public void fillAccountForm(AccountFields accountFields) {
    wd.findElement(By.name("firstname")).click();
    wd.findElement(By.name("firstname")).clear();
    wd.findElement(By.name("firstname")).sendKeys(accountFields.getFirstname());
    wd.findElement(By.name("middlename")).clear();
    wd.findElement(By.name("middlename")).sendKeys(accountFields.getMiddlename());
    wd.findElement(By.name("lastname")).clear();
    wd.findElement(By.name("lastname")).sendKeys(accountFields.getLastname());
    wd.findElement(By.name("nickname")).clear();
    wd.findElement(By.name("nickname")).sendKeys(accountFields.getNickname());
    wd.findElement(By.name("title")).click();
    wd.findElement(By.name("title")).clear();
    wd.findElement(By.name("title")).sendKeys(accountFields.getTitlearea());
    wd.findElement(By.name("company")).clear();
    wd.findElement(By.name("company")).sendKeys(accountFields.getCompany());
    wd.findElement(By.name("address")).click();
    wd.findElement(By.name("address")).clear();
    wd.findElement(By.name("address")).sendKeys(accountFields.getAddress());
    wd.findElement(By.name("home")).clear();
    wd.findElement(By.name("home")).sendKeys(accountFields.getHome());
    wd.findElement(By.name("mobile")).clear();
    wd.findElement(By.name("mobile")).sendKeys(accountFields.getMobilenumber());
    wd.findElement(By.name("work")).clear();
    wd.findElement(By.name("work")).sendKeys(accountFields.getAboutworkfield());
    wd.findElement(By.name("fax")).clear();
    wd.findElement(By.name("fax")).sendKeys(accountFields.getFax());
    wd.findElement(By.name("email")).clear();
    wd.findElement(By.name("email")).sendKeys(accountFields.getFirstEmail());
    wd.findElement(By.name("email2")).clear();
    wd.findElement(By.name("email2")).sendKeys(accountFields.getSecondEmail());
    wd.findElement(By.name("email3")).clear();
    wd.findElement(By.name("email3")).sendKeys(accountFields.getThirdEmail());
    wd.findElement(By.name("homepage")).clear();
    wd.findElement(By.name("homepage")).sendKeys(accountFields.getHomepage());
  }

  public void initAccountCreation() {
    wd.findElement(By.linkText("add new")).click();
  }
}
