package com.bookapp.service;

import com.bookapp.exception.BookNotFoundException;
import com.bookapp.model.Book;
import java.util.List;

public abstract interface BookService
{
  public abstract Book getBookById(int paramInt)
    throws BookNotFoundException;
  
  public abstract List<Book> getBooksByAuthor(String paramString)
    throws BookNotFoundException;
  
  public abstract List<Book> getBooksByCategory(String paramString)
    throws BookNotFoundException;
  
  public abstract List<Book> getAllBooks();
  
  public abstract List<Book> getBooksByLessPrice(double paramDouble)
    throws BookNotFoundException;
}