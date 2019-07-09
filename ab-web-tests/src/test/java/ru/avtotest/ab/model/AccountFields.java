package ru.avtotest.ab.model;

public class AccountFields {
  private final String firstname;
  private final String middlename;
  private final String lastname;
  private final String nickname;
  private final String titlearea;
  private final String company;
  private final String address;
  private final String home;
  private final String mobilenumber;
  private final String aboutworkfield;
  private final String fax;
  private final String firstEmail;
  private final String secondEmail;
  private final String thirdEmail;
  private final String homepage;
  private String group;

  public AccountFields(String firstname, String middlename, String lastname, String nickname,
                       String titlearea, String company, String address, String home,
                       String mobilenumber, String aboutworkfield, String fax, String firstEmail,
                       String secondEmail, String thirdEmail, String homepage, String group) {
    this.firstname = firstname;
    this.middlename = middlename;
    this.lastname = lastname;
    this.nickname = nickname;
    this.titlearea = titlearea;
    this.company = company;
    this.address = address;
    this.home = home;
    this.mobilenumber = mobilenumber;
    this.aboutworkfield = aboutworkfield;
    this.fax = fax;
    this.firstEmail = firstEmail;
    this.secondEmail = secondEmail;
    this.thirdEmail = thirdEmail;
    this.homepage = homepage;
    this.group = group;
  }

  public String getFirstname() {
    return firstname;
  }

  public String getMiddlename() {
    return middlename;
  }

  public String getLastname() {
    return lastname;
  }

  public String getNickname() {
    return nickname;
  }

  public String getTitlearea() {
    return titlearea;
  }

  public String getCompany() {
    return company;
  }

  public String getAddress() {
    return address;
  }

  public String getHome() {
    return home;
  }

  public String getMobilenumber() {
    return mobilenumber;
  }

  public String getAboutworkfield() {
    return aboutworkfield;
  }

  public String getFax() {
    return fax;
  }

  public String getFirstEmail() {
    return firstEmail;
  }

  public String getSecondEmail() {
    return secondEmail;
  }

  public String getThirdEmail() {
    return thirdEmail;
  }

  public String getHomepage() {
    return homepage;
  }

  public String getGroup() {
    return group;
  }
}