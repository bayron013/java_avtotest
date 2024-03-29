package ru.mantis.tests;

import org.testng.annotations.Test;
import ru.mantis.model.Issue;
import ru.mantis.model.Project;

import javax.xml.rpc.ServiceException;
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.Set;

import static org.testng.Assert.assertEquals;


public class SoapTests extends TestBase {

  @Test
  public void testGetProject() throws RemoteException, MalformedURLException, ServiceException {
    Set<Project> projects = app.soap().getProjects();
    System.out.println(projects.size());
    for (Project project : projects) {
      System.out.println(project.getName());
    }
  }

  @Test
  public void testCreateIssue() throws RemoteException, MalformedURLException, ServiceException {
    Set<Project> projects = app.soap().getProjects();
    Issue issue = new Issue().withSummary("Test issue")
            .withDescription("Test issue description").withProject(projects.iterator().next());
    Issue created = app.soap().addIssue(issue);
    assertEquals(issue.getSummary(), created.getSummary());
  }



  @Test
  public void testSkipIfNotFixedIssuesExist() throws RemoteException, MalformedURLException, ServiceException {
    Set<Project> projects = app.soap().getProjects();
    Set<Issue> issues = app.soap().getIssues(projects.iterator().next());
    for (Issue issue : issues) {
      System.out.println("Issue id: " + issue.getId());
      System.out.println("Issue status: "+ issue.getStatus().getName());
      skipIfNotFixed(issue.getId());
    }
  }


}
