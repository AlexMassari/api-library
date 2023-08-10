package com.api.library.service;

import com.api.library.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public interface AuthorService {
    void insertAuthor(String name);

    void updateAuthor(String authorName, BigInteger id) throws NotFoundException ;

    void deleteAuthor(BigInteger id) throws NotFoundException;
}
