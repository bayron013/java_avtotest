package ru.mantis.tests;

import org.testng.annotations.Test;

import static ru.mantis.tests.TestBase.app;

public class RegistrationTests {


  @Test
  public void testRegistration() {
    app.registration().start("vlad", "vlad@localhost.localdomain");
  }
}
