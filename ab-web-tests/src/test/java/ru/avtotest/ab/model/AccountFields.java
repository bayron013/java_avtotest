package ru.avtotest.ab.model;

import java.io.File;
import java.util.Objects;

public class AccountFields {
  private int id = Integer.MAX_VALUE;
  private String firstname;
  private String middlename;
  private String lastname;
  private String nickname;
  private String titlearea;
  private String company;
  private String address;
  private String home;
  private String mobile;
  private String work;
  private String fax;
  private String firstEmail;
  private String secondEmail;
  private String thirdEmail;
  private String homepage;
  private String allPhones;
  private String allEmails;
  private File photo;

  public File getPhoto() {
    return photo;
  }

  public AccountFields withPhoto(File photo) {
    this.photo = photo;
    return this;
  }

  public AccountFields whithAllEmails(String allEmails) {
    this.allEmails = allEmails;
    return this;
  }

  public AccountFields whithAllPhones(String allPhones) {
    this.allPhones = allPhones;
    return this;
  }

  public AccountFields whithId(int id) {
    this.id = id;
    return this;
  }

  public AccountFields whithFirstname(String firstname) {
    this.firstname = firstname;
    return this;
  }

  public AccountFields whithMiddlename(String middlename) {
    this.middlename = middlename;
    return this;
  }

  public AccountFields whithLastname(String lastname) {
    this.lastname = lastname;
    return this;
  }

  public AccountFields whithNickname(String nickname) {
    this.nickname = nickname;
    return this;
  }

  public AccountFields whithTitlearea(String titlearea) {
    this.titlearea = titlearea;
    return this;
  }

  public AccountFields whithCompany(String company) {
    this.company = company;
    return this;
  }

  public AccountFields whithAddress(String address) {
    this.address = address;
    return this;
  }

  public AccountFields whithHome(String home) {
    this.home = home;
    return this;
  }

  public AccountFields whithMobile(String mobilenumber) {
    this.mobile = mobilenumber;
    return this;
  }

  public AccountFields whithWork(String aboutworkfield) {
    this.work = aboutworkfield;
    return this;
  }

  public AccountFields whithFax(String fax) {
    this.fax = fax;
    return this;
  }

  public AccountFields whithFirstEmail(String firstEmail) {
    this.firstEmail = firstEmail;
    return this;
  }

  public AccountFields whithSecondEmail(String secondEmail) {
    this.secondEmail = secondEmail;
    return this;
  }

  public AccountFields whithThirdEmail(String thirdEmail) {
    this.thirdEmail = thirdEmail;
    return this;
  }

  public AccountFields whithHomepage(String homepage) {
    this.homepage = homepage;
    return this;
  }

  public String getAllEmails() {
    return allEmails;
  }

  public String getAllPhones() {
    return allPhones;
  }

  public int getId() {
    return id;
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

  public String getMobile() {
    return mobile;
  }

  public String getWork() {
    return work;
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

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    AccountFields that = (AccountFields) o;
    return id == that.id &&
            Objects.equals(firstname, that.firstname) &&
            Objects.equals(lastname, that.lastname);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, firstname, lastname);
  }

  @Override
  public String toString() {
    return "AccountFields{" +
            "id=" + id +
            ", firstname='" + firstname + '\'' +
            ", lastname='" + lastname + '\'' +
            '}';
  }

}