package com.api.library.service;

import com.api.library.exception.NameAlreadyExistException;
import com.api.library.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public interface AuthorService {
    void insertAuthor(String authorName) throws NameAlreadyExistException;

    void updateAuthor(String authorName, BigInteger authorId) throws NotFoundException, NameAlreadyExistException;

    void deleteAuthor(BigInteger authorId) throws NotFoundException;
}
