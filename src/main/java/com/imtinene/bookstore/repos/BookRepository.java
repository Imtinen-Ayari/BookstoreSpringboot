package com.imtinene.bookstore.repos;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.imtinene.bookstore.entities.Book;
import com.imtinene.bookstore.entities.Genre;

@RepositoryRestResource(path = "rest")
public interface BookRepository extends JpaRepository<Book, Long> {
	
	List<Book> findByNomBook(String nom);
    //List<Book> findByNomBookLike(String nom);
	List<Book> findByNomBookContains(String nom);
	
	
	//@Query("select d from Book p where d.nomBook like %?1 and d.prixBook > ?2")
	//List<Book> findByNomPrix (String nom, Double prix);

	
	@Query("select b from Book b where b.nomBook like %:nom and b.prixBook > :prix")
	List<Book> findByNomPrix (@Param("nom") String nom,@Param("prix") Double prix);

	@Query("select b from Book b where b.genre = ?1")
	List<Book> findByGenre (Genre genre);
	
	
	List<Book> findByGenreIdG(Long id);
	
	List<Book> findByOrderByNomBookAsc();
	
	@Query("select b from Book b order by b.nomBook ASC, b.prixBook DESC")
	List<Book> trierBooksNomsPrix ();



}
