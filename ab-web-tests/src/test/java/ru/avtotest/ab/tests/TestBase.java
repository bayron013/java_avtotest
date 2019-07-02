package ru.avtotest.ab.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.avtotest.ab.appmanager.ApplcationMeneger;

public class TestBase {

  protected final ApplcationMeneger app = new ApplcationMeneger();

  @BeforeMethod(alwaysRun = true)
  public void setUp() throws Exception {
    app.init();
  }

  @AfterMethod(alwaysRun = true)
  public void tearDown() throws Exception {
    app.stop();
  }

}
