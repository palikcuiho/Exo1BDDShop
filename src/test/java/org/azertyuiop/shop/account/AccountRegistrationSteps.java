package org.azertyuiop.shop.account;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.azertyuiop.shop.exception.UserAlreadyExistsException;
import org.junit.Assert;
import org.mockito.Mockito;

import java.util.Optional;

public class AccountRegistrationSteps {

  private Account account;
  private AccountService accountService;
  private AccountRepository accountRepository;

  @Given("The user fills in the registration form")
  public void userFillsInForm(){
    accountRepository = Mockito.mock(AccountRepository.class);
    accountService = new AccountService(accountRepository);
    account = new Account("username", "em@il.com", "p4ssw0rd");
  }

  @When("The user name already exists")
  public void inputNameAlreadyExists(){
    Mockito.when(accountRepository.findByUsername("username")).thenReturn(Optional.of(new Account("username", "", "")));
  }

  @Then("An error is sent")
  public void errorThrown(){
    Assert.assertThrows(UserAlreadyExistsException.class,()->{accountService.registerAccount(account);});
  }

  @When("The user registers")
  public void userRegisters(){
    accountService.registerAccount(account);
  }

  @Then("The account was successfully registered")
  public void accountRegistered(){
    Mockito.verify(accountRepository).save(account);
  }

  @And("A confirmation message is sent")
  public void confirmationMessageSent(){
    // expect successfullyRegisteredMessage to have been called jsp quoi
  }
}
