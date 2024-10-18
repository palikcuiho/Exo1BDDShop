package org.azertyuiop.shop.account;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.azertyuiop.shop.exception.UserAlreadyExistsException;
import org.junit.Assert;
import org.mockito.Mockito;

import java.util.Optional;

public class AccountSteps {

  private Account account;
  private AccountService accountService;
  private AccountRepository accountRepository;

  @Given("The user fills in the registration form")
  public void userRegisters(){
    accountRepository = Mockito.mock(AccountRepository.class);
    accountService = new AccountService(accountRepository);
    account = new Account("existing username", "em@il.com", "p4ssw0rd");
  }

  @When("The user inputs an existing user name")
    public void inputNameAlreadyExists(){
    Mockito.when(this.accountRepository.findByUsername("existing username")).thenReturn(Optional.of(new Account("existing username", "", "")));
  }

  @Then("An error is sent")
    public void errorThrown(){
    Assert.assertThrows(UserAlreadyExistsException.class,()->{accountService.registerAccount(this.account);});
  }
}
