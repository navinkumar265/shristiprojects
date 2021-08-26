package com.bookapp.exception;

public class BookNotFoundException
  extends Exception
{
  private static final long serialVersionUID = 1L;
  
  public BookNotFoundException() {}
  
  public BookNotFoundException(String message)
  {
    super(message);
  }
}