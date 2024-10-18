package org.azertyuiop.shop.account;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.azertyuiop.shop.exception.IncorrectCredentialsException;
import org.azertyuiop.shop.exception.UserAlreadyExistsException;
import org.junit.Assert;
import org.mockito.Mockito;

import java.util.Optional;

public class AccountLoginSteps {

  private Account account;
  private AccountService accountService;
  private AccountRepository accountRepository;

  @Given("a user tries to log in")
  public void userFillsInForm(){
    accountRepository = Mockito.mock(AccountRepository.class);
    accountService = new AccountService(accountRepository);
    account = new Account("username", "em@il.com", "p4ssw0rd");
  }

  @When("The user exists")
  public void userExists(){
    Mockito.when(accountRepository.findByUsername("username")).thenReturn(Optional.of(new Account("username", "em@il.com", "p4ssw0rd")));
  }


//        Then the user is logged in


  @And("the user is redirected to home page")
  public void userRedirectedToHomePage(){
   // expect redirectToHomePage to have been called etc.
  }

  @When("The user does not exist")
  public void userDoesNotExist(){
  Mockito.when(accountRepository.findByUsername("username")).thenReturn(Optional.empty());
  }

// When The password is wrong

  @Then("There is an error")
  public void errorThrown(){
    Assert.assertThrows(IncorrectCredentialsException.class,()->{accountService.logIn("username","p4ssw0rd");});
  }



}
