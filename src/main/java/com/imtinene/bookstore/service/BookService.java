package com.imtinene.bookstore.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.imtinene.bookstore.entities.Book;

public interface BookService {
	Book saveBook(Book b);
	Book updateBook(Book b);
	void deleteBook(Book b);
	void deleteBookById(Long id);
	Book getBook(Long id);
	List<Book> getAllBooks();
	
	
	Page<Book> getAllBooksParPage(int page, int size);

}
