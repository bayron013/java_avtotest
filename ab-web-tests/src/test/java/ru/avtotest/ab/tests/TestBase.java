package ru.avtotest.ab.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.avtotest.ab.appmanager.ApplcationManager;

public class TestBase {

  protected final ApplcationManager app = new ApplcationManager(BrowserType.IE);

  @BeforeMethod(alwaysRun = true)
  public void setUp() throws Exception {
    app.init();
  }

  @AfterMethod(alwaysRun = true)
  public void tearDown() throws Exception {
    app.stop();
  }

}
