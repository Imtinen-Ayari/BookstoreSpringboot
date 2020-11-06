package com.imtinene.bookstore.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.imtinene.bookstore.entities.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
