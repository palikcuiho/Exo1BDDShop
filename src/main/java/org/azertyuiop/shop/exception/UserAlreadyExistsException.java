package org.azertyuiop.shop.exception;

public class UserAlreadyExistsException extends RuntimeException {
  public UserAlreadyExistsException(String username) {
    super("The account \"" + username +"\" already exists. Please use a different username.");
  }
}
