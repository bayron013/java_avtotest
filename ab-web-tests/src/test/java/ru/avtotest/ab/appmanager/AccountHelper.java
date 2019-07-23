package ru.avtotest.ab.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.avtotest.ab.model.AccountFields;
import ru.avtotest.ab.model.Accounts;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.testng.Assert.assertTrue;

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

  public void deleteSelectedAccount() {
    click(By.xpath("//input[@value='Delete']"));
    wd.switchTo().alert().accept();
    wd.findElement(By.cssSelector("div.msgbox"));
  }
// проблема с выбором групп для модификации
  public void editAccountById(int id) {
    wd.findElement(By.xpath("//a[@href='edit.php?id=" + id + "']")).click();
  }

  public void selectAccountById(int id) {
    wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
  }

  public void delete(AccountFields account) {
    selectAccountById(account.getId());
    deleteSelectedAccount();
    tohomepage();
  }

  public void tohomepage() {
    if (isElementPresent(By.id("maintable"))) {
      return;
    }
    click(By.linkText("home"));
  }

  public void create(AccountFields account, boolean b) {
    initAccountCreation();
    fillAccountForm(account, true);
    setBDaydata("6", "October", "1989");
    submitAccount();
    tohomepage();
  }

  public void modify(AccountFields account) {
    editAccountById(account.getId());
    fillAccountForm(account, false);
    setBDaydata("6", "October", "1989");
    updateAccount();
    tohomepage();
  }

  public Accounts all() {
    Accounts accounts = new Accounts();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for (WebElement element : elements) {
      int id = Integer.parseInt(element.findElement(By.xpath
              (".//td[1]/input[@type='checkbox']")).getAttribute("value"));
      String lastname = element.findElement(By.xpath(".//td[2]")).getText();
      String firstname = element.findElement(By.xpath(".//td[3]")).getText();
      AccountFields account = new AccountFields().whithId(id).whithFirstname(firstname).whithLastname(lastname);
      accounts.add(account);
    }
    return accounts;
  }
}
