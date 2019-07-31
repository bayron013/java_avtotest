package ru.avtotest.ab.model;

import java.io.File;
import java.util.Objects;

public class GroupData {
  private int id = Integer.MAX_VALUE;
  private String name;
  private String header;
  private String footer;
  private File photo;

  public File getPhoto() {
    return photo;
  }

  public GroupData whithPhoto(File photo) {
    this.photo = photo;
    return this;
  }

  public GroupData whithId(int id) {
    this.id = id;
    return this;
  }

  public GroupData whithName(String name) {
    this.name = name;
    return this;
  }

  public GroupData whithHeader(String header) {
    this.header = header;
    return this;
  }

  public GroupData whithFooter(String footer) {
    this.footer = footer;
    return this;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getHeader() {
    return header;
  }

  public String getFooter() {
    return footer;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    GroupData groupData = (GroupData) o;
    return id == groupData.id &&
            Objects.equals(name, groupData.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name);
  }

  @Override
  public String toString() {
    return "GroupData{" +
            "id='" + id + '\'' +
            ", name='" + name + '\'' +
            '}';
  }

}
