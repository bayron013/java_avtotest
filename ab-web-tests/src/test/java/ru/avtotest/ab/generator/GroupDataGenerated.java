package ru.avtotest.ab.generator;


import ru.avtotest.ab.model.GroupData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class GroupDataGenerated {

  public static void main (String[] args) throws IOException {
    int count = Integer.parseInt(args[0]);
    File file = new File(args[1]);

    List<GroupData> groups = generateGroups(count);
    save(groups, file);
  }

  private static void save(List<GroupData> groups, File file) throws IOException {
    Writer writer = new FileWriter(file);
    for (GroupData group : groups) {
      writer.write(String.format("%s;%s;%s\n", group.getName(),
              group.getHeader(), group.getFooter()));
    }
    writer.close();
  }

  private static List<GroupData> generateGroups(int count) {
    List<GroupData>  groups = new ArrayList<GroupData>();
    for (int i = 0; 1 < count; i++) {
      groups.add(new GroupData().whithName(String.format("Test %s", i))
              .whithHeader(String.format("header %s", i))
              .whithFooter(String.format("footer %s", i)));
    }
    return groups;
  }
}
