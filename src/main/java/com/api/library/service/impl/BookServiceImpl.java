package com.api.library.service.impl;

import com.api.library.dto.BookDto;
import com.api.library.entity.AuthorEntity;
import com.api.library.entity.BookEntity;
import com.api.library.entity.PublisherEntity;
import com.api.library.exception.*;
import com.api.library.repository.AuthorRepository;
import com.api.library.repository.BookRepository;
import com.api.library.repository.PublisherRepository;
import com.api.library.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final PublisherRepository publisherRepository;

    @Override
    public BookDto findBookId(BigInteger bookId) {
        BookEntity book= bookRepository.findBookById(bookId)
                .orElseThrow(()-> new BookIdNotFoundException(bookId));
        AuthorEntity author = authorRepository.getAuthorById(book.getBookAuthor())
                .orElseThrow(()->new AuthorIdNotFoundException(book.getBookAuthor()));
        PublisherEntity publisher = publisherRepository.getPublisherIdById(book.getBookPublisher())
                .orElseThrow(()-> new PublisherIdNotFoundException(book.getBookPublisher()));

        BookDto bookDto = new BookDto();
        bookDto.setID(book.getBookId());
        bookDto.setTITLE(book.getBookTitle());
        bookDto.setAUTHOR(author.getAuthorName());
        bookDto.setPUBLISHER(publisher.getPublisherName());
        bookDto.setYEAR(book.getBookYear());
        bookDto.setGENRE(book.getBookGenre());
        bookDto.setAMOUNT(book.getBookAmount());
        return bookDto;
    }



    @Override
    public BookDto findBookByTitle(String bookTitle) {
        BookEntity book= bookRepository.findBookByTitle(bookTitle)
                .orElseThrow(()-> new BookTitleNotFoundException(bookTitle));
        AuthorEntity author = authorRepository.getAuthorById(book.getBookAuthor())
                .orElseThrow(()->new AuthorIdNotFoundException(book.getBookAuthor()));
        PublisherEntity publisher = publisherRepository.getPublisherIdById(book.getBookPublisher())
                .orElseThrow(()-> new PublisherIdNotFoundException(book.getBookPublisher()));

        BookDto bookDto = new BookDto();
        bookDto.setID(book.getBookId());
        bookDto.setTITLE(book.getBookTitle());
        bookDto.setAUTHOR(author.getAuthorName());
        bookDto.setPUBLISHER(publisher.getPublisherName());
        bookDto.setYEAR(book.getBookYear());
        bookDto.setGENRE(book.getBookGenre());
        bookDto.setAMOUNT(book.getBookAmount());
        return bookDto;
    }

    @Override
    public List<BookDto> getBooksByAuthor(BigInteger authorId) {
        AuthorEntity author = authorRepository.getAuthorById(authorId)
                .orElseThrow(()->new AuthorIdNotFoundException(authorId));
        List<BookEntity> booksByAuthor = bookRepository.findByAuthorId(authorId);
        List<BookDto> bookDTOs = new ArrayList<>();
        for (BookEntity bookEntity : booksByAuthor) {
            PublisherEntity publisher = publisherRepository.getPublisherIdById(bookEntity.getBookPublisher())
                    .orElseThrow(()-> new PublisherIdNotFoundException(bookEntity.getBookPublisher()));
            BookDto bookDto = new BookDto();
            bookDto.setID(bookEntity.getBookId());
            bookDto.setTITLE(bookEntity.getBookTitle());
            bookDto.setAUTHOR(author.getAuthorName());
            bookDto.setPUBLISHER(publisher.getPublisherName());
            bookDto.setYEAR(bookEntity.getBookYear());
            bookDto.setGENRE(bookEntity.getBookGenre());
            bookDto.setAMOUNT(bookEntity.getBookAmount());
            bookDTOs.add(bookDto);
        }
        return bookDTOs;
    }

    @Override
    public List<BookDto> getBooksByPublisher(BigInteger publisherId) {
        PublisherEntity publisher = publisherRepository.getPublisherIdById(publisherId)
                .orElseThrow(()->new PublisherIdNotFoundException(publisherId));
        List<BookEntity> booksByPublisher = bookRepository.findByPublisherId(publisherId);
        List<BookDto> bookDTOs = new ArrayList<>();
        for (BookEntity bookEntity : booksByPublisher) {
            AuthorEntity author = authorRepository.getAuthorById(bookEntity.getBookAuthor())
                    .orElseThrow(()-> new AuthorIdNotFoundException(bookEntity.getBookAuthor()));
            BookDto bookDto = new BookDto();
            bookDto.setID(bookEntity.getBookId());
            bookDto.setTITLE(bookEntity.getBookTitle());
            bookDto.setAUTHOR(author.getAuthorName());
            bookDto.setPUBLISHER(publisher.getPublisherName());
            bookDto.setYEAR(bookEntity.getBookYear());
            bookDto.setGENRE(bookEntity.getBookGenre());
            bookDto.setAMOUNT(bookEntity.getBookAmount());
            bookDTOs.add(bookDto);
        }
        return bookDTOs;
    }

    @Override
    public List<BookDto> getBooks() {

        List<BookEntity> booksList = bookRepository.listBooks();
        List<BookDto> bookDTOs = new ArrayList<>();
        for (BookEntity bookEntity : booksList) {
            PublisherEntity publisher = publisherRepository.getPublisherIdById(bookEntity.getBookPublisher())
                    .orElseThrow(()->new PublisherIdNotFoundException(bookEntity.getBookPublisher()));
            AuthorEntity author = authorRepository.getAuthorById(bookEntity.getBookAuthor())
                    .orElseThrow(()-> new AuthorIdNotFoundException(bookEntity.getBookAuthor()));
            BookDto bookDto = new BookDto();
            bookDto.setID(bookEntity.getBookId());
            bookDto.setTITLE(bookEntity.getBookTitle());
            bookDto.setAUTHOR(author.getAuthorName());
            bookDto.setPUBLISHER(publisher.getPublisherName());
            bookDto.setYEAR(bookEntity.getBookYear());
            bookDto.setGENRE(bookEntity.getBookGenre());
            bookDto.setAMOUNT(bookEntity.getBookAmount());
            bookDTOs.add(bookDto);
        }
        return bookDTOs;
    }

    @Override
    @Transactional
    public void insertBook(String title, BigInteger author, BigInteger publisher, String year, String genre, int amount) throws NameAlreadyExistException {
        BookEntity book=bookRepository.findBookByTitle(title).orElse(null);
        if(book==null){
            bookRepository.insertBook(title, author, publisher, year, genre, amount);
        }
        else if(Objects.equals(publisher, book.getBookPublisher())){
            throw new NameAlreadyExistException("Book title already exist");
        }
        else{
            bookRepository.insertBook(title, author, publisher, year, genre, amount);
        }
    }

    @Override
    @Transactional
    public void updateBook(String title, BigInteger author, BigInteger publisher, String year, String genre, int amount, BigInteger bookId) throws NotFoundException, NameAlreadyExistException {
        BookEntity bookById = bookRepository.findBookById(bookId).orElse(null);
        if (bookById == null) {
            throw new NotFoundException("Book not found");
        }
        bookRepository.updateBook(title, author, publisher, year, genre, amount, bookId);
    }

    @Override
    @Transactional
    public void deleteBook(BigInteger bookId) throws NotFoundException {
        BookEntity book = bookRepository.findBookById(bookId).orElse(null);
        if (book == null) {
            throw new NotFoundException("Book not found");
        }
        bookRepository.deleteBook(bookId);
    }
}
