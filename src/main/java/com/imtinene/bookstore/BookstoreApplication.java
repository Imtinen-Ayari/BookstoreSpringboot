package com.imtinene.bookstore;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.imtinene.bookstore.entities.Book;
import com.imtinene.bookstore.service.BookService;

@SpringBootApplication
public class BookstoreApplication implements CommandLineRunner{
	
	@Autowired
	BookService bookService;
	
	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//bookService.saveBook(new Book("les 5 montagne", 30.500, new Date()));
		//bookService.saveBook(new Book("pride of ceo", 40.900, new Date()));
		//bookService.saveBook(new Book("MAF", 76.00, new Date()));
		
		
	
		
		repositoryRestConfiguration.exposeIdsFor(Book.class);
		}
	

}
