package ru.avtotest.ab.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.avtotest.ab.model.AccountFields;
import ru.avtotest.ab.model.Accounts;

import java.util.List;

public class AccountHelper extends HelperBase{

  public AccountHelper(WebDriver wd) {
    super(wd);
  }

  public void submitAccount() {
    click(By.name("submit"));
  }

  public int count() {
    return wd.findElements(By.name("selected[]")).size();
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
    addField(By.name("byear"), birthYear);
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
    type(By.name("mobile"), accountFields.getMobile());
    type(By.name("work"), accountFields.getWork());
    type(By.name("fax"), accountFields.getFax());
    type(By.name("email"), accountFields.getFirstEmail());
    type(By.name("email2"), accountFields.getSecondEmail());
    type(By.name("email3"), accountFields.getThirdEmail());
    type(By.name("homepage"), accountFields.getHomepage());
    attach(By.name("photo"), accountFields.getPhoto());
    if (creation){
      if (accountFields.getGroups().size() > 0) {
        Assert.assertTrue(accountFields.getGroups().size() == 1);
        new Select(wd.findElement(By.name("new_group")))
                .selectByVisibleText(accountFields.getGroups().iterator().next().getName());
      }
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }

  private void addField(By locator, String text) {
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

  public void editAccountById(int id) {
    wd.findElement(By.xpath("//a[@href='edit.php?id=" + id + "']")).click();
  }

  public void selectAccountById(int id) {
    wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
  }

  public void delete(AccountFields account) {
    selectAccountById(account.getId());
    deleteSelectedAccount();
    accountCache = null;
    toHomePage();
  }

  public void toHomePage() {
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
    accountCache = null;
    toHomePage();
  }

  public void modify(AccountFields account) {
    editAccountById(account.getId());
    fillAccountForm(account, false);
    setBDaydata("6", "October", "1989");
    updateAccount();
    accountCache = null;
    toHomePage();
  }

  public void addToGroup(AccountFields findAccount) {
    selectAccountById(findAccount.getId());
    wd.findElement(By.name("add")).click();
  }

  public void filterByGroup(AccountFields account) {
    new Select(wd.findElement(By.cssSelector("select[name='group']")))
            .selectByVisibleText(account.getGroups().iterator().next().getName());
  }

  public void removedFromGroup(AccountFields account) {
    filterByGroup(account);
    selectAccountById(account.getId());
    wd.findElement(By.name("remove")).click();
    toHomePage();
    selectAllGroups();
  }

  private void selectAllGroups() {
    wd.findElement(By.name("group")).click();
    new Select(wd.findElement(By.name("group"))).selectByVisibleText("[all]");
    wd.findElement(By.name("group")).click();
  }

  private Accounts accountCache = null;

  public Accounts all() {
    if (accountCache != null) {
      return new Accounts(accountCache);
    }
    accountCache = new Accounts();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for (WebElement element : elements) {
      int id = Integer.parseInt(element.findElement(By.xpath
              (".//td[1]/input[@type='checkbox']")).getAttribute("value"));
      String lastname = element.findElement(By.xpath(".//td[2]")).getText();
      String firstname = element.findElement(By.xpath(".//td[3]")).getText();
//      String allPhones = element.findElement(By.xpath(".//td[6]")).getText();
//      String allEmails = element.findElement(By.xpath(".//td[5]")).getText();
      String address = element.findElement(By.xpath(".//td[4]")).getText();
      AccountFields account = new AccountFields().whithId(id).whithFirstname(firstname)
              .whithLastname(lastname).whithAddress(address);
      accountCache.add(account);
    }
    return new Accounts(accountCache);
  }

  public AccountFields infoFromEditForm(AccountFields account) {
    initAccountModificationById(account.getId());
    String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
    String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
    String home = wd.findElement(By.name("home")).getAttribute("value");
    String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
    String work = wd.findElement(By.name("work")).getAttribute("value");
    String email = wd.findElement(By.name("email")).getAttribute("value");
    String email2 = wd.findElement(By.name("email2")).getAttribute("value");
    String email3 = wd.findElement(By.name("email3")).getAttribute("value");
    String address = wd.findElement(By.name("address")).getAttribute("value");
    wd.navigate().back();
    return new AccountFields().whithId(account.getId()).whithFirstname(firstname)
            .whithLastname(lastname).whithHome(home).whithMobile(mobile)
            .whithWork(work).whithFirstEmail(email).whithSecondEmail(email2)
            .whithThirdEmail(email3).whithAddress(address);
  }

  private void initAccountModificationById(int id) {
/*    WebElement checkbox = wd.findElement(By.cssSelector(String.format("input[value='%s'", id)));
    WebElement row = checkbox.findElement(By.xpath("./../.."));
    List<WebElement> cells = row.findElements(By.tagName("id"));
    cells.get(7).findElement(By.tagName("a")).click();
  В этом методе каждый способ нацелен на одну цель - переход на форму модификации аккаунта
    по кнопке Edit, при помощи уникального идентификатора. Один способ оставлю на виду,
    остальные 3 закомментирую вместе с этим текстом
    1) */
    wd.findElement(By.xpath((String.format("//input[@value='%s']/../../td[8]/a", id)))).click();
/*    2)wd.findElement(By.xpath((String.format("//tr[.//input[@value='%s']/td[8]/a", id)))).click();
    3)wd.findElement(By.cssSelector(String.format("a[href='edit.php?id=%s']", id))).click();
    (Шпаргалка):
    В языке запросов Xpath нумерация начинается с еденицы! (1)
*/
  }


  public void showAllGroups() {
    wd.findElement(By.name("group")).click();
    new Select(wd.findElement(By.name("group"))).selectByVisibleText("[all]");
    wd.findElement(By.name("group")).click();

  }
}
