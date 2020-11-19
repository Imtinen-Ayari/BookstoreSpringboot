package com.imtinene.bookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.imtinene.bookstore.entities.Book;
import com.imtinene.bookstore.entities.Genre;
import com.imtinene.bookstore.repos.BookRepository;


@Service
public class BookServiceImpl implements BookService {
	@Autowired
	BookRepository bookRepository;

	@Override
	public Book saveBook(Book b) {
		return bookRepository.save(b);
	}

	@Override
	public Book updateBook(Book b) {
		return bookRepository.save(b);
	}

	@Override
	public void deleteBook(Book b) {
		 bookRepository.delete(b);
		
	}

	@Override
	public void deleteBookById(Long id) {
		bookRepository.deleteById(id);
		
	}

	@Override
	
	public Book getBook(Long id) {
		return bookRepository.findById(id).get();
	}

	@Override
	public List<Book> getAllBooks() {

		return bookRepository.findAll();
	}

	@Override
	public Page<Book> getAllBooksParPage(int page, int size) {
		return bookRepository.findAll(PageRequest.of(page, size));
		
	}

	@Override
	public List<Book> findByNomBook(String nom) {
		
		return bookRepository.findByNomBook(nom) ;
	}

	@Override
	public List<Book> findByNomBookContains(String nom) {
		return bookRepository.findByNomBookContains(nom);
	}

	@Override
	public List<Book> findByNomPrix(String nom, Double prix) {
		return  bookRepository.findByNomPrix(nom,prix);
	}

	@Override
	public List<Book> findByGenre(Genre genre) {
		return bookRepository. findByGenre(genre);
	}

	@Override
	public List<Book> findByGenreIdG(Long id) {
		return bookRepository.findByGenreIdG(id);
	}

	@Override
	public List<Book> findByOrderByNomBookAsc() {
		return  bookRepository.findByOrderByNomBookAsc();
	}

	@Override
	public List<Book> trierBooksNomsPrix() {
		return bookRepository.trierBooksNomsPrix();
	}

	

	
	
	
	

}
