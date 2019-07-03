package ru.avtotest.ab.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import ru.avtotest.ab.model.AccountFields;

public class AccountHelper extends HelperBase{

  public AccountHelper(WebDriver wd) {
    super(wd);
  }

  public void submitAccount() {
    click(By.name("submit"));
  }

  public void setGroup() {
    wd.findElement(By.name("new_group")).click();
    new Select(wd.findElement(By.name("new_group"))).selectByVisibleText("Group 1");
    wd.findElement(By.name("new_group")).click();
  }  // оставил эту и аналогичные части кода не тронутыми, так как в курсе ещё не объяснялось как параметризовать участки кода с drooplist.

  public void setBDaydata(String birthDay, String dirthMonth, String birthYear) {
    wd.findElement(By.name("bday")).click();
    new Select(wd.findElement(By.name("bday"))).selectByVisibleText(birthDay);
    wd.findElement(By.name("bday")).click();
    wd.findElement(By.name("bmonth")).click();
    new Select(wd.findElement(By.name("bmonth"))).selectByVisibleText(dirthMonth);
    wd.findElement(By.name("bmonth")).click();
    addfield(By.name("byear"), birthYear);
  }

  public void fillAccountForm(AccountFields accountFields) {
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
  }

  private void addfield(By locator, String text) {
    wd.findElement(locator).click();
    wd.findElement(locator).clear();
    wd.findElement(locator).sendKeys(text);
  }

  public void initAccountCreation() {
    click(By.linkText("add new"));
  }
}
