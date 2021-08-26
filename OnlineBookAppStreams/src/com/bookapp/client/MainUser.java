package com.bookapp.client;

import com.bookapp.exception.BookNotFoundException;
import com.bookapp.model.Book;
import com.bookapp.service.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainUser
{
  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);
    System.out.println(
      "enter choice\n1.display all\n2.search by id\n3.search by author\n4.search by category\n5.get books below price");
    int choice = sc.nextInt();
    BookService bookImpl = new BookServiceStreamImpl();
    switch (choice)
    {
    case 1: 
      List<Book> bookList = new ArrayList();
      bookList = bookImpl.getAllBooks();
      for (Book book : bookList)
      {
        System.out.println("title " + book.getTitle());
        System.out.println("author " + book.getAuthor());
        System.out.println("category " + book.getCategory());
        System.out.println("price " + book.getPrice());
        System.out.println("book id " + book.getBookId());
        System.out.println();
      }
      break;
    case 2: 
      System.out.println("enter id");
      int id = sc.nextInt();
      Book bookList1 = new Book();
      try
      {
        bookList1 = bookImpl.getBookById(id);
        System.out.println("title " + bookList1.getTitle());
        System.out.println("author " + bookList1.getAuthor());
        System.out.println("category " + bookList1.getCategory());
        System.out.println("price " + bookList1.getPrice());
        System.out.println("book id " + bookList1.getBookId());
        System.out.println();
      }
      catch (BookNotFoundException e)
      {
        System.out.println(e.getMessage());
      }
      catch (Exception e)
      {
        System.out.println(e.getMessage());
      }
      break;
    case 3: 
      System.out.println("enter author");
      String author = sc.next();
      List<Book> bookList2 = new ArrayList();
      try
      {
        bookList2 = bookImpl.getBooksByAuthor(author);
        for (Book book : bookList2)
        {
          System.out.println("title " + book.getTitle());
          System.out.println("author " + book.getAuthor());
          System.out.println("category " + book.getCategory());
          System.out.println("price " + book.getPrice());
          System.out.println("book id " + book.getBookId());
          System.out.println();
        }
      }
      catch (BookNotFoundException e)
      {
        System.out.println(e.getMessage());
      }
      catch (Exception e)
      {
        System.out.println(e.getMessage());
      }
      break;
    case 4: 
      System.out.println("enter category");
      String category = sc.next();
      List<Book> bookList3 = new ArrayList();
      try
      {
        bookList3 = bookImpl.getBooksByCategory(category);
        for (Book book : bookList3)
        {
          System.out.println("title " + book.getTitle());
          System.out.println("author " + book.getAuthor());
          System.out.println("category " + book.getCategory());
          System.out.println("price " + book.getPrice());
          System.out.println("book id " + book.getBookId());
          System.out.println();
        }
      }
      catch (BookNotFoundException e)
      {
        System.out.println(e.getMessage());
      }
      catch (Exception e)
      {
        System.out.println(e.getMessage());
      }
      break;
    case 5: 
      System.out.println("enter max price");
      double price = sc.nextDouble();
      List<Book> bookList4 = new ArrayList();
      try
      {
        bookList4 = bookImpl.getBooksByLessPrice(price);
        for (Book book : bookList4)
        {
          System.out.println("title " + book.getTitle());
          System.out.println("author " + book.getAuthor());
          System.out.println("category " + book.getCategory());
          System.out.println("price " + book.getPrice());
          System.out.println("book id " + book.getBookId());
          System.out.println();
        }
      }
      catch (BookNotFoundException e)
      {
        System.out.println(e.getMessage());
      }
      catch (Exception e)
      {
        System.out.println(e.getMessage());
      }
      break;
    default: 
      System.out.println("invaild choice");
    }
  }
}