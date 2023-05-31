package com.tms.demorest.service;

import com.tms.demorest.dto.BookDto;
import com.tms.demorest.entity.Book;
import java.util.List;
import java.util.Optional;

//DI
//IoC
public interface BookService {

    List<BookDto> getBooks();

    Optional<Book> getBookById(Long id);

    void saveOrUpdate(BookDto book);

    void update(Long id, BookDto book);

    void updateBookName(Long id, String name);

    List<Book> findByParams(String name);
}
