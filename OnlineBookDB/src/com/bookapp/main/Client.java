package com.bookapp.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.bookapp.bean.Book;
import com.bookapp.dao.BookImpl;
import com.bookapp.dao.BookInter;
import com.bookapp.exception.AuthorNotFoundException;
import com.bookapp.exception.BookNotFoundException;
import com.bookapp.exception.CategoryNotFoundException;

public class Client {

	public static void main(String[] args) {

		BookInter bookService = new BookImpl();
		Scanner sc = new Scanner(System.in);
		System.out.println("enter 1 for admin and 2 for customer");
		int user = sc.nextInt();
		if (user == 1) {
			System.out.println("enter choice\n1.add book\n2.delete book\n3.get book\n4.update book");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				boolean check = false;
				System.out.println("***enter book details to add***");
				System.out.println("enter title");
				String title = sc.next();
				System.out.println("enter author");
				String author = sc.next();
				System.out.println("enter id");
				int id = sc.nextInt();
				System.out.println("enter price");
				double price = sc.nextDouble();
				System.out.println("enter category");
				String category = sc.next();

				Book book = new Book(title, author, id, price, category);
				check = bookService.addBook(book);
				if (check)
					System.out.println("inserted successfully");
				break;

			case 2:
				System.out.println("enter book id to delete");
				int bookId = sc.nextInt();
				boolean check1 = false;
				try {
					check1 = bookService.deleteBook(bookId);
				} catch (BookNotFoundException e) {
					e.printStackTrace();
				}
				if (check1)
					System.out.println("deleted successfully");
				break;

			case 3:
				System.out.println("enter book id to search");
				int bookId1 = sc.nextInt();
				Book book1 = null;
				try {
					book1 = bookService.getBookById(bookId1);
				} catch (BookNotFoundException e) {
					e.printStackTrace();
				}
				System.out.println("Title " + book1.getTitle());
				System.out.println("author " + book1.getAuthor());
				System.out.println("ID " + book1.getId());
				System.out.println("price " + book1.getPrice());
				System.out.println("category " + book1.getCategory());
				break;
			case 4:
				System.out.println("enter book id");
				int bookId2 = sc.nextInt();
				System.out.println("enter price to update");
				double price1 = sc.nextDouble();
				boolean check2 = false;
				try {
					check2 = bookService.updateBook(bookId2, price1);
				} catch (BookNotFoundException e) {
					e.printStackTrace();
				}
				if (check2)
					System.out.println("updated successfully");
				break;
			default:
				System.out.println("invalid input");
			}
		} else if (user == 2) {
			System.out.println("enter choice\n1.display all books\n2.get by author\n3.get by category");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				List<Book> bookList = new ArrayList();
				bookList = bookService.getAllBooks();
				for (Book book : bookList) {
					System.out.println("title " + book.getTitle());
					System.out.println("author " + book.getAuthor());
					System.out.println("book id " + book.getId());
					System.out.println("price " + book.getPrice());
					System.out.println("category " + book.getCategory());
					System.out.println();
				}
				break;
			case 2:
				System.out.println("enter author to search");
				String author = sc.next();
				List<Book> bookList1 = new ArrayList();
				try {
					bookList1 = bookService.getBookByAuthor(author);
				} catch (AuthorNotFoundException e) {
					e.printStackTrace();
				}
				for (Book book : bookList1) {
					System.out.println("title " + book.getTitle());
					System.out.println("author " + book.getAuthor());
					System.out.println("book id " + book.getId());
					System.out.println("price " + book.getPrice());
					System.out.println("category " + book.getCategory());
					System.out.println();
				}
				break;
			case 3:
				System.out.println("enter category to search");
				String category = sc.next();
				List<Book> bookList2 = new ArrayList();
				try {
					bookList2 = bookService.getBookByCategory(category);
				} catch (CategoryNotFoundException e) {
					e.printStackTrace();
				}
				for (Book book : bookList2) {
					System.out.println("title " + book.getTitle());
					System.out.println("author " + book.getAuthor());
					System.out.println("book id " + book.getId());
					System.out.println("price " + book.getPrice());
					System.out.println("category " + book.getCategory());
					System.out.println();
				}
				break;
			default:
				System.out.println("invalid input");
			}
		} else
			System.out.println("invalid selection");

	}

}
