package com.bookapp.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import java.util.stream.Collectors;

import com.bookapp.exception.BookNotFoundException;
import com.bookapp.model.Book;

public class BookServiceStreamImpl implements BookService{

	@Override
	public Book getBookById(int bookId) throws BookNotFoundException {
		
//		List<Book> book= getAllBooks().stream().filter((x)->x.getBookId()==bookId).collect(Collectors.toList());
//		return (Book) book;
		
		return showBooks().stream().filter(book->book.getBookId()==bookId).findAny().orElseThrow(()->new BookNotFoundException("no id matches"));
	}

	@Override
	public List<Book> getBooksByAuthor(String author) throws BookNotFoundException {
		 
		    List<Book> bookList =getAllBooks().stream().filter((book)->book.getAuthor().equals(author)).collect(Collectors.toList());
		    if (bookList.size()==0) {
		      throw new BookNotFoundException("Books not found in the given author");
		    }
		    
		    return bookList;
	}

	@Override
	public List<Book> getBooksByCategory(String category) throws BookNotFoundException {
		 List<Book> bookList =getAllBooks().stream().filter((book)->book.getCategory().equals(category)).collect(Collectors.toList());
		    if (bookList.size()==0) {
		      throw new BookNotFoundException("Books not found in the given category");
		    }
		    
		    return bookList;
	}

	@Override
	public List<Book> getAllBooks() {
		return showBooks().stream().collect(Collectors.toList());
	}

	@Override
	public List<Book> getBooksByLessPrice(double price) throws BookNotFoundException {
		List<Book> bookList =getAllBooks().stream().filter((book)->book.getPrice() < price).collect(Collectors.toList());
	    if (bookList.size()==0) {
	      throw new BookNotFoundException("Books not found in the given category");
	    }
	    
	    return bookList;
	}
	  
	  private List<Book> showBooks()
	  {
	    return Arrays.asList(new Book[] { new Book("Java in action", "kathy", "tech", 1900.0D, Integer.valueOf(1)), 
	      new Book("sam club", "robin", "self", 400.0D, Integer.valueOf(2)), new Book("jee", "kathy", "tech", 1200.0D, Integer.valueOf(6)), 
	      new Book("captain robin hook", "hal", "children", 800.0D, Integer.valueOf(3)), 
	      new Book("pooh tales", "kathy", "children", 4.0D, Integer.valueOf(700)), new Book("leadership", "robin", "self", 1900.0D, Integer.valueOf(5)) });
	  }

}
