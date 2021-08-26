package com.bookapp.dao;

import java.util.List;

import com.bookapp.bean.Book;
import com.bookapp.exception.*;

public interface BookInter {

	// called by admin
	boolean addBook(Book book);

	boolean deleteBook(int bookId) throws BookNotFoundException;

	Book getBookById(int bookId) throws BookNotFoundException;

	boolean updateBook(int bookId, double price) throws BookNotFoundException;

	// called by customer
	List<Book> getAllBooks();

	List<Book> getBookByAuthor(String author) throws AuthorNotFoundException;

	List<Book> getBookByCategory(String category) throws CategoryNotFoundException;
}
