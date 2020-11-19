package com.imtinene.bookstore.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.imtinene.bookstore.entities.Book;
import com.imtinene.bookstore.service.BookService;

@Controller
public class BookController {
	
	@Autowired
	BookService bookService;
	
	@RequestMapping("/showCreate")
	public String showCreate()
	{
	return "createBook";
	}
	@RequestMapping("/saveBook")
	
	
	public String saveBook(@ModelAttribute("Book") Book book,
	                       @RequestParam("date") String date,
	                        ModelMap modelMap) throws ParseException
	{
	
		//conversion de la date
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		Date dateCreation = dateformat.parse(String.valueOf(date));
		book.setDateCreation(dateCreation);
		Book saveBook = bookService.saveBook(book);
		String msg ="book enregistré avec Id "+saveBook.getIdBook();
		modelMap.addAttribute("msg", msg);
		return "createBook";
		}
	

	@RequestMapping("/ListeBook")
	public String listeBook(ModelMap modelMap,
			@RequestParam (name="page",defaultValue = "0") int page,
			@RequestParam (name="size", defaultValue = "2") int size)
	{
		Page<Book> bs = bookService.getAllBooksParPage(page, size);
		
		modelMap.addAttribute("books", bs);
		modelMap.addAttribute("pages", new int[bs.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		return "listeBook";
	}
	
	@RequestMapping("/supprimerBook")
	public String supprimerBook(@RequestParam("id") Long id,
	                                       ModelMap modelMap,
	                                       @RequestParam (name="page",defaultValue = "0") int page,
	                                       @RequestParam (name="size", defaultValue = "2") int size)
	{
	bookService.deleteBookById(id);
	Page<Book> bs = bookService.getAllBooksParPage(page, size);
	modelMap.addAttribute("books", bs);
	modelMap.addAttribute("pages", new int[bs.getTotalPages()]);
	modelMap.addAttribute("currentPage", page);
	modelMap.addAttribute("size", size);
	return "listeBook";
	}
	
	@RequestMapping("/modifierBook")
	public String editerBook(@RequestParam("id") Long id,ModelMap modelMap)
	{
	Book b= bookService.getBook(id);
	modelMap.addAttribute("Book", b);
	return "editerBook";
	}
	@RequestMapping("/updateBook")
	public String updateProduit(@ModelAttribute("Book") Book book,
	@RequestParam("date") String date,ModelMap modelMap) throws ParseException, java.text.ParseException
	{
	    SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		Date dateCreation = dateformat.parse(String.valueOf(date));
		book.setDateCreation(dateCreation);
		bookService.updateBook(book);
		List<Book> bs = bookService.getAllBooks();
		modelMap.addAttribute("books", bs);
		return "listeBook";
		}
}
