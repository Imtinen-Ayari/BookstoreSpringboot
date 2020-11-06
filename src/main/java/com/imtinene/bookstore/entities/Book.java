package com.imtinene.bookstore.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idBook;
	private String nomBook;
	private Double prixBook;
	private Date dateCreation; 
	
	
	@ManyToOne
	private Genre genre;
	
	public Book() {
		super();
		}


	public Book(String nomBook, Double prixBook, Date dateCreation) {
		super();
		this.nomBook = nomBook;
		this.prixBook = prixBook;
		this.dateCreation = dateCreation;
	}


	public Long getIdBook() {
		return idBook;
	}


	public void setIdBook(Long idBook) {
		this.idBook = idBook;
	}


	public String getNomBook() {
		return nomBook;
	}


	public void setNomBook(String nomBook) {
		this.nomBook = nomBook;
	}


	public Double getPrixBook() {
		return prixBook;
	}


	public void setPrixBook(Double prixBook) {
		this.prixBook = prixBook;
	}


	public Date getDateCreation() {
		return dateCreation;
	}


	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}


	@Override
	public String toString() {
		return "Book [idBook=" + idBook + ", nomBook=" + nomBook + ", prixBook=" + prixBook + ", dateCreation="
				+ dateCreation + "]";
	}


	public Genre getGenre() {
		return genre;
	}


	public void setGenre(Genre genre) {
		this.genre = genre;
	}
	
	

}
