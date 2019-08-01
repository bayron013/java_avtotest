package ru.avtotest.ab.generator;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thoughtworks.xstream.XStream;
import ru.avtotest.ab.model.AccountFields;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class AccountFieldGeneretor {

  @Parameter(names = "-c", description = "Account count")
  public int count;

  @Parameter(names = "-f", description = "Target file")
  public String file;

  @Parameter(names = "-d", description = "Data format")
  public String format;

  public static void main (String[] args) throws IOException {
    AccountFieldGeneretor generator = new AccountFieldGeneretor();
    JCommander jComander = new JCommander(generator);
    try {
      jComander.parse(args);
    } catch (ParameterException ex) {
      jComander.usage();
      return;
    }
    generator.run();
  }

  private void run() throws IOException {
    List<AccountFields> accounts = generateAccounts(count);
    if (format.equals("csv")) {
      saveAsCsv(accounts, new File(file));
    } else if (format.equals("xml")) {
      saveAsXml(accounts, new File(file));
    } else if (format.equals("json")) {
      saveAsJson(accounts, new File(file));
    } else  {
      System.out.println("Unrecignized format " + format);
    }
  }

  private void saveAsJson(List<AccountFields> accounts, File file) throws IOException {
    Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation()
            .create();
    String json = gson.toJson(accounts);
    try (Writer writer = new FileWriter(file)) {
      writer.write(json);
    }
  }

  private void saveAsXml(List<AccountFields> accounts, File file) throws IOException {
    XStream xStream = new XStream();
    xStream.processAnnotations(AccountFields.class);
    String xml = xStream.toXML(accounts);
    try (Writer writer = new FileWriter(file)) {
      writer.write(xml);
    }
  }

  private void saveAsCsv(List<AccountFields> accounts, File file) throws IOException {
    try (Writer writer = new FileWriter(file)) {
      for (AccountFields account : accounts) {
        writer.write(String.format("%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s\n", account.getFirstname(),
                account.getMiddlename(), account.getLastname(), account.getNickname(),
                account.getTitlearea(), account.getCompany(), account.getAddress(),
                account.getHome(), account.getMobile(), account.getWork(), account.getFax(),
                account.getFirstEmail(), account.getSecondEmail(), account.getThirdEmail(),
                account.getHomepage()));
      }
    }
  }

  private List<AccountFields> generateAccounts(int count) {
    List<AccountFields>  accounts = new ArrayList<AccountFields>();
    for (int i = 0; i < count; i++) {
      accounts.add(new AccountFields().whithFirstname(String.format("firstame %s", i))
              .whithMiddlename(String.format("middlename %s", i))
              .whithLastname(String.format("lastname %s", i))
              .whithNickname(String.format("nickname %s", i))
              .whithTitlearea(String.format("titlearea %s", i))
              .whithCompany(String.format("company %s", i))
              .whithAddress(String.format("address %s", i))
              .whithHome(String.format("homephone %s", i))
              .whithMobile(String.format("mobilephone %s", i))
              .whithWork(String.format("workphone %s", i))
              .whithFax(String.format("fax %s", i))
              .whithFirstEmail(String.format("firstemail %s", i))
              .whithSecondEmail(String.format("secondemail %s", i))
              .whithThirdEmail(String.format("thirdemail %s", i))
              .whithHomepage(String.format("homepage %s", i)));
    }
    return accounts;
  }
}
