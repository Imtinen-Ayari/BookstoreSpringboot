package com.imtinene.bookstore.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.imtinene.bookstore.entities.Book;
import com.imtinene.bookstore.entities.Genre;

public interface BookService {
	Book saveBook(Book b);
	Book updateBook(Book b);
	void deleteBook(Book b);
	void deleteBookById(Long id);
	Book getBook(Long id);
	List<Book> getAllBooks();
	
	
	Page<Book> getAllBooksParPage(int page, int size);
	
	List<Book> findByNomBook(String nom);
	List<Book> findByNomBookContains(String nom);
	List<Book> findByNomPrix (String nom, Double prix);
	List<Book> findByGenre (Genre genre);
	List<Book> findByGenreIdG(Long id);
	List<Book> findByOrderByNomBookAsc();
	List<Book> trierBooksNomsPrix();

}
