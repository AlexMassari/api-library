package com.api.library.service;

import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public interface AuthorService {
    void insertAuthor(String name);

    void updateAuthor(String authorName, BigInteger id);
}
