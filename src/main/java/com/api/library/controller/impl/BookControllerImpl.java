package com.api.library.controller.impl;

import com.api.library.controller.BookController;
import com.api.library.dto.BookDto;
import com.api.library.entity.BookEntity;
import com.api.library.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.math.BigInteger;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/book")
public class BookControllerImpl implements BookController {

    private final BookService bookService;

    @Override
    @GetMapping("/id/{bookId}")
    public BookDto getBookById(HttpServletRequest request, @PathVariable(name = "bookId") final BigInteger bookId) {
        return bookService.findBookId(bookId);
    }

    @Override
    @GetMapping("/title/{bookTitle}")
    public BookDto getBookByName(HttpServletRequest request, @PathVariable(name = "bookTitle") final String bookTitle) {
        return bookService.findBookByTitle(bookTitle);
    }

    @Override
    @GetMapping("/author/{authorId}")
    public List<BookDto> getBooksByAuthor(HttpServletRequest request, @PathVariable(name = "authorId") final BigInteger authorId) {
        return bookService.getBooksByAuthor(authorId);}

    @Override
    @PostMapping("/add")
    public ResponseEntity<String> createBook(@RequestBody BookEntity book) {
        try {
            bookService.insertBook(book.getBookTitle(), book.getBookAuthor(), book.getBookPublisher(), book.getBookYear(), book.getBookGenre(), book.getBookAmount());
            return ResponseEntity.ok("Book inserted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating book");
        }
    }
}
