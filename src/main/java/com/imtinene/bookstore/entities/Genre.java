package com.imtinene.bookstore.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;




@Data
@AllArgsConstructor
@Entity
public class Genre {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idG;
	private String nomG;
	private String descriptionG;
	
	
	
	
	@OneToMany(mappedBy = "genre")
	@JsonIgnore
	private List<Book> books;
	
	
	
	
	public Genre()
	{
		super();
	}
	
	
	
	
	
	public Genre(Long idG, String nomG, String descriptionG) {
		super();
		this.idG = idG;
		this.nomG = nomG;
		this.descriptionG = descriptionG;
	}



	public Long getIdG() {
		return idG;
	}
	public void setIdG(Long idG) {
		this.idG = idG;
	}
	public String getNomG() {
		return nomG;
	}
	public void setNomG(String nomG) {
		this.nomG = nomG;
	}
	public String getDescriptionG() {
		return descriptionG;
	}
	public void setDescriptionG(String descriptionG) {
		this.descriptionG = descriptionG;
	}
	
	public List<Book> getBooks() {
		return books;
		}
		public void setBooks(List<Book> books) {
		this.books = books;
}
}
