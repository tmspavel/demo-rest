package com.tms.demorest.service;

import com.tms.demorest.entity.Book;
import java.util.List;
import java.util.Optional;

//DI
//IoC
public interface BookService {

    List<Book> getBooks();

    Optional<Book> getBookById(Long id);

    void saveOrUpdate(Book book);

    void update(Long id, Book book);

    void updateBookName(Long id, String name);

    List<Book> findByParams(String name);
}
