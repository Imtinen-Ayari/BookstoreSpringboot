package com.imtinene.bookstore;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.imtinene.bookstore.entities.Book;
import com.imtinene.bookstore.repos.BookRepository;
import com.imtinene.bookstore.service.BookService;

@SpringBootTest
class BookstoreApplicationTests {

	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private BookService bookService;
		
		
	
	@Test
	public void testCreateBook() {
	Book b = new Book("pillow thoughts",45.500,new Date());
	bookRepository.save(b);
	}

	@Test
	public void testFindBook()
	{ Book b1 = bookRepository.findById(1L).get(); 
	System.out.println(b1);
	}
	
	@Test
	public void testUpdateBook()
	{ Book b1 = bookRepository.findById(1L).get();
	b1.setPrixBook(50.0); bookRepository.save(b1);
	}
	@Test
	public void testDeleteBook()
	{ bookRepository.deleteById(1L);;
	}
	@Test
	public void testListerAllBook()
	{
	List<Book> prods = bookRepository.findAll();
	for ( Book b1  : prods)
	{
	System.out.println(b1);
	}
	}
	
	@Test
	public void testFindByNomBookContains()
	{
	Page<Book> bs = bookService.getAllBooksParPage(0,2);
	System.out.println(bs.getSize());
	System.out.println(bs.getTotalElements()); 
	System.out.println(bs.getTotalPages());
	bs.getContent().forEach(b -> {System.out.println(b.toString());
	});
	/*ou bien
	for (Produit p : prods)
	{
	System.out.println(p);
	} */
	}
}
