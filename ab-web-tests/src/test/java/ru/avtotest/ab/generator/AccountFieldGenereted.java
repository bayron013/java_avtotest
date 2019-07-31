package ru.avtotest.ab.generator;

import ru.avtotest.ab.model.AccountFields;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class AccountFieldGenereted {
  public static void main (String[] args) throws IOException {
    int count = Integer.parseInt(args[0]);
    File file = new File(args[1]);

    List<AccountFields> accounts = generateAccounts(count);
    save(accounts, file);
  }

  private static void save(List<AccountFields> accounts, File file) throws IOException {
    Writer writer = new FileWriter(file);
    for (AccountFields account : accounts) {
      writer.write(String.format("%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s\n", account.getFirstname(),
              account.getMiddlename(), account.getLastname(), account.getNickname(),
              account.getTitlearea(), account.getCompany(), account.getAddress(),
              account.getHome(), account.getMobile(), account.getWork(), account.getFax(),
              account.getFirstEmail(), account.getSecondEmail(), account.getThirdEmail(),
              account.getHomepage()));
    }
    writer.close();
  }

  private static List<AccountFields> generateAccounts(int count) {
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
