package com.bookapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bookapp.bean.Book;
import com.bookapp.exception.AuthorNotFoundException;
import com.bookapp.exception.BookNotFoundException;
import com.bookapp.exception.CategoryNotFoundException;

public class BookImpl implements BookInter {
	static Connection connection;

	@Override
	public boolean addBook(Book book) {
		String sql = "insert into bookdetails values(?,?,?,?,?)";
		connection = ModelDAO.openConnection();
		PreparedStatement statement = null;

		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, book.getTitle());
			statement.setString(2, book.getAuthor());
			statement.setInt(3, book.getId());
			statement.setDouble(4, book.getPrice());
			statement.setString(5, book.getCategory());
			statement.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			if (connection != null)
				ModelDAO.closeConnection();
		}
		return false;
	}

	@Override
	public boolean deleteBook(int bookId) throws BookNotFoundException {
		String sql = "delete from bookdetails where id=?";
		connection = ModelDAO.openConnection();
		boolean flag = false;
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(sql);
			statement.setInt(1, bookId);
			statement.execute();
			flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null)
				ModelDAO.closeConnection();
		}
		if (!flag)
			throw new BookNotFoundException("book id not found");
		return flag;

	}

	@Override
	public Book getBookById(int bookId) throws BookNotFoundException {
		String sql = "select * from bookdetails where id=?";
		connection = ModelDAO.openConnection();
		PreparedStatement statement = null;
		Book book = null;
		boolean flag = false;
		try {
			statement = connection.prepareStatement(sql);
			statement.setInt(1, bookId);
			ResultSet rs = statement.executeQuery();
			rs.next();
			book = new Book(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getDouble(4), rs.getString(5));
			flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null)
				ModelDAO.closeConnection();
		}
		if (!flag)
			throw new BookNotFoundException("book id not found");
		return book;
	}

	@Override
	public boolean updateBook(int bookId, double price) throws BookNotFoundException {
		String sql = "update bookdetails set price=? where id=?";
		connection = ModelDAO.openConnection();
		PreparedStatement statement = null;
		boolean flag = false;
		try {
			statement = connection.prepareStatement(sql);
			statement.setDouble(1, price);
			statement.setInt(2, bookId);
			statement.execute();
			flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null)
				ModelDAO.closeConnection();
		}
		if (!flag)
			throw new BookNotFoundException("book id not found");
		return flag;

	}

	@Override
	public List<Book> getAllBooks() {
		String sql = "select * from bookdetails";
		connection = ModelDAO.openConnection();
		List<Book> bookList = new ArrayList<>();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				Book book = new Book(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getDouble(4), rs.getString(5));
				bookList.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null)
				ModelDAO.closeConnection();
		}
		return bookList;
	}

	@Override
	public List<Book> getBookByAuthor(String author) throws AuthorNotFoundException {
		String sql = "select * from bookdetails where author=?";
		connection = ModelDAO.openConnection();
		PreparedStatement statement = null;
		List<Book> bookList = new ArrayList<>();
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, author);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				Book book = new Book(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getDouble(4), rs.getString(5));
				bookList.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null)
				ModelDAO.closeConnection();
		}
		if (bookList.isEmpty())
			throw new AuthorNotFoundException("author not found");
		return bookList;
	}

	@Override
	public List<Book> getBookByCategory(String category) throws CategoryNotFoundException {
		String sql = "select * from bookdetails where category=?";
		connection = ModelDAO.openConnection();
		PreparedStatement statement = null;
		List<Book> bookList = new ArrayList<>();
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, category);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				Book book = new Book(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getDouble(4), rs.getString(5));
				bookList.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null)
				ModelDAO.closeConnection();
		}
		if (bookList.isEmpty())
			throw new CategoryNotFoundException("given category not found");
		return bookList;
	}

}
