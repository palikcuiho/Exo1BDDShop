package org.azertyuiop.shop.exception;

public class IncorrectCredentialsException extends RuntimeException {
  public IncorrectCredentialsException() {
    super("Incorrect login or password");
  }
}
