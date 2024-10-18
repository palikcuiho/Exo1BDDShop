package org.azertyuiop.shop.account;

//import org.springframework.data.jpa.repository.JpaRepository;
//
//public interface AccountRepository  extends JpaRepository<Account, Integer> {
//}

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AccountRepository implements IAccountRepository {
      private final List<Account> extraSecureAccountDatabase;

  public AccountRepository() {
    this.extraSecureAccountDatabase = new ArrayList<Account>();
  }

  public Account save(Account account){
        extraSecureAccountDatabase.add(account);
        return account;
  }

  public List<Account> findAll(){
      return extraSecureAccountDatabase;
  }

  public Optional<Account> findByUsername(String username) {
    return extraSecureAccountDatabase
            .stream()
            .filter(a -> a.getUsername().equals(username))
            .findAny();
  }
}