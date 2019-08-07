package ru.avtotest.ab.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;
import java.util.Objects;


@XStreamAlias("account")
@Entity
@Table(name = "addressbook")
public class AccountFields {

  @XStreamOmitField
  @Id
  @Column(name = "id")
  private int id = Integer.MAX_VALUE;

  @Expose
  @Column(name = "firstname")
  @Type(type = "text")
  private String firstname;

  @Expose
  @Column(name = "middlename")
  @Type(type = "text")
  private String middlename;

  @Expose
  @Column(name = "lastname")
  @Type(type = "text")
  private String lastname;

  @Expose
  @Column(name = "nickname")
  @Type(type = "text")
  private String nickname;

  @Expose
  @Column(name = "title")
  @Type(type = "text")
  private String titlearea;

  @Expose
  @Column(name = "company")
  @Type(type = "longtext") // тут возникает ошибка: Unable to load class [longtext]
  private String company;

  @Expose
  @Column(name = "address")
  @Type(type = "text")
  private String address;

  @Expose
  @Column(name = "home")
  @Type(type = "text")
  private String home;

  @Expose
  @Column(name = "mobile")
  @Type(type = "text")
  private String mobile;

  @Expose
  @Column(name = "work")
  @Type(type = "text")
  private String work;

  @Expose
  @Column(name = "fax")
  @Type(type = "text")
  private String fax;

  @Expose
  @Column(name = "email")
  @Type(type = "text")
  private String firstEmail;

  @Expose
  @Column(name = "email2")
  @Type(type = "text")
  private String secondEmail;

  @Expose
  @Column(name = "email3")
  @Type(type = "text")
  private String thirdEmail;

  @Expose
  @Column(name = "homepage")
  @Type(type = "text")
  private String homepage;

  @Transient
  private String allPhones;

  @Transient
  private String allEmails;

  @Column(name = "photo")
  @Type(type = "text")
  private String photo;

  public File getPhoto() {
    return new File(photo);
  }

  public AccountFields withPhoto(File photo) {
    this.photo = photo.getPath();
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