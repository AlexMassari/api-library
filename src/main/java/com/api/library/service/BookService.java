package com.api.library.service;

import com.api.library.dto.BookDto;
import com.api.library.entity.BookEntity;
import com.api.library.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public interface BookService {
    BookDto findBookId(BigInteger bookId);

    BookDto findBookByTitle(String bookTitle);

    List<BookDto> getBooksByAuthor(BigInteger authorId);
    void insertBook(String title, BigInteger author, BigInteger publisher, String year, String genre, int amount);

    void updateBook(String title, BigInteger author, BigInteger publisher, String year, String genre, int amount, BigInteger id) throws NotFoundException;

    void deleteBook(BigInteger bookId) throws NotFoundException;
}
