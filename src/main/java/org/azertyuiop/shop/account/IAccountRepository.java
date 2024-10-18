package org.azertyuiop.shop.account;

import java.util.List;

public interface IAccountRepository {
  public Account save(Account account);
  public List<Account> findAll();
}
