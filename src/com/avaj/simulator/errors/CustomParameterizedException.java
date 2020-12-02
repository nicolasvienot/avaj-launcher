package com.avaj.simulator.errors;

public class CustomParameterizedException extends Exception {
  private static final long serialVersionUID = 1L;

  private final String message;
  private final String errCode;

  public CustomParameterizedException(String message, String errCode) {
    super(message);
    this.message = message;
    this.errCode = errCode;
  }

  @Override
  public String getMessage() {
    return message;
  }

  public String getErrCode() {
    return errCode;
  }
}
