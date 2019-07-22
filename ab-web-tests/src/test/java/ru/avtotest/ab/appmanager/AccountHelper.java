package ru.avtotest.ab.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.avtotest.ab.model.AccountFields;

import java.util.ArrayList;
import java.util.List;

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
    type(By.name("firstname"), accountFields.getFirstname());
    type(By.name("middlename"), accountFields.getMiddlename());
    type(By.name("lastname"), accountFields.getLastname());
    type(By.name("nickname"), accountFields.getNickname());
    type(By.name("title"), accountFields.getTitlearea());
    type(By.name("company"), accountFields.getCompany());
    type(By.name("address"), accountFields.getAddress());
    type(By.name("home"), accountFields.getHome());
    type(By.name("mobile"), accountFields.getMobilenumber());
    type(By.name("work"), accountFields.getAboutworkfield());
    type(By.name("fax"), accountFields.getFax());
    type(By.name("email"), accountFields.getFirstEmail());
    type(By.name("email2"), accountFields.getSecondEmail());
    type(By.name("email3"), accountFields.getThirdEmail());
    type(By.name("homepage"), accountFields.getHomepage());
    if (creation){
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText("Группировка");

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

  public void edit(int index) {
    wd.findElements(By.xpath("//img[@alt='Edit']")).get(index).click();
  }

  public void delete() {
    wd.findElement(By.xpath("(//input[@name='update'])[3]")).click();
  }

  public void tohomepage() {
    if (isElementPresent(By.id("maintable"))) {
      return;
    }
    click(By.linkText("home page"));
  }

  public void create(AccountFields account, boolean b) {
    initAccountCreation();
    fillAccountForm(account, true);
    setBDaydata("6", "October", "1989");
    submitAccount();
    tohomepage();
  }

  public void modify(int index, AccountFields account) {
    edit(index);
    fillAccountForm(account, false);
    setBDaydata("6", "October", "1989");
    updateAccount();
  }

  public List<AccountFields> list() {
    List<AccountFields> accounts = new ArrayList<AccountFields>();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for (WebElement element : elements) {
      int id = Integer.parseInt(element.findElement(By.xpath
              (".//td[1]/input[@type='checkbox']")).getAttribute("value"));
      String firstname = element.findElement(By.xpath(".//td[3]")).getText();
      String lastname = element.findElement(By.xpath(".//td[2]")).getText();
      AccountFields account = new AccountFields().whithId(id).whithFirstname(firstname).whithLastname(lastname);
      accounts.add(account);
    }
    return accounts;
  }
}
