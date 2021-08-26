package com.bookapp.service;

import com.bookapp.exception.BookNotFoundException;
import com.bookapp.model.Book;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BookServiceImpl implements BookService {
	public Book getBookById(int bookId) throws BookNotFoundException {

		List<Book> bookList = getAllBooks();
		for (Book book : bookList) {
			if (book.getBookId().intValue() == bookId)
				return book;
		}

		throw new BookNotFoundException("invalid Id");

	}

	public List<Book> getBooksByAuthor(String author) throws BookNotFoundException {
		boolean flag = false;
		List<Book> bookList = getAllBooks();
		List<Book> bookAuthor = new ArrayList();
		for (Book book : bookList) {
			if (author.equals(book.getAuthor())) {
				bookAuthor.add(book);
				flag = true;
			}
		}
		if (!flag) {
			throw new BookNotFoundException("Books not found in the given author");
		}
		return bookAuthor;
	}

	public List<Book> getBooksByCategory(String category) throws BookNotFoundException {
		boolean flag = false;
		List<Book> bookList = getAllBooks();
		List<Book> bookCategory = new ArrayList();
		for (Book book : bookList) {
			if (category.equals(book.getCategory())) {
				bookCategory.add(book);
				flag = true;
			}
		}
		if (!flag) {
			throw new BookNotFoundException("Books not found in the given category");
		}
		return bookCategory;
	}

	public List<Book> getAllBooks() {
		return showBooks();
	}

	public List<Book> getBooksByLessPrice(double price) throws BookNotFoundException {
		boolean flag = false;
		List<Book> bookList = getAllBooks();
		List<Book> bookPrice = new ArrayList();
		for (Book book : bookList) {
			if (price >= book.getPrice()) {
				bookPrice.add(book);
				flag = true;
			}
		}
		if (!flag) {
			throw new BookNotFoundException("Books not found in the given below price");
		}
		return bookPrice;
	}

	private List<Book> showBooks() {
		return Arrays.asList(new Book[] { new Book("Java in action", "kathy", "tech", 1900.0D, Integer.valueOf(1)),
				new Book("sam club", "robin", "self", 400.0D, Integer.valueOf(2)),
				new Book("jee", "kathy", "tech", 1200.0D, Integer.valueOf(6)),
				new Book("captain robin hook", "hal", "children", 800.0D, Integer.valueOf(3)),
				new Book("pooh tales", "kathy", "children", 4.0D, Integer.valueOf(700)),
				new Book("leadership", "robin", "self", 1900.0D, Integer.valueOf(5)) });
	}
}