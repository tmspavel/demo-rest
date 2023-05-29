package com.tms.demorest.service.impl;

import com.tms.demorest.entity.Book;
import com.tms.demorest.repository.BookRepository;
import com.tms.demorest.service.BookService;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public List<Book> findByParams(String name) {
        return bookRepository.findByParams(name);
    }

    @Override
    public void saveOrUpdate(Book book) {
        bookRepository.save(book);
    }

    @Override
    @Transactional
    public void update(Long id, Book book) {
        Book bookDb = bookRepository.findById(id).orElseThrow(RuntimeException::new);
        bookDb.setDescription(book.getDescription());
        saveOrUpdate(bookDb);
    }

    @Override
    @Transactional
    public void updateBookName(Long id, String name) {
        bookRepository.updateBookName(id, name);
    }

    public void updateBookName(Long id, Book book) {
        Book bookDb = bookRepository.findById(id).orElseThrow(RuntimeException::new);
        bookDb.setDescription(book.getDescription());
        saveOrUpdate(bookDb);
    }

}
