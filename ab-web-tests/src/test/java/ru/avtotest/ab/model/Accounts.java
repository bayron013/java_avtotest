package ru.avtotest.ab.model;

import com.google.common.collect.ForwardingSet;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Accounts extends ForwardingSet<AccountFields> {


  private Set<AccountFields> delegate;

  public Accounts(Accounts accounts) {
    this.delegate = new HashSet<AccountFields>(accounts.delegate);
  }

  public Accounts() {
    this.delegate = new HashSet<AccountFields>();
  }

  public Accounts(Collection<AccountFields> accounts) {
    this.delegate = new HashSet<AccountFields>(accounts);
  }

  @Override
  protected Set<AccountFields> delegate() {
    return delegate;
  }

  public Accounts withAddedAc(AccountFields account) {
    Accounts accounts = new Accounts(this);
    accounts.add(account);
    return accounts;
  }


  public Accounts withoutAc (AccountFields account) {
    Accounts accounts = new Accounts(this);
    accounts.remove(account);
    return accounts;
  }

}
