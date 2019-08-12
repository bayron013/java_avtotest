package ru.avtotest.ab.tests;

import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import ru.avtotest.ab.appmanager.ApplcationManager;
import ru.avtotest.ab.model.AccountFields;
import ru.avtotest.ab.model.Accounts;
import ru.avtotest.ab.model.GroupData;
import ru.avtotest.ab.model.Groups;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class TestBase {

  Logger logger = LoggerFactory.getLogger(TestBase.class);

  protected static final ApplcationManager app
          = new ApplcationManager(System.getProperty("browser", BrowserType.FIREFOX));

  @BeforeSuite(alwaysRun = true)
  public void setUp() throws Exception {
    app.init();
  }

  @AfterSuite(alwaysRun = true)
  public void tearDown() throws Exception {
    app.stop();
  }

  @BeforeMethod
  public void logTestStart(Method m, Object[] p) {
    logger.info("Start test " + m.getName() + " with parameters " + Arrays.asList(p));
  }

  @AfterMethod(alwaysRun = true)
  public void logTestStop(Method m) {
    logger.info("Stop test " + m.getName());
  }

  public void verifyGroupListInUi() {
    if (Boolean.getBoolean("verifyUi")) {
      Groups dbGroups = app.db().groups();
      Groups uiGroups = app.group().all();
      assertThat(uiGroups, equalTo(dbGroups.stream().map((g) -> new GroupData()
              .withId(g.getId()).withName(g.getName())).collect(Collectors.toSet())));
    }
  }

  public void verifyAccountListInUi() {
    if (Boolean.getBoolean("verifyUi")) {
      Accounts dbAccounts = app.db().accounts();
      Accounts uiAccounts = app.account().all();
      assertThat(uiAccounts, equalTo(dbAccounts.stream().map((a) -> new AccountFields()
              .whithId(a.getId()).whithFirstname(a.getFirstname()).whithLastname(a.getLastname())
              .whithAddress(a.getAddress())).collect(Collectors.toSet())));
    }
  }
}
