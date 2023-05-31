package com.tms.demorest.controller;

import com.tms.demorest.dto.BookDto;
import com.tms.demorest.entity.Book;
import com.tms.demorest.service.BookService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    @GetMapping("/all")
    public List<BookDto> getBooks() {
        return bookService.getBooks();
    }

    @GetMapping("/all/{description}")
    public List<Book> getBooks(@PathVariable String description) {
        return bookService.findByParams(description);
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        return bookService.getBookById(id)
                          .orElseThrow(RuntimeException::new);
    }

    @PostMapping
    public void save(@RequestBody BookDto bookDto) {
        bookService.saveOrUpdate(bookDto);
    }

    @PutMapping("/{book_id}")
    public void update(@PathVariable("book_id") Long id, @RequestBody BookDto bookDto) {
        bookService.update(id, bookDto);
    }

    @PutMapping("/{book_id}/{book_name}")
    public void update(@PathVariable("book_id") Long id, @PathVariable("book_name") String name) {
        bookService.updateBookName(id, name);
    }
}
