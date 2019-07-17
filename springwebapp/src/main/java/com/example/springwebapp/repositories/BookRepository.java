package com.example.springwebapp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.springwebapp.beans.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
}
